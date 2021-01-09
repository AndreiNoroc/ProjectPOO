package producers;

import entities.EnergyType;
import monthlyStats.MonthlyStat;

import java.util.ArrayList;

public class OutProducer {
    private int id;
    private int maxDistributors;
    private float priceKW;
    private EnergyType energyType;
    private int energyPerDistributor;
    private ArrayList<MonthlyStat> monthlyStats;

    public OutProducer() { }

    public OutProducer(final int id, final int maxDistributors,
                       final float priceKW, final EnergyType energyType,
                       final int energyPerDistributor,
                       final ArrayList<MonthlyStat> monthlyStats) {
        this.id = id;
        this.maxDistributors = maxDistributors;
        this.priceKW = priceKW;
        this.energyType = energyType;
        this.energyPerDistributor = energyPerDistributor;
        this.monthlyStats = monthlyStats;
    }

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
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

    public final EnergyType getEnergyType() {
        return energyType;
    }

    public final void setEnergyType(final EnergyType energyType) {
        this.energyType = energyType;
    }

    public final int getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    public final void setEnergyPerDistributor(final int energyPerDistributor) {
        this.energyPerDistributor = energyPerDistributor;
    }

    public final ArrayList<MonthlyStat> getMonthlyStats() {
        return monthlyStats;
    }

    public final void setMonthlyStats(final ArrayList<MonthlyStat> monthlyStats) {
        this.monthlyStats = monthlyStats;
    }

    @Override
    public String toString() {
        return "OutProducer{"
                +
                "id="
                +
                id
                +
                ", maxDistributors="
                +
                maxDistributors
                +
                ", priceKW="
                +
                priceKW
                +
                ", energyType="
                +
                energyType
                +
                ", energyPerDistributor="
                +
                energyPerDistributor
                +
                ", monthlyStats="
                +
                monthlyStats
                +
                '}';
    }
}
