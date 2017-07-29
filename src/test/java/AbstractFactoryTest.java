import creational.abstractfactory.Client;
import creational.abstractfactory.WarMachine;
import org.junit.Test;

public class AbstractFactoryTest {

    @Test
    public void testFactories() throws Exception {
        Client client = new Client();
        WarMachine warMachine = client.createWarMachine();
        warMachine.getType();
        warMachine.raiseShield();
        warMachine.fireWeapon();
    }
}
