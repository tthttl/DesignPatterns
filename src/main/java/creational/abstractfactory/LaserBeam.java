package creational.abstractfactory;

public class LaserBeam implements Weapon {
    @Override
    public void shoot() {
        System.out.println("Cuts through hull!");
    }
}
