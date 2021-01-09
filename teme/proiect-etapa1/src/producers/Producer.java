package producers;

import entities.EnergyType;

public class Producer {
    private int id;
    private EnergyType energyType;
    private int maxDistributors;
    private float priceKW;
    private int energyPerDistributor;

    public Producer() { }

    public Producer(final int id, final EnergyType energyType,
                    final int maxDistributors, final float priceKW,
                    final int energyPerDistributor) {
        this.id = id;
        this.energyType = energyType;
        this.maxDistributors = maxDistributors;
        this.priceKW = priceKW;
        this.energyPerDistributor = energyPerDistributor;
    }

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final EnergyType getEnergyType() {
        return energyType;
    }

    public final void setEnergyType(final EnergyType energyType) {
        this.energyType = energyType;
    }

    public final int getMaxDistributors() {
        return maxDistributors;
    }

    public final void setMaxDistributors(final int maxDistributors) {
        this.maxDistributors = maxDistributors;
    }

    public final float getPriceKW() {
        return priceKW;
    }

    public final void setPriceKW(final float priceKW) {
        this.priceKW = priceKW;
    }

    public final int getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    public final void setEnergyPerDistributor(final int energyPerDistributor) {
        this.energyPerDistributor = energyPerDistributor;
    }

    @Override
    public final String toString() {
        return "Producer{"
                +
                "id="
                +
                id
                +
                ", energyType="
                +
                energyType
                +
                ", maxDistributors="
                +
                maxDistributors
                +
                ", priceKW="
                +
                priceKW
                +
                ", energyPerDistributor="
                +
                energyPerDistributor
                +
                '}';
    }
}
