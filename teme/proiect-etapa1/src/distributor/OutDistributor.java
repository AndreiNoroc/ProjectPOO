package distributor;

import contract.Contract;

import java.util.ArrayList;

public class OutDistributor {
    private int id;
    private int budget;
    private boolean isBankrupt;
    private ArrayList<Contract> contracts;

    public OutDistributor() { }

    public OutDistributor(int id, int budget, boolean isBankrupt, ArrayList<Contract> contracts) {
        this.id = id;
        this.budget = budget;
        this.isBankrupt = isBankrupt;
        this.contracts = contracts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public ArrayList<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(ArrayList<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public String toString() {
        return "OutDistributor{" +
                "id=" + id +
                ", budget=" + budget +
                ", isBankrupt=" + isBankrupt +
                ", contracts=" + contracts +
                '}';
    }
}
