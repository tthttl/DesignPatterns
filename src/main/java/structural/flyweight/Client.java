package structural.flyweight;

public class Client {

    private Soldier soldier = SoldierFactory.getSoldier();

    //this is the Soldier's EXTRINSIC state which is maintained by the Client!
    private int currentLocationX;
    private int currentLocationY;

    public Client(int currentLocationX, int currentLocationY) {
        this.currentLocationX = currentLocationX;
        this.currentLocationY = currentLocationY;
    }

    public void moveSoldier(int newLocationX, int newLocationY) {
//        The Flyweight object manages the movement
        soldier.move(currentLocationX, currentLocationY, newLocationX, newLocationY);
//        The location parameters are maintained by the Client!
        currentLocationX = newLocationX;
        currentLocationY = newLocationY;
    }

}
