package behavioral.command;

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
