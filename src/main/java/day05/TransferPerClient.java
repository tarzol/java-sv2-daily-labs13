package day05;

public class TransferPerClient {
    private String ID;
    private int sum;
    private int numberOfTransactions;

    public TransferPerClient(String ID) {
        this.ID = ID;
    }

    public void increase(int changingSum) {
        sum +=changingSum;
        numberOfTransactions++;
    }

    public void decrease(int changingSum) {
        sum -=changingSum;
        numberOfTransactions++;
    }

    @Override
    public String toString() {
        return "TransferPerClient{" +
                "ID='" + ID + '\'' +
                ", sum=" + sum +
                ", numberOfTransactions=" + numberOfTransactions +
                '}'+"\n";
    }

    public String getID() {
        return ID;
    }

    public int getSum() {
        return sum;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }
}
