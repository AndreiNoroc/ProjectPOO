package change;

public class Change {
    private int id;
    private int infrastructureCost;

    public Change() { }

    public Change(final int id, final int infrastructureCost) {
        this.id = id;
        this.infrastructureCost = infrastructureCost;
    }

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final int getInfrastructureCost() {
        return infrastructureCost;
    }

    public final void setInfrastructureCost(final int infrastructureCost) {
        this.infrastructureCost = infrastructureCost;
    }

    @Override
    public final String toString() {
        return "costChange{"
                +
                "id="
                +
                id
                +
                ", infrastructureCost="
                +
                infrastructureCost
                +
                '}';
    }
}
