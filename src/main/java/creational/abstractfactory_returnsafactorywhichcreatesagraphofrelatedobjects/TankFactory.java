package creational.abstractfactory_returnsafactorywhichcreatesagraphofrelatedobjects;

public class TankFactory extends AbstractFactory {

    @Override
    public WarMachine createWarMachine() {
        Tank tank = new Tank(addWeapon(),addShield());
        return tank;
    }

    @Override
    public Weapon addWeapon() {
        return new RailGun();
    }

    @Override
    public Shield addShield() {
        return new MetalPlate();
    }
}
