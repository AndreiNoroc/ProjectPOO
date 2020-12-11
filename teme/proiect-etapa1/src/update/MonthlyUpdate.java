package update;

import change.Change;
import consumer.Consumer;

import java.util.ArrayList;

public class MonthlyUpdate {
    private ArrayList<Consumer> newConsumers;
    private ArrayList<Change> costsChanges;

    public MonthlyUpdate() { }

    public MonthlyUpdate(ArrayList<Consumer> newConsumers, ArrayList<Change> costsChanges) {
        this.newConsumers = newConsumers;
        this.costsChanges = costsChanges;
    }

    public ArrayList<Consumer> getNewConsumers() {
        return newConsumers;
    }

    public void setNewConsumers(ArrayList<Consumer> newConsumers) {
        this.newConsumers = newConsumers;
    }

    public ArrayList<Change> getCostsChanges() {
        return costsChanges;
    }

    public void setCostsChanges(ArrayList<Change> costsChanges) {
        this.costsChanges = costsChanges;
    }

    @Override
    public String toString() {
        return "MonthlyUpdate{" +
                "newConsumers=" + newConsumers +
                ", costsChanges=" + costsChanges +
                '}';
    }
}
