package behavioral.command_interfacewithexecute;

public class TurnOff implements Command {

    private Tv tv;

    public TurnOff(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.setIsOn(false);
    }
}
