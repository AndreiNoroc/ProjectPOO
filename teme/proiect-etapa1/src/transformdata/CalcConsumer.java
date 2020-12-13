package transformdata;

public class CalcConsumer {
    private int id;
    private int initialBudget;
    private int monthlyIncome;
    private int priceDistr;
    private int contractLen;
    private boolean isBankrupt;

    public CalcConsumer(int id, int initialBudget, int monthlyIncome, int priceDistr, int contractLen) {
        this.id = id;
        this.initialBudget = initialBudget;
        this.monthlyIncome = monthlyIncome;
        this.priceDistr = priceDistr;
        this.contractLen = contractLen;
        this.isBankrupt = false;
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

    public int getPriceDistr() {
        return priceDistr;
    }

    public void setPriceDistr(int priceDistr) {
        this.priceDistr = priceDistr;
    }

    public int getContractLen() {
        return contractLen;
    }

    public void setContractLen(int contractLen) {
        this.contractLen = contractLen;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        this.isBankrupt = bankrupt;
    }

    public void setActual() {
        this.contractLen--;
        this.initialBudget += (this.monthlyIncome - this.priceDistr);
    }

    @Override
    public String toString() {
        return "CalcConsumer{" +
                "id=" + id +
                ", initialBudget=" + initialBudget +
                ", monthlyIncome=" + monthlyIncome +
                ", idDistributor=" + priceDistr +
                '}';
    }
}
