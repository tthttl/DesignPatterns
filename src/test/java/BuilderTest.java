import creational.builder.Director;
import creational.builder.Robot;
import creational.builder.RobotBuilder;
import org.junit.Test;

public class BuilderTest {

    @Test
    public void testRobot() throws Exception {
        RobotBuilder robotBuilder = new RobotBuilder();
        Director director = new Director(robotBuilder);
        director.buildRobot();
        Robot robot = (Robot) director.getRobot();
        System.out.println(robot.toString());
    }
}
