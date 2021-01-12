package factorypattern;

import consumer.Consumer;
import distributor.Distributor;
import producers.Producer;
import transformdata.CalcConsumer;
import transformdata.CalcDistributor;
import transformdata.CalcProducer;

import java.util.ArrayList;

public interface TypePerson {
    /**
     * Semnatura functiei care va fii rescrisa
     * @param cons - lista de input a consumatorilor
     * @param distrs - lista de input a distribuitorilor
     * @param clcCons - lista de consumatori prelucrata
     * @param clcDistrs - lista de distribuitori prelucrata
     * @param allCons - lista tuturor consumatorilor
     * @param allDistrs - lista tuturor distribuitorilor
     */
    void read(ArrayList<Consumer> cons, ArrayList<Distributor> distrs,
              ArrayList<Producer> prods,
              ArrayList<CalcConsumer> clcCons, ArrayList<CalcDistributor> clcDistrs,
              ArrayList<CalcProducer> clcProds,
              ArrayList<CalcConsumer> allCons, ArrayList<CalcDistributor> allDistrs,
              ArrayList<CalcProducer> allProds);
}
