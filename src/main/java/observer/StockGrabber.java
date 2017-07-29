package observer;

import java.util.ArrayList;
import java.util.List;

public class StockGrabber implements Subject {

    double applePrice;
    double googlePrice;
    double ibmPrice;

    List<Observer> observers;

    public StockGrabber (){
        this.observers = new ArrayList<>();
    }


    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void update() {
        for(Observer observer:observers){
            observer.update(applePrice, googlePrice, ibmPrice);
        }
    }

    public void setApplePrice(double applePrice) {
        this.applePrice = applePrice;
        update();
    }

    public void setGooglePrice(double googlePrice) {
        this.googlePrice = googlePrice;
        update();
    }

    public void setIbmPrice(double ibmPrice) {
        this.ibmPrice = ibmPrice;
        update();
    }
}
