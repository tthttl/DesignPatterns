package behavioral.observer;

public class StockPriceWatcher implements Observer {

    private double applePrice;
    private double googlePrice;
    private double ibmPrice;


    public StockPriceWatcher(){


    }

    public void update(double applePrice, double googlePrice, double ibmPrice) {
        this.applePrice = applePrice;
        this.googlePrice = googlePrice;
        this.ibmPrice = ibmPrice;
    }

    public void printPrices(){
        System.out.println("Apple: "+applePrice);
        System.out.println("Google: "+googlePrice);
        System.out.println("Ibm: "+ibmPrice);
    }

}
