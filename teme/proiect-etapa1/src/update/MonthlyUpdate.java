package update;

import change.Change;
import change.ProducerChange;
import consumer.Consumer;

import java.util.ArrayList;

public class MonthlyUpdate {
    private ArrayList<Consumer> newConsumers;
    private ArrayList<Change> distributorChanges;
    private ArrayList<ProducerChange> producerChanges;

    public MonthlyUpdate() { }

    public MonthlyUpdate(final ArrayList<Consumer> newConsumers,
                         final ArrayList<Change> distributorChanges,
                         final ArrayList<ProducerChange> producerChanges) {
        this.newConsumers = newConsumers;
        this.distributorChanges = distributorChanges;
        this.producerChanges = producerChanges;
    }

    public final ArrayList<Consumer> getNewConsumers() {
        return newConsumers;
    }

    public final void setNewConsumers(final ArrayList<Consumer> newConsumers) {
        this.newConsumers = newConsumers;
    }

    public final ArrayList<Change> getDistributorChanges() {
        return distributorChanges;
    }

    public final void setDistributorChanges(final ArrayList<Change> distributorChanges) {
        this.distributorChanges = distributorChanges;
    }

    public final ArrayList<ProducerChange> getProducerChanges() {
        return producerChanges;
    }

    public final void setProducerChanges(final ArrayList<ProducerChange> producerChanges) {
        this.producerChanges = producerChanges;
    }

    @Override
    public final String toString() {
        return "MonthlyUpdate{"
                +
                "newConsumers="
                +
                newConsumers
                +
                ", distributorChanges="
                +
                distributorChanges
                +
                ", producerChanges="
                +
                producerChanges
                +
                '}';
    }
}
