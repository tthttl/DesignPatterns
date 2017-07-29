package creational.abstractfactory;

public abstract class AbstractFactory {
    //creates factories
    //uses composition not inheritance
    //object families are created not only 1 object
    //concrete object is selected during runtime
    //client is not aware of the creation process, just sends the order for a warmachine
    protected abstract WarMachine createWarMachine();

    abstract Weapon addWeapon();

    abstract Shield addShield();

}
