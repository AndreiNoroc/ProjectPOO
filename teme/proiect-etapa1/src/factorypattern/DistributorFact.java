package factorypattern;

import consumer.Consumer;
import distributor.Distributor;
import transformdata.CalcConsumer;
import transformdata.CalcDistributor;

import java.util.ArrayList;

public class DistributorFact implements TypePerson {
    /**
     * Metoda initializeaza valorile distribuitorilor
     * @param cons - lista de input a consumatorilor
     * @param distrs - lista de input a distribuitorilor
     * @param clcCons - lista de consumatori prelucrata
     * @param clcDistrs - lista de distribuitori prelucrata
     * @param allCons - lista tuturor consumatorilor
     * @param allDistrs - lista tuturor distribuitorilor
     */
    @Override
    public void read(final ArrayList<Consumer> cons, final ArrayList<Distributor> distrs,
                     final ArrayList<CalcConsumer> clcCons,
                     final ArrayList<CalcDistributor> clcDistrs,
                     final ArrayList<CalcConsumer> allCons,
                     final ArrayList<CalcDistributor> allDistrs) {
        for (Distributor d : distrs) {
            CalcDistributor cd = new CalcDistributor(d.getId(), d.getContractLength(),
                    d.getInitialBudget(), d.getInitialInfrastructureCost(),
                    d.getInitialProductionCost());
            cd.setContractPrice();
            clcDistrs.add(cd);
            allDistrs.add(cd);
        }
    }
}
