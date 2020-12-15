package consumer;

public class Consumer {
    private int id;
    private int initialBudget;
    private int monthlyIncome;

    public Consumer() { }

    public Consumer(final int id, final int initialBudget, final int monthlyIncome) {
        this.id = id;
        this.initialBudget = initialBudget;
        this.monthlyIncome = monthlyIncome;
    }

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final int getInitialBudget() {
        return initialBudget;
    }

    public final void setInitialBudget(final int initialBudget) {
        this.initialBudget = initialBudget;
    }

    public final int getMonthlyIncome() {
        return monthlyIncome;
    }

    public final void setMonthlyIncome(final int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    @Override
    public final String toString() {
        return "Consumer{"
                +
                "id="
                +
                id
                +
                ", initialBudget="
                +
                initialBudget
                +
                ", monthlyIncome="
                +
                monthlyIncome
                +
                '}';
    }
}
