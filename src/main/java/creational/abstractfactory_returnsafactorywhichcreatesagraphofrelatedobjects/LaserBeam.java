package creational.abstractfactory_returnsafactorywhichcreatesagraphofrelatedobjects;

public class LaserBeam implements Weapon {
    @Override
    public void shoot() {
        System.out.println("Cuts through hull!");
    }
}
