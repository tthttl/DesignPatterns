package behavioral.strategy;

public class Cool implements Behaviour {
    @Override
    public void move() {
        System.out.println("Keeps it cool!");
    }
}
