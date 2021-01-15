package monthlystats;

import java.util.ArrayList;

public class MonthlyStat {
    private int month;
    private ArrayList<Integer> distributorsIds;

    public MonthlyStat(int month, ArrayList<Integer> distributorsIds) {
        this.month = month;
        this.distributorsIds = distributorsIds;
    }

    public final int getMonth() {
        return month;
    }

    public final void setMonth(final int month) {
        this.month = month;
    }

    public final ArrayList<Integer> getDistributorsIds() {
        return distributorsIds;
    }

    public final void setDistributorsIds(final ArrayList<Integer> distributorsIds) {
        this.distributorsIds = distributorsIds;
    }

    @Override
    public final String toString() {
        return "MonthlyStat{"
                +
                "month="
                +
                month
                +
                ", distributorsIds="
                +
                distributorsIds
                +
                '}';
    }
}
