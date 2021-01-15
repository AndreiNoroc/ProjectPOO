package transformdata;

import strategies.EnergyChoiceStrategyType;

import java.util.ArrayList;

public class CalcDistributor {
    private int id;
    private int contractLength;
    private int initialBudget;
    private int initialInfrastructureCost;
    private int initialProductionCost;
    private int energyNeededKW;
    private EnergyChoiceStrategyType producerStrategy;
    private int finalPrice;
    private ArrayList<CalcConsumer> clients;
    private boolean isBankrupt;
    private ArrayList<CalcProducer> actualProd;
    private static double value = 0.2;
    private static int val1 = 10;

    public CalcDistributor(final int id, final int contractLength,
                           final int initialBudget,
                           final int initialInfrastructureCost,
                           final int energyNeededKW,
                           final EnergyChoiceStrategyType producerStrategy) {
        this.id = id;
        this.contractLength = contractLength;
        this.initialBudget = initialBudget;
        this.initialInfrastructureCost = initialInfrastructureCost;
        this.energyNeededKW = energyNeededKW;
        this.producerStrategy = producerStrategy;
        this.finalPrice = 0;
        this.clients = new ArrayList<>();
        this.isBankrupt = false;
        this.actualProd = new ArrayList<>();
        this.initialProductionCost = 0;
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

    public final int getInitialProductionCost() {
        return initialProductionCost;
    }

    public final void setInitialProductionCost(final int initialProductionCost) {
        this.initialProductionCost = initialProductionCost;
    }

    public final ArrayList<CalcProducer> getActualProd() {
        return actualProd;
    }

    public final void setActualProd(final ArrayList<CalcProducer> actualProd) {
        this.actualProd = actualProd;
    }

    public static double getValue() {
        return value;
    }

    public static void setValue(final double value) {
        CalcDistributor.value = value;
    }

    /**
     * Functia alege producatorii unui distribuitor
     * @param sortGreenProd - producatorii sortati dupa criteriul green
     * @param sortPriceProd - producatorii sortati dupa criteriul price
     * @param sortQuantityProd - producatorii sortati dupa criteriul quantity
     */
    public final void chooseProducer(final ArrayList<CalcProducer> sortGreenProd,
                                     final ArrayList<CalcProducer> sortPriceProd,
                                     final ArrayList<CalcProducer> sortQuantityProd) {
        int neededEnergy = this.energyNeededKW;
        double sum = 0;

        if (this.getProducerStrategy().toString().equals("GREEN")) {
            for (CalcProducer cp : sortGreenProd) {
                if (neededEnergy > 0) {
                    if (cp.getClients().size() < cp.getMaxDistributors()) {
                        this.actualProd.add(cp);
                        cp.getClients().add(this);
                        cp.getClientsId().add(this.id);
                        neededEnergy -= cp.getEnergyPerDistributor();
                        sum += cp.getEnergyPerDistributor() * cp.getPriceKW();
                    }
                } else {
                    break;
                }
            }

            this.initialProductionCost = (int) Math.round(Math.floor(sum / val1));
        } else if (this.getProducerStrategy().toString().equals("PRICE")) {
            for (CalcProducer cp : sortPriceProd) {
                if (neededEnergy > 0) {
                    if (cp.getClients().size() < cp.getMaxDistributors()) {
                        this.actualProd.add(cp);
                        cp.getClients().add(this);
                        cp.getClientsId().add(this.id);
                        neededEnergy -= cp.getEnergyPerDistributor();
                        sum += cp.getEnergyPerDistributor() * cp.getPriceKW();
                    }
                } else {
                    break;
                }
            }

            this.initialProductionCost = (int) Math.round(Math.floor(sum / val1));
        } else if (this.getProducerStrategy().toString().equals("QUANTITY")) {

            for (CalcProducer cp : sortQuantityProd) {
                if (neededEnergy > 0) {
                    if (cp.getClients().size() < cp.getMaxDistributors()) {
                        this.actualProd.add(cp);
                        cp.getClients().add(this);
                        cp.getClientsId().add(this.id);
                        neededEnergy -= cp.getEnergyPerDistributor();
                        sum += cp.getEnergyPerDistributor() * cp.getPriceKW();
                    }
                } else {
                    break;
                }
            }

            this.initialProductionCost = (int) Math.round(Math.floor(sum / val1));
        }
    }

    /**
     * Metoda calculeaza pretul contractului
     */
    public final void setContractPrice() {

        if (this.clients.size() != 0) {
            int var = (int) Math.round(Math.floor(initialInfrastructureCost / clients.size()));
            this.finalPrice = var
                    + this.initialProductionCost
                    + (int) Math.round(Math.floor(value * this.initialProductionCost));
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
                ", energyNeededKW="
                +
                energyNeededKW
                +
                ", producerStrategy="
                +
                producerStrategy
                +
                ", finalPrice="
                +
                finalPrice
                +
                ", clients="
                +
                clients
                +
                ", isBankrupt="
                +
                isBankrupt
                +
                '}';
    }
}
