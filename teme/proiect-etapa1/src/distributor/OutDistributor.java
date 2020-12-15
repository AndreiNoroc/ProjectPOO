package distributor;

import contract.Contract;

import java.util.ArrayList;

public class OutDistributor {
    private int id;
    private int budget;
    private boolean isBankrupt;
    private ArrayList<Contract> contracts;

    public OutDistributor() { }

    public OutDistributor(final int id, final int budget,
                          final boolean isBankrupt, final ArrayList<Contract> contracts) {
        this.id = id;
        this.budget = budget;
        this.isBankrupt = isBankrupt;
        this.contracts = contracts;
    }

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final int getBudget() {
        return budget;
    }

    public final void setBudget(final int budget) {
        this.budget = budget;
    }

    public final boolean isIsBankrupt() {
        return isBankrupt;
    }

    public final void setBankrupt(final boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public final ArrayList<Contract> getContracts() {
        return contracts;
    }

    public final void setContracts(final ArrayList<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public final String toString() {
        return "OutDistributor{"
                +
                "id="
                +
                id
                +
                ", budget="
                +
                budget
                +
                ", isBankrupt="
                +
                isBankrupt
                +
                ", contracts="
                +
                contracts
                +
                '}';
    }
}
