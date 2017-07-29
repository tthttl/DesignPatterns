package creational.abstractfactory;

public class RailGun implements Weapon {
    @Override
    public void shoot() {
        System.out.println("Bullet explodes on impact");
    }
}
