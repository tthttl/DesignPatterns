package behavioral.command;

public class Tv {

    private boolean isOn;

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
        if (isOn){
            System.out.println("Tv is on!");
        } else {
            System.out.println("Tv off!");
        }

    }
}
