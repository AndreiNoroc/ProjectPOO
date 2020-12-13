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

    public CalcDistributor(int id, int contractLength, int initialBudget, int initialInfrastructureCost, int initialProductionCost) {
        this.id = id;
        this.contractLength = contractLength;
        this.initialBudget = initialBudget;
        this.initialInfrastructureCost = initialInfrastructureCost;
        this.initialProductionCost = initialProductionCost;
        this.finalPrice = 0;
        this.clients = new ArrayList<>();
        this.isBankrupt = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContractLength() {
        return contractLength;
    }

    public void setContractLength(int contractLength) {
        this.contractLength = contractLength;
    }

    public int getInitialBudget() {
        return initialBudget;
    }

    public void setInitialBudget(int initialBudget) {
        this.initialBudget = initialBudget;
    }

    public int getInitialInfrastructureCost() {
        return initialInfrastructureCost;
    }

    public void setInitialInfrastructureCost(int initialInfrastructureCost) {
        this.initialInfrastructureCost = initialInfrastructureCost;
    }

    public int getInitialProductionCost() {
        return initialProductionCost;
    }

    public void setInitialProductionCost(int initialProductionCost) {
        this.initialProductionCost = initialProductionCost;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public ArrayList<CalcConsumer> getClients() {
        return clients;
    }

    public void setClients(ArrayList<CalcConsumer> clients) {
        this.clients = clients;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        this.isBankrupt = bankrupt;
    }

    public void setContractPrice() {
        this.finalPrice = (int) Math.round(Math.floor(initialInfrastructureCost / clients.size()) + initialProductionCost + (int) Math.round(Math.floor(0.2 * initialProductionCost)));
    }

    public void setActualBudget() {
        this.initialBudget += this.clients.size() * this.finalPrice -(this.initialInfrastructureCost + this.initialProductionCost * this.clients.size());
    }

    @Override
    public String toString() {
        return "CalcDistributor{" +
                "id=" + id +
                ", contractLength=" + contractLength +
                ", initialBudget=" + initialBudget +
                ", initialInfrastructureCost=" + initialInfrastructureCost +
                ", initialProductionCost=" + initialProductionCost +
                ", finalPrice=" + finalPrice +
                '}';
    }
}
