package creational.abstractfactory_returnsafactorywhichcreatesagraphofrelatedobjects;

public class RailGun implements Weapon {
    @Override
    public void shoot() {
        System.out.println("Bullet explodes on impact");
    }
}
