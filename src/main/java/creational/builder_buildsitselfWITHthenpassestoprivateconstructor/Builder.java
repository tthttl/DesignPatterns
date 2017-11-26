package creational.builder_buildsitselfWITHthenpassestoprivateconstructor;

public interface Builder {

    void buildRobotHead();
    void buildRobotTorso();
    void buildRobotArms();
    void buildRobotLegs();
    RobotPlan getRobot();
}
