package update;

import change.Change;
import consumer.Consumer;

import java.util.ArrayList;

public class MonthlyUpdate {
    private ArrayList<Consumer> newConsumers;
    private ArrayList<Change> costsChanges;

    public MonthlyUpdate() { }

    public MonthlyUpdate(final ArrayList<Consumer> newConsumers,
                         final ArrayList<Change> costsChanges) {
        this.newConsumers = newConsumers;
        this.costsChanges = costsChanges;
    }

    public final ArrayList<Consumer> getNewConsumers() {
        return newConsumers;
    }

    public final void setNewConsumers(final ArrayList<Consumer> newConsumers) {
        this.newConsumers = newConsumers;
    }

    public final ArrayList<Change> getCostsChanges() {
        return costsChanges;
    }

    public final void setCostsChanges(final ArrayList<Change> costsChanges) {
        this.costsChanges = costsChanges;
    }

    @Override
    public final String toString() {
        return "MonthlyUpdate{"
                +
                "newConsumers="
                +
                newConsumers
                +
                ", costsChanges="
                +
                costsChanges
                +
                '}';
    }
}
