package distributor;

import strategies.EnergyChoiceStrategyType;

public class Distributor {
    private int id;
    private int contractLength;
    private int initialBudget;
    private int initialInfrastructureCost;
    private int energyNeededKW;
    private EnergyChoiceStrategyType producerStrategy;

    public Distributor() { }

    public Distributor(final int id, final int contractLength,
                       final int initialBudget, final int initialInfrastructureCost,
                       final int energyNeededKW, final EnergyChoiceStrategyType producerStrategy) {
        this.id = id;
        this.contractLength = contractLength;
        this.initialBudget = initialBudget;
        this.initialInfrastructureCost = initialInfrastructureCost;
        this.energyNeededKW = energyNeededKW;
        this.producerStrategy = producerStrategy;
    }

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final int getContractLength() {
        return contractLength;
    }

    public final void setContractLength(final int contractLength) {
        this.contractLength = contractLength;
    }

    public final int getInitialBudget() {
        return initialBudget;
    }

    public final void setInitialBudget(final int initialBudget) {
        this.initialBudget = initialBudget;
    }

    public final int getInitialInfrastructureCost() {
        return initialInfrastructureCost;
    }

    public final void setInitialInfrastructureCost(final int initialInfrastructureCost) {
        this.initialInfrastructureCost = initialInfrastructureCost;
    }

    public final int getEnergyNeededKW() {
        return energyNeededKW;
    }

    public final void setEnergyNeededKW(final int energyNeededKW) {
        this.energyNeededKW = energyNeededKW;
    }

    public final EnergyChoiceStrategyType getProducerStrategy() {
        return producerStrategy;
    }

    public final void setProducerStrategy(final EnergyChoiceStrategyType producerStrategy) {
        this.producerStrategy = producerStrategy;
    }

    @Override
    public final String toString() {
        return "Distributor{"
                +
                "id="
                +
                id
                +
                ", contractLength="
                +
                contractLength
                +
                ", initialBudget="
                +
                initialBudget
                +
                ", initialInfrastructureCost="
                +
                initialInfrastructureCost
                +
                ", energyNeededKW="
                +
                energyNeededKW
                +
                ", producerStrategy="
                +
                producerStrategy
                +
                '}';
    }
}
