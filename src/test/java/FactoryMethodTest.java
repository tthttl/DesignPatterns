import creational.factorymethod.FactoryImpl;
import org.junit.Test;

public class FactoryMethodTest {

    @Test
    public void testFactoryMethod() throws Exception {
        FactoryImpl factoryImpl = new FactoryImpl();
        factoryImpl.anOperationWhichNeedsAProduct();
    }




}
