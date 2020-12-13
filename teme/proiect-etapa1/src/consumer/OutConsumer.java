package consumer;

public class OutConsumer {
    private int id;
    private boolean isBankrupt;
    private int budget;

    public OutConsumer() { }

    public OutConsumer(int id, boolean isBankrupt, int budget) {
        this.id = id;
        this.isBankrupt = isBankrupt;
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "OutConsumer{" +
                "id=" + id +
                ", isBankrupt=" + isBankrupt +
                ", budget=" + budget +
                '}';
    }
}
