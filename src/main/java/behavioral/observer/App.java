package behavioral.observer;

public class App {


    public static void main (String[] args){
        StockGrabber subject = new StockGrabber();
        StockPriceWatcher observer = new StockPriceWatcher();

        subject.register(observer);
        subject.setApplePrice(57.12);

        observer.printPrices();
    }

}
