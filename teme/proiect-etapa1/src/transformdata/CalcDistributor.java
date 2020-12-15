package transformdata;

import java.util.ArrayList;

public class CalcDistributor {
    private int id;
    private int contractLength;
    private int initialBudget;
    private int initialInfrastructureCost;
    private int initialProductionCost;
    private int finalPrice;
    private ArrayList<CalcConsumer> clients;
    private boolean isBankrupt;
    private static double value = 0.2;

    public CalcDistributor(final int id, final int contractLength,
                           final int initialBudget,
                           final int initialInfrastructureCost,
                           final int initialProductionCost) {
        this.id = id;
        this.contractLength = contractLength;
        this.initialBudget = initialBudget;
        this.initialInfrastructureCost = initialInfrastructureCost;
        this.initialProductionCost = initialProductionCost;
        this.finalPrice = 0;
        this.clients = new ArrayList<>();
        this.isBankrupt = false;
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

    public final int getFinalPrice() {
        return finalPrice;
    }

    public final void setFinalPrice(final int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public final ArrayList<CalcConsumer> getClients() {
        return clients;
    }

    public final void setClients(final ArrayList<CalcConsumer> clients) {
        this.clients = clients;
    }

    public final boolean isBankrupt() {
        return isBankrupt;
    }

    public final void setBankrupt(final boolean bankrupt) {
        this.isBankrupt = bankrupt;
    }

    public static double getValue() {
        return value;
    }

    public static void setValue(final double value) {
        CalcDistributor.value = value;
    }

    /**
     * Metoda calculeaza pretul contractului
     */
    public final void setContractPrice() {
        if (this.clients.size() != 0) {
            int var = (int) Math.round(Math.floor(initialInfrastructureCost / clients.size()));
            this.finalPrice = var
                    + initialProductionCost
                    + (int) Math.round(Math.floor(value * initialProductionCost));
        } else {
            this.finalPrice = this.initialInfrastructureCost
                    + this.initialProductionCost
                    + (int) Math.round(Math.floor(value * this.initialProductionCost));
        }
    }

    /**
     * Metoda face plata consumaturului la distributor
     * @param sum - suma platita
     */
    public final void addPayConsumer(final int sum) {
        this.initialBudget += sum;
    }

    /**
     * Updateaza nugetul distributorului
     */
    public final void setActualBudget() {
        this.initialBudget -= (this.initialInfrastructureCost
                + this.initialProductionCost * this.clients.size());

        if (this.initialBudget < 0) {
            this.isBankrupt = true;
        }
    }

    @Override
    public final String toString() {
        return "CalcDistributor{"
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
                ", finalPrice="
                +
                finalPrice
                +
                '}';
    }
}
