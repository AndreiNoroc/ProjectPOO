package output;

import consumer.OutConsumer;
import distributor.OutDistributor;

import java.util.ArrayList;

public class OutputData {
    private ArrayList<OutConsumer> consumers;
    private ArrayList<OutDistributor> distributors;

    public OutputData() { }

    public OutputData(final ArrayList<OutConsumer> consumers, final ArrayList distributors) {
        this.consumers = consumers;
        this.distributors = distributors;
    }

    public final ArrayList<OutConsumer> getConsumers() {
        return consumers;
    }

    public final void setConsumers(final ArrayList<OutConsumer> consumers) {
        this.consumers = consumers;
    }

    public final ArrayList<OutDistributor> getDistributors() {
        return distributors;
    }

    public final void setDistributors(final ArrayList<OutDistributor> distributors) {
        this.distributors = distributors;
    }

    @Override
    public final String toString() {
        return "OutputData{"
                +
                "consumers="
                +
                consumers
                +
                ", distributors="
                +
                distributors
                +
                '}';
    }
}
