package consumer;

public class OutConsumer {
    private int id;
    private boolean isBankrupt;
    private int budget;

    public OutConsumer() { }

    public OutConsumer(final int id, final boolean isBankrupt, final int budget) {
        this.id = id;
        this.isBankrupt = isBankrupt;
        this.budget = budget;
    }

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final boolean isIsBankrupt() {
        return isBankrupt;
    }

    public final void setBankrupt(final boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public final int getBudget() {
        return budget;
    }

    public final void setBudget(final int budget) {
        this.budget = budget;
    }

    @Override
    public final String toString() {
        return "OutConsumer{"
                +
                "id="
                +
                id
                +
                ", isBankrupt="
                +
                isBankrupt
                +
                ", budget="
                +
                budget
                +
                '}';
    }
}
