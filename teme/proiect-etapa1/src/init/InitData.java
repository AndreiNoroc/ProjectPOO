package init;

import consumer.Consumer;
import distributor.Distributor;

import java.util.ArrayList;

public class InitData {
    private ArrayList<Consumer> consumers;
    private ArrayList<Distributor> distributors;

    public InitData() { }

    public InitData(final ArrayList<Consumer> consumers,
                    final ArrayList<Distributor> distributors) {
        this.consumers = consumers;
        this.distributors = distributors;
    }

    public final ArrayList<Consumer> getConsumers() {
        return consumers;
    }

    public final void setConsumers(final ArrayList<Consumer> consumers) {
        this.consumers = consumers;
    }

    public final ArrayList<Distributor> getDistributors() {
        return distributors;
    }

    public final void setDistributors(final ArrayList<Distributor> distributors) {
        this.distributors = distributors;
    }

    @Override
    public final String toString() {
        return "initData{"
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
