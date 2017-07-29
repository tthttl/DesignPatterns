import homework.immutable.ImmutableCounter;
import org.junit.Test;

public class ImmutableCounterTest {

    @Test
    public void counterTest() throws Exception {
        ImmutableCounter counter = ImmutableCounter.getCounter();
        counter = counter.add(2);
        System.out.println(counter.getResult());
        counter = counter.deduct(10);
        System.out.println(counter.getResult());
        counter = counter.multiply(10);
        System.out.println(counter.getResult());
        counter = counter.divide(10);
        System.out.println(counter.getResult());
    }




}
