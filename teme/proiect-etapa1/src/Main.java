import change.Change;
import com.fasterxml.jackson.databind.ObjectMapper;
import consumer.Consumer;
import consumer.OutConsumer;
import contract.Contract;
import distributor.Distributor;
import distributor.OutDistributor;
import input.InputData;
import output.OutputData;
import transformdata.CalcConsumer;
import transformdata.CalcDistributor;
import update.MonthlyUpdate;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println(args[0]);
        ObjectMapper obMap = new ObjectMapper();
        InputData input = obMap.readValue(new File(args[0]), InputData.class);
        System.out.println(input);

        ArrayList<CalcDistributor> distributors = new ArrayList<>();
        ArrayList<Distributor> initsDistributor = input.getInitialData().getDistributors();
        for (Distributor d : initsDistributor) {
            CalcDistributor cd = new CalcDistributor(d.getId(), d.getContractLength(), d.getInitialBudget(), d.getInitialInfrastructureCost(), d.getInitialProductionCost());
            cd.setFinalPrice(d.getInitialInfrastructureCost() + d.getInitialProductionCost() + (int) Math.round(Math.floor(0.2 * d.getInitialProductionCost())));
            distributors.add(cd);
        }

        distributors.sort(Main::compare);

        ArrayList<CalcConsumer> consumers = new ArrayList<>();
        ArrayList<Consumer> initsConsumer = input.getInitialData().getConsumers();
        for (Consumer c : initsConsumer) {
            CalcConsumer cc = new CalcConsumer(c.getId(), c.getInitialBudget(), c.getMonthlyIncome(), distributors.get(0).getFinalPrice(), distributors.get(0).getContractLength());
            cc.setActual();
            consumers.add(cc);
        }

        distributors.get(0).getClients().addAll(consumers);

        for (CalcDistributor cd : distributors) {
            cd.setActualBudget();
        }


        ArrayList<MonthlyUpdate> updates = input.getMonthlyUpdates();
        for (MonthlyUpdate u : updates) {
            ArrayList<Change> changes = u.getCostsChanges();

            for (Change ch : changes) {
                for (CalcDistributor d : distributors) {
                    if (ch.getId() == d.getId()) {
                        d.setInitialInfrastructureCost(ch.getInfrastructureCost());
                        d.setInitialProductionCost(ch.getProductionCost());
                        d.setContractPrice();
                        break;
                    }
                }
            }

            distributors.sort(Main::compare);

            ArrayList<Consumer> newConsumers = u.getNewConsumers();
            ArrayList<CalcConsumer> newClients = distributors.get(0).getClients();
            for (Consumer c : newConsumers) {
                CalcConsumer cc = new CalcConsumer(c.getId(), c.getInitialBudget(), c.getMonthlyIncome(), distributors.get(0).getFinalPrice(), distributors.get(0).getContractLength());
                consumers.add(cc);
                newClients.add(cc);
            }

            for (CalcConsumer cc : consumers) {
                if (cc.getContractLen() == 0) {
                    for (CalcDistributor cd : distributors) {
                        if (cd.getClients().contains(cc)) {
                            cd.getClients().remove(cc);
                            break;
                        }
                    }

                    cc.setContractLen(distributors.get(0).getContractLength());
                    cc.setInitialBudget(distributors.get(0).getFinalPrice());
                    distributors.get(0).getClients().add(cc);
                }

                cc.setActual();
            }

            for (CalcDistributor cd : distributors) {
                cd.setActualBudget();
            }
        }

        ArrayList<OutConsumer> lastConsumers = new ArrayList<>();
        for (CalcConsumer cc : consumers) {
            OutConsumer consumer = new OutConsumer(cc.getId(), cc.isBankrupt(), cc.getInitialBudget());
            lastConsumers.add(consumer);
        }
        lastConsumers.sort(Comparator.comparingInt(OutConsumer::getId));

        ArrayList<OutDistributor> lastDistributors = new ArrayList<>();
        for (CalcDistributor cd : distributors) {
            ArrayList<Contract> contracts = new ArrayList<>();
            for (CalcConsumer cc : cd.getClients()) {
                Contract contract = new Contract(cc.getId(), cc.getPriceDistr(), cc.getContractLen());
                contracts.add(contract);
            }

            OutDistributor distributor = new OutDistributor(cd.getId(), cd.getInitialBudget(), cd.isBankrupt(), contracts);
            lastDistributors.add(distributor);
        }
        lastDistributors.sort(Comparator.comparingInt(OutDistributor::getId));

        OutputData output = new OutputData();
        output.setConsumers(lastConsumers);
        output.setDistributors(lastDistributors);

        obMap.writeValue(new File(args[1]), output);
    }

    private static int compare(CalcDistributor c1, CalcDistributor c2) {
        return c1.getFinalPrice() - c2.getFinalPrice();
    }
}
