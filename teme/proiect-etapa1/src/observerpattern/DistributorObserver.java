package observerpattern;

import transformdata.CalcDistributor;
import transformdata.CalcProducer;

import java.util.ArrayList;
import java.util.Comparator;

public class DistributorObserver extends Observer {
    public DistributorObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public final void update(final ArrayList<CalcDistributor> retainChProd,
                       final ArrayList<CalcProducer> sortGreenProd,
                       final ArrayList<CalcProducer> sortPriceProd,
                       final ArrayList<CalcProducer> sortQuantityProd) {
        retainChProd.sort(Comparator.comparingInt(CalcDistributor::getId));

        for (CalcDistributor cd : retainChProd) {
            for (CalcProducer cp : cd.getActualProd()) {
                Integer no = cd.getId();
                cp.getClientsId().remove(no);
                cp.getClients().remove(cd);
            }
            cd.getActualProd().clear();

            cd.chooseProducer(sortGreenProd, sortPriceProd, sortQuantityProd);
        }

        retainChProd.clear();
    }
}
