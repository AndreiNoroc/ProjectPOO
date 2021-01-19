package observerpattern;

import transformdata.CalcDistributor;
import transformdata.CalcProducer;

import java.util.ArrayList;

public abstract class Observer {
    protected Subject subject;

    /**
     * Metoda updeataza producatorii alesi de distribuitori.
     * @param retainChProd - distribuitorii care trebuie sa aleaga producatori noi
     * @param sortGreenProd - producatori sortati
     * @param sortPriceProd - producatori sortati
     * @param sortQuantityProd - producatori sortati
     */
    public abstract void update(ArrayList<CalcDistributor> retainChProd,
                                ArrayList<CalcProducer> sortGreenProd,
                                ArrayList<CalcProducer> sortPriceProd,
                                ArrayList<CalcProducer> sortQuantityProd);
}
