import change.Change;
import com.fasterxml.jackson.databind.ObjectMapper;
import consumer.Consumer;
import consumer.OutConsumer;
import contract.Contract;
import distributor.Distributor;
import distributor.OutDistributor;
import factorypattern.TypeFactory;
import factorypattern.TypePerson;
import input.InputData;
import output.OutputData;
import transformdata.CalcConsumer;
import transformdata.CalcDistributor;
import update.MonthlyUpdate;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

public final class Main {

    private Main() { }

    /**
     * Metoda principala in care incepe rularea programului
     * @param args - contine fisierele de input si output
     */
    public static void main(final String[] args) throws Exception {
        ObjectMapper obMap = new ObjectMapper();
        InputData input = obMap.readValue(new File(args[0]), InputData.class);

        TypeFactory typeFactory = new TypeFactory();

        ArrayList<CalcDistributor> distributors = new ArrayList<>();
        ArrayList<CalcDistributor> outDistributors = new ArrayList<>();
        ArrayList<Distributor> initsDistributor = input.getInitialData().getDistributors();

        TypePerson type1 = typeFactory.getType(null,
                initsDistributor, null,
                distributors, null, outDistributors);
        type1.read(null, initsDistributor, null, distributors, null, outDistributors);

        distributors.sort(Main::compare);

        ArrayList<CalcConsumer> consumers = new ArrayList<>();
        ArrayList<CalcConsumer> outConsumer = new ArrayList<>();
        ArrayList<Consumer> initsConsumer = input.getInitialData().getConsumers();

        TypePerson type2 = typeFactory.getType(initsConsumer,
                initsDistributor, consumers, distributors,
                outConsumer, outDistributors);
        type2.read(initsConsumer, initsDistributor, consumers,
                distributors, outConsumer, outDistributors);

        distributors.get(0).getClients().addAll(consumers);

        for (CalcDistributor cd : distributors) {
            cd.setActualBudget();
            cd.setContractPrice();
        }

        ArrayList<CalcConsumer> rmvConsumer = new ArrayList<>();
        ArrayList<CalcDistributor> rmvDistributor = new ArrayList<>();
        ArrayList<MonthlyUpdate> updates = input.getMonthlyUpdates();

        for (MonthlyUpdate u : updates) {
            ArrayList<Consumer> newConsumers = u.getNewConsumers();
            if (newConsumers.size() != 0) {
                for (Consumer c : newConsumers) {
                    CalcConsumer cc = new CalcConsumer(c.getId(),
                            c.getInitialBudget(), c.getMonthlyIncome());
                    consumers.add(cc);
                    outConsumer.add(cc);
                }
            }

            ArrayList<Change> changes = u.getCostsChanges();
            if (changes.size() != 0) {
                for (Change ch : changes) {
                    for (CalcDistributor d : distributors) {
                        if (ch.getId() == d.getId()) {
                            d.setInitialProductionCost(ch.getProductionCost());
                            d.setInitialInfrastructureCost(ch.getInfrastructureCost());
                        }
                    }
                }
            }

            for (CalcDistributor cd : distributors) {
                cd.setContractPrice();
            }

            distributors.sort(Main::compare);


            for (CalcConsumer cc : consumers) {
                if (cc.getPriceDistr() != 0) {
                    if (cc.getContractLen() == 0) {
                        cc.getActualDistr().getClients().remove(cc);

                        cc.setOldDistr(cc.getActualDistr());
                        cc.setPriceOldDistr(cc.getPriceDistr());
                        cc.setActualDistr(distributors.get(0));
                        cc.setContractLen(distributors.get(0).getContractLength());
                        cc.setPriceDistr(distributors.get(0).getFinalPrice());
                        distributors.get(0).getClients().add(cc);
                    }

                    cc.setActual();

                    if (cc.isBankrupt()) {
                        rmvConsumer.add(cc);
                    } else {
                        cc.setOldDistr(cc.getActualDistr());
                        cc.setPriceOldDistr(cc.getPriceDistr());
                    }
                }
            }

            for (CalcConsumer cc : consumers) {
                if (cc.getContractLen() == 0) {
                    if (cc.getPriceDistr() == 0) {
                        distributors.get(0).getClients().add(cc);
                        cc.chooseDistributor(distributors.get(0));
                        cc.setActual();
                    }
                }
            }

            for (CalcDistributor cd : distributors) {
                cd.setActualBudget();
                if (cd.isBankrupt()) {
                    rmvDistributor.add(cd);
                }
            }

            if (rmvConsumer.size() != 0) {
                for (CalcConsumer cc : rmvConsumer) {
                    cc.getActualDistr().getClients().remove(cc);
                    consumers.remove(cc);
                }

                rmvConsumer.clear();
            }

            if (rmvDistributor.size() != 0) {
                for (CalcDistributor cd : rmvDistributor) {
                    if (cd.getClients().size() != 0) {
                        for (CalcConsumer cc : cd.getClients()) {
                            cc.setContractLen(0);
                        }
                        cd.getClients().clear();
                    }
                    distributors.remove(cd);
                }

                rmvDistributor.clear();
            }
        }

        ArrayList<OutConsumer> lastConsumers = new ArrayList<>();
        for (CalcConsumer cc : outConsumer) {
            OutConsumer consumer = new OutConsumer(cc.getId(),
                    cc.isBankrupt(), cc.getInitialBudget());
            lastConsumers.add(consumer);
        }
        lastConsumers.sort(Comparator.comparingInt(OutConsumer::getId));

        ArrayList<OutDistributor> lastDistributors = new ArrayList<>();
        for (CalcDistributor cd : outDistributors) {
            ArrayList<Contract> contracts = new ArrayList<>();
            for (CalcConsumer cc : cd.getClients()) {
                Contract contract = new Contract(cc.getId(),
                        cc.getPriceDistr(), cc.getContractLen());
                contracts.add(contract);
            }

            OutDistributor distributor = new OutDistributor(cd.getId(),
                    cd.getInitialBudget(), cd.isBankrupt(), contracts);
            lastDistributors.add(distributor);
        }
        lastDistributors.sort(Comparator.comparingInt(OutDistributor::getId));

        OutputData output = new OutputData();
        output.setConsumers(lastConsumers);
        output.setDistributors(lastDistributors);

        obMap.writerWithDefaultPrettyPrinter().writeValue(new File(args[1]), output);
    }

    /**
     * Metoda compara preturile distributorilor
     * @param c1 - pretul primului distr
     * @param c2 - pretul celui de al doilea
     * @return Diferenta dintr preturi
     */
    private static int compare(final CalcDistributor c1, final CalcDistributor c2) {
        return c1.getFinalPrice() - c2.getFinalPrice();
    }
}
