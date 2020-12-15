package input;

import init.InitData;
import update.MonthlyUpdate;

import java.util.ArrayList;

public class InputData {
    private int numberOfTurns;
    private InitData initialData;
    private ArrayList<MonthlyUpdate> monthlyUpdates;

    public InputData() { }

    public InputData(final int numberOfTurns, final InitData initialData,
                     final ArrayList<MonthlyUpdate> monthlyUpdates) {
        this.numberOfTurns = numberOfTurns;
        this.initialData = initialData;
        this.monthlyUpdates = monthlyUpdates;
    }

    public final int getNumberOfTurns() {
        return numberOfTurns;
    }

    public final void setNumberOfTurns(final int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    public final InitData getInitialData() {
        return initialData;
    }

    public final void setInitialData(final InitData initialData) {
        this.initialData = initialData;
    }

    public final ArrayList<MonthlyUpdate> getMonthlyUpdates() {
        return monthlyUpdates;
    }

    public final void setMonthlyUpdates(final ArrayList<MonthlyUpdate> monthlyUpdates) {
        this.monthlyUpdates = monthlyUpdates;
    }

    @Override
    public final String toString() {
        return "InputData{"
                +
                "numberOfTurns="
                +
                numberOfTurns
                +
                ", initialData="
                +
                initialData
                +
                ", monthlyUpdates="
                +
                monthlyUpdates
                +
                '}';
    }
}
