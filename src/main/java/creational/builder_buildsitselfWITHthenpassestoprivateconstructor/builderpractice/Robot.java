package creational.builder_buildsitselfWITHthenpassestoprivateconstructor.builderpractice;

public class Robot {

    private String head;
    private String torso;
    private String arms;
    private String legs;

    private Robot (RobotBuilder builder){
        this.head = builder.head;
        this.arms = builder.arms;
        this.torso = builder.torso;
        this.legs = builder.legs;
    }

    public static RobotBuilder getBuilder(){
        return new RobotBuilder();
    }

    @Override
    public String toString() {
        return "Robot{" +
                "head='" + head + '\'' +
                ", torso='" + torso + '\'' +
                ", arms='" + arms + '\'' +
                ", legs='" + legs + '\'' +
                '}';
    }

    public static class RobotBuilder {

        private String head;
        private String torso;
        private String arms;
        private String legs;

        public RobotBuilder withHead(String head){
            this.head = head;
            return this;
        }

        public RobotBuilder withTorso(String torso){
            this.torso = torso;
            return this;
        }

        public RobotBuilder withArms(String arms){
            this.arms = arms;
            return this;
        }

        public RobotBuilder withLegs(String legs){
            this.legs = legs;
            return this;
        }

        public Robot build(){
            return new Robot(this);
        }

    }

}
