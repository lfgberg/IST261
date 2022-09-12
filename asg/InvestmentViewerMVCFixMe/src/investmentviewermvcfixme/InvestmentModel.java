package investmentviewermvcfixme;

/**
 * Based on program in Big Java: Late Objects by Cay Horstmann
 */
public class InvestmentModel {

    private double rate;
    private double balance;

    public InvestmentModel() {
        this.balance = 1000.0;
        this.rate = 5.0;
    }

    public double updateBalance() {
        this.balance = this.balance + (this.balance * this.rate / 100);
        return this.balance;
    }
    
    public void setRate(double newRate){
        this.rate = newRate;
    }

    public double getRate() {
        return rate;
    }

    public double getBal() {
        return balance;
    }

}
