import creational.factory_interfaceasreturntypeplusswitch.Shipyard;
import org.junit.Test;

public class Factory {

    Shipyard factory;

    @Test
    public void testName() throws Exception {
        factory = new Shipyard();
        factory.buildShip(1).displayShip();
        factory.buildShip(2).displayShip();
        factory.buildShip(3).displayShip();

    }
}
