import change.Change;
import change.ProducerChange;
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
import producers.OutProducer;
import producers.Producer;
import transformdata.CalcConsumer;
import transformdata.CalcDistributor;
import transformdata.CalcProducer;
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

        TypeFactory typeFactory = TypeFactory.getInstance();

        ArrayList<CalcProducer> producers = new ArrayList<>();
        ArrayList<CalcProducer> outProducers = new ArrayList<>();
        ArrayList<Producer> initsProducer = input.getInitialData().getProducers();

        TypePerson type0 = typeFactory.getType(null, null, initsProducer);

        type0.read(null, null, initsProducer,
                null, null, producers,
                null, null, outProducers);

        ArrayList<CalcProducer> sortGreenProd = new ArrayList<>(producers);
        sortGreenProd.sort(Main::compareGreen);

        ArrayList<CalcProducer> sortPriceProd = new ArrayList<>(producers);
        sortPriceProd.sort(Main::comparePrice);

        ArrayList<CalcProducer> sortQuantityProd = new ArrayList<>(producers);
        sortQuantityProd.sort(Main::compareQuantity);

        ArrayList<CalcDistributor> distributors = new ArrayList<>();
        ArrayList<CalcDistributor> outDistributors = new ArrayList<>();
        ArrayList<Distributor> initsDistributor = input.getInitialData().getDistributors();

        TypePerson type1 = typeFactory.getType(null, initsDistributor, initsProducer);

        type1.read(null, initsDistributor, null,
                null, distributors , null,
                null, outDistributors,null);

        for (CalcDistributor cd:distributors) {
            cd.chooseProducer(sortGreenProd, sortPriceProd, sortQuantityProd);
            cd.setContractPrice();
        }

        distributors.sort(Main::compare);

        ArrayList<CalcConsumer> consumers = new ArrayList<>();
        ArrayList<CalcConsumer> outConsumer = new ArrayList<>();
        ArrayList<Consumer> initsConsumer = input.getInitialData().getConsumers();

        TypePerson type2 = typeFactory.getType(initsConsumer, initsDistributor, initsProducer);
        type2.read(initsConsumer, initsDistributor, initsProducer,
                consumers, distributors, producers,
                outConsumer, outDistributors, outProducers);

        distributors.get(0).getClients().addAll(consumers);

        for (CalcDistributor cd : distributors) {
            cd.setActualBudget();
            cd.setContractPrice();
        }

        ArrayList<CalcConsumer> rmvConsumer = new ArrayList<>();
        ArrayList<CalcDistributor> rmvDistributor = new ArrayList<>();
        ArrayList<MonthlyUpdate> updates = input.getMonthlyUpdates();

        int len = 0;

        for (MonthlyUpdate u : updates) {
            len++;

            ArrayList<Consumer> newConsumers = u.getNewConsumers();
            if (newConsumers.size() != 0) {
                for (Consumer c : newConsumers) {
                    CalcConsumer cc = new CalcConsumer(c.getId(),
                            c.getInitialBudget(), c.getMonthlyIncome());
                    consumers.add(cc);
                    outConsumer.add(cc);
                }
            }

            ArrayList<ProducerChange> prodChanges = u.getProducerChanges();
            if (prodChanges.size() != 0) {
                for (ProducerChange p : prodChanges) {
                    for (CalcProducer cp : producers) {
                        if (p.getId() == cp.getId()) {
                            cp.setEnergyPerDistributor(p.getEnergyPerDistributor());
                        }
                    }
                }
            }


            ArrayList<Change> changes = u.getDistributorChanges();
            if (changes.size() != 0) {
                for (Change ch : changes) {
                    for (CalcDistributor d : distributors) {
                        if (ch.getId() == d.getId()) {
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

            for (CalcProducer cp : producers) {
                cp.makeMonthStat(len);
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
                    cd.getEnergyNeededKW(), cd.getFinalPrice(),
                    cd.getInitialBudget(), cd.getProducerStrategy(), cd.isBankrupt(), contracts);
            lastDistributors.add(distributor);
        }
        lastDistributors.sort(Comparator.comparingInt(OutDistributor::getId));

        ArrayList<OutProducer> lastProducers = new ArrayList<>();
        for (CalcProducer cp : outProducers) {
            OutProducer producer = new OutProducer(cp.getId(), cp.getMaxDistributors(), cp.getPriceKW(), cp.getEnergyType(), cp.getEnergyPerDistributor(), cp.getMs());
            lastProducers.add(producer);
        }

        OutputData output = new OutputData();
        output.setConsumers(lastConsumers);
        output.setDistributors(lastDistributors);
        output.setEnergyProducers(lastProducers);

        System.out.println(output);

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

    private static int compareGreen(final CalcProducer p1, final CalcProducer p2) {
        if (!p1.getEnergyType().isRenewable() && p2.getEnergyType().isRenewable()) {
            return 1;
        } else if (p1.getEnergyType().isRenewable() && p2.getEnergyType().isRenewable()) {
            if (p1.getPriceKW() > p2.getPriceKW()) {
                return 1;
            } else if (p1.getPriceKW() == p2.getPriceKW()) {
                if (p1.getEnergyPerDistributor() > p2.getEnergyPerDistributor()) {
                    return 1;
                } else if (p1.getEnergyPerDistributor() == p2.getEnergyPerDistributor()) {
                    if (p1.getId() > p2.getId()) {
                        return 1;
                    }
                }
            }
        }

        return -1;
    }

    private static int comparePrice(final CalcProducer p1, final CalcProducer p2) {
        if (p1.getPriceKW() > p2.getPriceKW()) {
            return 1;
        } else if (p1.getPriceKW() == p2.getPriceKW()) {
            if (p1.getEnergyPerDistributor() > p2.getEnergyPerDistributor()) {
                return 1;
            } else if (p1.getEnergyPerDistributor() == p2.getEnergyPerDistributor()) {
                if (p1.getId() > p2.getId()) {
                    return 1;
                }
            }
        }

        return -1;
    }

    private static int compareQuantity(final CalcProducer p1, final CalcProducer p2) {
        if (p1.getEnergyPerDistributor() > p2.getEnergyPerDistributor()) {
            return 1;
        } else if (p1.getEnergyPerDistributor() == p2.getEnergyPerDistributor()) {
            if (p1.getId() > p2.getId()) {
                return 1;
            }
        }

        return -1;
    }
}
