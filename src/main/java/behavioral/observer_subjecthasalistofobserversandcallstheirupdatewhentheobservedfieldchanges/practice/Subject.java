package behavioral.observer.practice;

public interface Subject {

    void addObserver(Observer observer);
    void removeObserver(Observer observer);

}
