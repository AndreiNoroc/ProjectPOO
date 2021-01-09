package factorypattern;

import consumer.Consumer;
import distributor.Distributor;
import producers.Producer;
import transformdata.CalcConsumer;
import transformdata.CalcDistributor;
import transformdata.CalcProducer;

import java.util.ArrayList;

public class ProducerFact implements TypePerson {
    @Override
    public void read(final ArrayList<Consumer> cons, final ArrayList<Distributor> distrs,
                     final ArrayList<Producer> prods, final ArrayList<CalcConsumer> clcCons,
                     final ArrayList<CalcDistributor> clcDistrs, final ArrayList<CalcProducer> clcProds,
                     final ArrayList<CalcConsumer> allCons, final ArrayList<CalcDistributor> allDistrs,
                     final ArrayList<CalcProducer> allProds) {
        for (Producer p:prods) {
            CalcProducer cp = new CalcProducer(p.getId(), p.getEnergyType(),
                    p.getMaxDistributors(), p.getPriceKW(),
                    p.getEnergyPerDistributor());
            clcProds.add(cp);
            allProds.add(cp);
        }
    }
}
