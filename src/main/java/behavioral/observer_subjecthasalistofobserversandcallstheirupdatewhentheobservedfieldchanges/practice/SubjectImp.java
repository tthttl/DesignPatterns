package behavioral.observer.practice;

import java.util.ArrayList;
import java.util.List;

public class SubjectImp implements Subject {

    List<Observer> observers;
    private int apple;
    private int google;


    public SubjectImp() {
        this.observers = new ArrayList<>();
    }

    public void setApple(int apple) {
        this.apple = apple;
        update();
    }

    public void setGoogle(int google) {
        this.google = google;
        update();
    }

    private void update() {
        observers.forEach(observer -> observer.update(apple, google));
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
