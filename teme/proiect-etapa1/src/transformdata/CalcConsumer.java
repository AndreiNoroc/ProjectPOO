package transformdata;

public class CalcConsumer {
    private int id;
    private int initialBudget;
    private int monthlyIncome;
    private CalcDistributor actualDistr;
    private CalcDistributor oldDistr;
    private int priceDistr;
    private int priceOldDistr;
    private int contractLen;
    private boolean isBankrupt;
    private boolean preBankrupt;
    private static double value = 1.2;

    public CalcConsumer(final int id, final int initialBudget, final int monthlyIncome) {
        this.id = id;
        this.initialBudget = initialBudget;
        this.monthlyIncome = monthlyIncome;
        this.actualDistr = null;
        this.oldDistr = null;
        this.contractLen = 0;
        this.priceDistr = 0;
        this.priceOldDistr = 0;
        this.isBankrupt = false;
        this.preBankrupt = false;
    }

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final int getInitialBudget() {
        return initialBudget;
    }

    public final void setInitialBudget(final int initialBudget) {
        this.initialBudget = initialBudget;
    }

    public final int getMonthlyIncome() {
        return monthlyIncome;
    }

    public final void setMonthlyIncome(final int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public final int getContractLen() {
        return contractLen;
    }

    public final void setContractLen(final int contractLen) {
        this.contractLen = contractLen;
    }

    public final boolean isBankrupt() {
        return isBankrupt;
    }

    public final void setBankrupt(final boolean bankrupt) {
        this.isBankrupt = bankrupt;
    }

    public final boolean isPreBankrupt() {
        return preBankrupt;
    }

    public final void setPreBankrupt(final boolean preBankrupt) {
        this.preBankrupt = preBankrupt;
    }

    public final CalcDistributor getActualDistr() {
        return actualDistr;
    }

    public final void setActualDistr(final CalcDistributor actualDistr) {
        this.actualDistr = actualDistr;
    }

    public final CalcDistributor getOldDistr() {
        return oldDistr;
    }

    public final void setOldDistr(final CalcDistributor oldDistr) {
        this.oldDistr = oldDistr;
    }

    public final int getPriceDistr() {
        return priceDistr;
    }

    public final void setPriceDistr(final int priceDistr) {
        this.priceDistr = priceDistr;
    }

    public final int getPriceOldDistr() {
        return priceOldDistr;
    }

    public final void setPriceOldDistr(final int priceOldDistr) {
        this.priceOldDistr = priceOldDistr;
    }

    public static double getValue() {
        return value;
    }

    public static void setValue(final double value) {
        CalcConsumer.value = value;
    }

    /**
     * Metoda alege un distributor pentru consumatorii noi
     * @param newDistr - noul distribuitor
     */
    public final void chooseDistributor(final CalcDistributor newDistr) {
        this.actualDistr = newDistr;
        this.oldDistr = newDistr;
        this.contractLen = newDistr.getContractLength();
        this.priceDistr = newDistr.getFinalPrice();
        this.priceOldDistr = newDistr.getFinalPrice();
    }

    /**
     * Metoda actualizeaea informatiile consumatorului
     */
    public final void setActual() {
        this.contractLen -= 1;
        this.initialBudget += this.monthlyIncome;

        if (!this.preBankrupt) {
            if (this.initialBudget - this.priceDistr >= 0) {
                this.initialBudget -= this.priceDistr;
                actualDistr.addPayConsumer(this.priceDistr);
            } else {
                this.preBankrupt = true;
            }
        } else {
            int var1 = (int) Math.round(Math.floor(value * this.priceOldDistr));

            if (this.initialBudget - (var1 + this.priceDistr) < 0) {
                this.isBankrupt = true;
            } else {
                int var = (int) Math.round(Math.floor(value * this.priceOldDistr));
                this.initialBudget -= var + this.priceDistr;

                actualDistr.addPayConsumer(this.priceDistr);
                oldDistr.addPayConsumer((int) Math.round(Math.floor(value * this.priceOldDistr)));

                this.preBankrupt = false;
            }
        }
    }

    @Override
    public final String toString() {
        return "CalcConsumer{"
                +
                "id="
                +
                id
                +
                ", initialBudget="
                +
                initialBudget
                +
                ", monthlyIncome="
                +
                monthlyIncome
                +
                ", idDistributor="
                +
                priceDistr
                +
                '}';
    }
}
