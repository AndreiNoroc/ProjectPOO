package change;

public class ProducerChange {
    private int id;
    private int energyPerDistributor;

    public ProducerChange() { }

    public ProducerChange(final int id, final int energyPerDistributor) {
        this.id = id;
        this.energyPerDistributor = energyPerDistributor;
    }

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final int getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    public final void setEnergyPerDistributor(final int energyPerDistributor) {
        this.energyPerDistributor = energyPerDistributor;
    }

    @Override
    public final String toString() {
        return "ProducerChange{" +
                "id=" + id +
                ", energyPerDistributor=" + energyPerDistributor +
                '}';
    }
}
