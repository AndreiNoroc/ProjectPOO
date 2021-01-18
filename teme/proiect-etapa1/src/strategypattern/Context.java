package strategypattern;

import transformdata.CalcDistributor;
import transformdata.CalcProducer;

import java.util.ArrayList;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Metoda executa functia de alegere
     * @param list - lista producatorilor sortati
     * @param distr - distribuitorul care alege
     */
    public final void executeStrategy(ArrayList<CalcProducer> list, CalcDistributor distr) {
        strategy.chooseStrategy(list, distr);
    }
}
