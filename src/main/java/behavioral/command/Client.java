package behavioral.command;

public class Client {

//    When you need to decouple the commands and their execution logic. ==> The execution might differ in every implementation.
//    The remote is just a queue or list to collect the commands and then call their execute methods. ==> Each implementation will know how to execute.
    public static void main (String[] args){

        Tv tv = new Tv();

        Command turnOn = new TurnOn(tv);
        Command turnOff = new TurnOff(tv);

        RemoteControl remote = new RemoteControl();

        remote.addCommand(turnOn);
        remote.addCommand(turnOff);
        remote.addCommand(turnOn);
        remote.addCommand(turnOff);
        remote.addCommand(turnOn);
        remote.addCommand(turnOff);

        remote.executeCommands();

    }

}
