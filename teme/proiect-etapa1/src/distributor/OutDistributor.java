package distributor;

import contract.Contract;
import entities.EnergyType;
import strategies.EnergyChoiceStrategyType;

import java.util.ArrayList;

public class OutDistributor {
    private int id;
    private int energyNeededKW;
    private int contractCost;
    private int budget;
    private EnergyChoiceStrategyType producerStrategy;
    private boolean isBankrupt;
    private ArrayList<Contract> contracts;

    public OutDistributor() { }

    public OutDistributor(final int id, final int energyNeededKW, final int contractCost,
                          final int budget, final EnergyChoiceStrategyType producerStrategy,
                          final boolean isBankrupt, final ArrayList<Contract> contracts) {
        this.id = id;
        this.energyNeededKW = energyNeededKW;
        this.contractCost = contractCost;
        this.budget = budget;
        this.producerStrategy = producerStrategy;
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

    public final int getEnergyNeededKW() {
        return energyNeededKW;
    }

    public final void setEnergyNeededKW(final int energyNeededKW) {
        this.energyNeededKW = energyNeededKW;
    }

    public final int getContractCost() {
        return contractCost;
    }

    public final void setContractCost(final int contractCost) {
        this.contractCost = contractCost;
    }

    public final EnergyChoiceStrategyType getProducerStrategy() {
        return producerStrategy;
    }

    public final void setProducerStrategy(final EnergyChoiceStrategyType producerStrategy) {
        this.producerStrategy = producerStrategy;
    }

    @Override
    public final String toString() {
        return "OutDistributor{"
                +
                "id="
                +
                id
                +
                ", energyNeededKW="
                +
                energyNeededKW
                +
                ", contractCost="
                +
                contractCost
                +
                ", budget="
                +
                budget
                +
                ", producerStrategy="
                +
                producerStrategy
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
