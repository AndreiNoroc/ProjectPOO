package init;

import consumer.Consumer;
import distributor.Distributor;
import producers.Producer;

import java.util.ArrayList;

public class InitData {
    private ArrayList<Consumer> consumers;
    private ArrayList<Distributor> distributors;
    private ArrayList<Producer> producers;

    public InitData() { }

    public InitData(final ArrayList<Consumer> consumers,
                    final ArrayList<Distributor> distributors,
                    final ArrayList<Producer> producers) {
        this.consumers = consumers;
        this.distributors = distributors;
        this.producers = producers;
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

    public final ArrayList<Producer> getProducers() {
        return producers;
    }

    public final void setProducers(final ArrayList<Producer> producers) {
        this.producers = producers;
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
                ", producers="
                +
                producers
                +
                '}';
    }
}
