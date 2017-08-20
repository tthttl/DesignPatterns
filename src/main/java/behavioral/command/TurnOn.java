package behavioral.command;

public class TurnOn implements Command {

    private Tv tv;

    public TurnOn(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.setIsOn(true);
    }
}
