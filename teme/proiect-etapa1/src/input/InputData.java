package input;

import init.initData;
import update.MonthlyUpdate;

import java.util.ArrayList;

public class InputData {
    private int numberOfTurns;
    private initData initialData;
    private ArrayList<MonthlyUpdate> monthlyUpdates;

    public InputData() { }

    public InputData(int numberOfTurns, initData initialData, ArrayList<MonthlyUpdate> monthlyUpdates) {
        this.numberOfTurns = numberOfTurns;
        this.initialData = initialData;
        this.monthlyUpdates = monthlyUpdates;
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    public initData getInitialData() {
        return initialData;
    }

    public void setInitialData(initData initialData) {
        this.initialData = initialData;
    }

    public ArrayList<MonthlyUpdate> getMonthlyUpdates() {
        return monthlyUpdates;
    }

    public void setMonthlyUpdates(ArrayList<MonthlyUpdate> monthlyUpdates) {
        this.monthlyUpdates = monthlyUpdates;
    }

    @Override
    public String toString() {
        return "InputData{" +
                "numberOfTurns=" + numberOfTurns +
                ", initialData=" + initialData +
                ", monthlyUpdates=" + monthlyUpdates +
                '}';
    }
}
