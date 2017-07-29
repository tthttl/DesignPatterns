package creational.abstractfactory;

public class UFOFactory extends AbstractFactory{

    @Override
    public WarMachine createWarMachine() {
        UFO ufo = new UFO(addWeapon(),addShield());
        return ufo;
    }

    @Override
    public Weapon addWeapon() {
        // ez is lehetne t�bb f�le
        return new LaserBeam();
    }

    @Override
    public Shield addShield() {
        // ez is lehetne t�bb f�le
        return new EnergyShield();
    }
}
