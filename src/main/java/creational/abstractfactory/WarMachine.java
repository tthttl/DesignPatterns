package creational.abstractfactory;

public abstract class WarMachine {

    private Weapon weapon;
    private Shield shield;


    protected WarMachine(Weapon weapon, Shield shield) {
        this.weapon = weapon;
        this.shield = shield;
    }

    public WarMachine() {
    }

    public void getType() {
        System.out.println(this.getClass().getName());
    }

    public void fireWeapon() {
        weapon.shoot();
    }

    public void raiseShield() {
        shield.shieldsUp();
    }

}
