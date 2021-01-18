package strategypattern;

import transformdata.CalcDistributor;
import transformdata.CalcProducer;

import java.util.ArrayList;

public interface Strategy {
    /**
     * Metoda alege producatorii doriti de distribuitor
     * @param list - lista producatorilor sortati
     * @param distr - distribuitorul care alege
     */
    void chooseStrategy(ArrayList<CalcProducer> list, CalcDistributor distr);
}
