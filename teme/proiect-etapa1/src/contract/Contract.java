package contract;

public class Contract {
    private int consumerID;
    private int price;
    private int remainedContractMonths;

    public Contract() { }

    public Contract(int consumerID, int price, int remainedContractMonths) {
        this.consumerID = consumerID;
        this.price = price;
        this.remainedContractMonths = remainedContractMonths;
    }

    public int getConsumerID() {
        return consumerID;
    }

    public void setConsumerID(int consumerID) {
        this.consumerID = consumerID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRemainedContractMonths() {
        return remainedContractMonths;
    }

    public void setRemainedContractMonths(int remainedContractMonths) {
        this.remainedContractMonths = remainedContractMonths;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "consumerID=" + consumerID +
                ", price=" + price +
                ", remainedContractMonths=" + remainedContractMonths +
                '}';
    }
}
