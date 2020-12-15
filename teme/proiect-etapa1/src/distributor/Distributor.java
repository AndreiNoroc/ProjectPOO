package distributor;

public class Distributor {
    private int id;
    private int contractLength;
    private int initialBudget;
    private int initialInfrastructureCost;
    private int initialProductionCost;

    public Distributor() { }

    public Distributor(final int id, final int contractLength,
                       final int initialBudget, final int initialInfrastructureCost,
                       final int initialProductionCost) {
        this.id = id;
        this.contractLength = contractLength;
        this.initialBudget = initialBudget;
        this.initialInfrastructureCost = initialInfrastructureCost;
        this.initialProductionCost = initialProductionCost;
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

    public final int getInitialProductionCost() {
        return initialProductionCost;
    }

    public final void setInitialProductionCost(final int initialProductionCost) {
        this.initialProductionCost = initialProductionCost;
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
                ", initialProductionCost="
                +
                initialProductionCost
                +
                '}';
    }
}
