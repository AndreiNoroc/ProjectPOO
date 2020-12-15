package factorypattern;

import consumer.Consumer;
import distributor.Distributor;
import transformdata.CalcConsumer;
import transformdata.CalcDistributor;

import java.util.ArrayList;

public final class TypeFactory {
    private static TypeFactory instance = null;

    private TypeFactory() { }

    /**
     * Singleton patter
     * @return O instanta
     */
    public static TypeFactory getInstance() {
        if (instance == null) {
            instance = new TypeFactory();
        }
        return instance;
    }
    /**
     * Metoda verifica actiunea dorita
     * @param cons - lista de input a consumatorilor
     * @param distrs - lista de input a distribuitorilor
     * @param clcCons - lista de consumatori prelucrata
     * @param clcDistrs - lista de distribuitori prelucrata
     * @param allCons - lista tuturor consumatorilor
     * @param allDistrs - lista tuturor distribuitorilor
     * @return O instanta a unui obiect care construieste
     * o lista de consumatori sau distribuitori prelucrati
     */
    public TypePerson getType(final ArrayList<Consumer> cons,
                              final ArrayList<Distributor> distrs,
                              final ArrayList<CalcConsumer> clcCons,
                              final ArrayList<CalcDistributor> clcDistrs,
                              final ArrayList<CalcConsumer> allCons,
                              final ArrayList<CalcDistributor> allDistrs) {
        if (cons == null && distrs == null) {
            return null;
        }

        if (distrs != null && cons == null) {
            return new DistributorFact();
        } else if (distrs != null && cons != null) {
            return new ConsumerFact();
        }

        return null;
    }
}
