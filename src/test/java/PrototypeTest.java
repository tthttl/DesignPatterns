import org.junit.Test;
import creational.prototype_deepcopywithclone.Sheep;

public class PrototypeTest {

    @Test
    public void testCloning() throws Exception {
        Sheep dolly = new Sheep();
        Sheep clone = (Sheep) dolly.clone();
        clone.sayBee();

    }
}
