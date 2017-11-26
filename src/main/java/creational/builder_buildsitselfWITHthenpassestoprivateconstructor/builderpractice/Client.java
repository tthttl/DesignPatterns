package creational.builder_buildsitselfWITHthenpassestoprivateconstructor.builderpractice;

public class Client {

    public static void main(String[] args) {

        Robot robi = Robot.getBuilder()
                .withHead("Head")
                .withArms("Arms")
                .withTorso("Torso")
                .withLegs("Legs")
                .build();

        System.out.println(robi);

    }

}
