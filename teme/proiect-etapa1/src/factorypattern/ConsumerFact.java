package factorypattern;

import consumer.Consumer;
import distributor.Distributor;
import transformdata.CalcConsumer;
import transformdata.CalcDistributor;

import java.util.ArrayList;

public class ConsumerFact implements TypePerson {
    /**
     * Metoda initializeaza valorile consumatorilor
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
        for (Consumer c : cons) {
            CalcConsumer cc = new CalcConsumer(c.getId(),
                    c.getInitialBudget(), c.getMonthlyIncome());
            cc.chooseDistributor(clcDistrs.get(0));
            cc.setActual();
            clcCons.add(cc);
            allCons.add(cc);
        }
    }
}
