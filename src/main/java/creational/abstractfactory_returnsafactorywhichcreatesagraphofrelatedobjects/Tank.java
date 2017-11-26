package creational.abstractfactory_returnsafactorywhichcreatesagraphofrelatedobjects;

public class Tank extends WarMachine {

    protected Tank(Weapon weapon, Shield shield) {
        super(weapon, shield);
    }

}
