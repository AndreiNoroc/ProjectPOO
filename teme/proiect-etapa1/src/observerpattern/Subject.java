package observerpattern;

import transformdata.CalcDistributor;
import transformdata.CalcProducer;

import java.util.ArrayList;

public class Subject {
    private ArrayList<Observer> observers = new ArrayList<>();

    /**
     * Metoda notifica distribuitorii
     * @param retainChProd - distribuitorii care trebuie sa aleaga producatori noi
     * @param sortGreenProd - producatori sortati
     * @param sortPriceProd - producatori sortati
     * @param sortQuantityProd - producatori sortati
     */
    public final void setState(final ArrayList<CalcDistributor> retainChProd,
                         final ArrayList<CalcProducer> sortGreenProd,
                         final ArrayList<CalcProducer> sortPriceProd,
                         final ArrayList<CalcProducer> sortQuantityProd) {
        notifyAllObservers(retainChProd, sortGreenProd, sortPriceProd, sortQuantityProd);
    }

    /**
     * Metoda adauga in observer
     * @param observer - arraylist de observeri
     */
    public final void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * Notifica toti obseverii
     * @param retainChProd - distribuitorii care trebuie sa aleaga producatori noi
     * @param sortGreenProd - producatori sortati
     * @param sortPriceProd - producatori sortati
     * @param sortQuantityProd - producatori sortati
     */
    public final void notifyAllObservers(final ArrayList<CalcDistributor> retainChProd,
                                   final ArrayList<CalcProducer> sortGreenProd,
                                   final ArrayList<CalcProducer> sortPriceProd,
                                   final ArrayList<CalcProducer> sortQuantityProd) {
        for (Observer observer : observers) {
            observer.update(retainChProd, sortGreenProd, sortPriceProd, sortQuantityProd);
        }
    }
}
