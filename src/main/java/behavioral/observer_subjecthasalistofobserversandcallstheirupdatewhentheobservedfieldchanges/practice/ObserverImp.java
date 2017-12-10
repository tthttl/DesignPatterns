package behavioral.observer.practice;

public class ObserverImp implements Observer {

    private int apple;
    private int google;

    @Override
    public void update(int apple, int google) {
        this.apple = apple;
        this.google = google;
        System.out.printf("Apple is %s, google is %s. ", apple, google);
    }
}
