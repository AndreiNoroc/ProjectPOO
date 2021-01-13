package transformdata;

import entities.EnergyType;
import monthlyStats.MonthlyStat;

import java.util.ArrayList;
import java.util.Collections;

public class CalcProducer {
    private int id;
    private EnergyType energyType;
    private int maxDistributors;
    private float priceKW;
    private int energyPerDistributor;
    private ArrayList<CalcDistributor> clients;
    private ArrayList<Integer> clientsId;
    private ArrayList<MonthlyStat> ms;

    public CalcProducer(final int id, final EnergyType energyType,
                        final int maxDistributors, final float priceKW,
                        final int energyPerDistributor) {
        this.id = id;
        this.energyType = energyType;
        this.maxDistributors = maxDistributors;
        this.priceKW = priceKW;
        this.energyPerDistributor = energyPerDistributor;
        this.clients = new ArrayList<>();
        this.clientsId = new ArrayList<>();
        this.ms = new ArrayList<>();
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

    public final ArrayList<CalcDistributor> getClients() {
        return clients;
    }

    public final void setClients(final ArrayList<CalcDistributor> clients) {
        this.clients = clients;
    }

    public final ArrayList<Integer> getClientsId() {
        return clientsId;
    }

    public final void setClientsId(final ArrayList<Integer> clientsId) {
        this.clientsId = clientsId;
    }

    public final ArrayList<MonthlyStat> getMs() {
        return ms;
    }

    public final void setMs(final ArrayList<MonthlyStat> ms) {
        this.ms = ms;
    }

    /**
     * Metoda retine situatia lunara a
     * clientilor unui producator
     * @param month - luna actuala
     */
    public final void makeMonthStat(int month) {
        Collections.sort(this.clientsId);
        MonthlyStat mStat = new MonthlyStat(month, new ArrayList(this.clientsId));
        this.ms.add(mStat);
    }

    @Override
    public final String toString() {
        return "CalcProducer{"
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
                ", clients="
                +
                clients
                +
                ", clientsId="
                +
                clientsId
                +
                ", ms="
                +
                ms
                +
                '}';
    }
}
