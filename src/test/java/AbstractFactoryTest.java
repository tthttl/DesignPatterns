import creational.abstractfactory_returnsafactorywhichcreatesagraphofrelatedobjects.Client;
import creational.abstractfactory_returnsafactorywhichcreatesagraphofrelatedobjects.WarMachine;
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
