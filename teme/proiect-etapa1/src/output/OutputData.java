package output;

import consumer.OutConsumer;
import distributor.OutDistributor;
import producers.OutProducer;

import java.util.ArrayList;

public class OutputData {
    private ArrayList<OutConsumer> consumers;
    private ArrayList<OutDistributor> distributors;
    private ArrayList<OutProducer> energyProducers;

    public OutputData() { }

    public OutputData(final ArrayList<OutConsumer> consumers,
                      final ArrayList<OutDistributor> distributors,
                      final ArrayList<OutProducer> energyProducers) {
        this.consumers = consumers;
        this.distributors = distributors;
        this.energyProducers = energyProducers;
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

    public final ArrayList<OutProducer> getEnergyProducers() {
        return energyProducers;
    }

    public final void setEnergyProducers(final ArrayList<OutProducer> energyProducers) {
        this.energyProducers = energyProducers;
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
                ", energyProducers="
                +
                energyProducers
                +
                '}';
    }
}
