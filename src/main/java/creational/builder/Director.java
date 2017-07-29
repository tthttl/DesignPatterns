package creational.builder;

public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void buildRobot() {
        builder.buildRobotHead();
        builder.buildRobotTorso();
        builder.buildRobotArms();
        builder.buildRobotLegs();
    }

    public RobotPlan getRobot(){
        return builder.getRobot();
    }



}
