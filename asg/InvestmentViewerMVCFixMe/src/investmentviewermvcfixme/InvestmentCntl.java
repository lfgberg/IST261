package investmentviewermvcfixme;

/**
 * Based on program in Big Java: Late Objects by Cay Horstmann
 */
public class InvestmentCntl {

    private final InvestmentModel model;
    private final InvestmentView view;

    public InvestmentCntl() {
        model = new InvestmentModel();
        view = new InvestmentView(this);
    }
    
    public double fetchBalance() {
        return model.getBal();
    }

    public double fetchRate() {
        return model.getRate();
    }
    
    public double calcNewBalance() {
        return model.updateBalance();
    }
    
    public void updateInterestRate(double newRate){
        model.setRate(newRate);
    }
    
    public void showView() {
        view.displaySelf();
    }

}
