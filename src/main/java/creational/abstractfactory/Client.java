package creational.abstractfactory;

public class Client {
    private AbstractFactory factory;

    public WarMachine createWarMachine() {
        if (System.getProperty("os.name").startsWith("Windows")) {
            factory = new UFOFactory();
        } else {
            factory = new TankFactory();
        }
        return factory.createWarMachine();
    }

}
