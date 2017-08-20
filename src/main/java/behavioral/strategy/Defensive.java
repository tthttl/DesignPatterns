package behavioral.strategy;

public class Defensive implements Behaviour {
    @Override
    public void move() {
        System.out.println("Defend!");
    }
}
