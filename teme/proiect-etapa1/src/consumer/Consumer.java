package consumer;

public class Consumer {
    private int id;
    private int initialBudget;
    private int monthlyIncome;

    public Consumer() {}

    public Consumer(int id, int initialBudget, int monthlyIncome) {
        this.id = id;
        this.initialBudget = initialBudget;
        this.monthlyIncome = monthlyIncome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInitialBudget() {
        return initialBudget;
    }

    public void setInitialBudget(int initialBudget) {
        this.initialBudget = initialBudget;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", initialBudget=" + initialBudget +
                ", monthlyIncome=" + monthlyIncome +
                '}';
    }
}
