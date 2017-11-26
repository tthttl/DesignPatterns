import creational.builder_buildsitselfWITHthenpassestoprivateconstructor.Director;
import creational.builder_buildsitselfWITHthenpassestoprivateconstructor.Robot;
import creational.builder_buildsitselfWITHthenpassestoprivateconstructor.RobotBuilder;
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
