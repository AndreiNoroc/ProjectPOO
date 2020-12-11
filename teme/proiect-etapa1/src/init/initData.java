package init;

import consumer.Consumer;
import distributor.Distributor;

import java.util.ArrayList;

public class initData {
    private ArrayList<Consumer> consumers;
    private ArrayList<Distributor> distributors;

    public initData() {}

    public initData(ArrayList<Consumer> consumers, ArrayList<Distributor> distributors) {
        this.consumers = consumers;
        this.distributors = distributors;
    }

    public ArrayList<Consumer> getConsumers() {
        return consumers;
    }

    public void setConsumers(ArrayList<Consumer> consumers) {
        this.consumers = consumers;
    }

    public ArrayList<Distributor> getDistributors() {
        return distributors;
    }

    public void setDistributors(ArrayList<Distributor> distributors) {
        this.distributors = distributors;
    }

    @Override
    public String toString() {
        return "initData{" +
                "consumers=" + consumers +
                ", distributors=" + distributors +
                '}';
    }
}
