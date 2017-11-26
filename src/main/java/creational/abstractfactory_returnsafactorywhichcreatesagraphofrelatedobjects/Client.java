package creational.abstractfactory_returnsafactorywhichcreatesagraphofrelatedobjects;

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
