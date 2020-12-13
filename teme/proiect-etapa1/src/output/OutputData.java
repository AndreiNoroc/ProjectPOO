package output;

import consumer.OutConsumer;
import distributor.OutDistributor;

import java.util.ArrayList;

public class OutputData {
    private ArrayList<OutConsumer> consumers;
    private ArrayList<OutDistributor> distributors;

    public OutputData() { }

    public OutputData(ArrayList<OutConsumer> consumers, ArrayList distributors) {
        this.consumers = consumers;
        this.distributors = distributors;
    }

    public ArrayList<OutConsumer> getConsumers() {
        return consumers;
    }

    public void setConsumers(ArrayList<OutConsumer> consumers) {
        this.consumers = consumers;
    }

    public ArrayList<OutDistributor> getDistributors() {
        return distributors;
    }

    public void setDistributors(ArrayList<OutDistributor> distributors) {
        this.distributors = distributors;
    }

    @Override
    public String toString() {
        return "OutputData{" +
                "consumers=" + consumers +
                ", distributors=" + distributors +
                '}';
    }
}
