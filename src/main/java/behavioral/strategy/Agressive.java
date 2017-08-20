package behavioral.strategy;

public class Agressive implements Behaviour {
    @Override
    public void move() {
        System.out.println("Attack");
    }
}
