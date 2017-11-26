package creational.abstractfactory_returnsafactorywhichcreatesagraphofrelatedobjects;

public class EnergyShield implements Shield {
    @Override
    public void shieldsUp() {
        System.out.println("All energy to the shields!");
    }
}
