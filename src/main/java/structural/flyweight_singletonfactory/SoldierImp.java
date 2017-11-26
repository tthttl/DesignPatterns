package structural.flyweight_singletonfactory;

public class SoldierImp implements Soldier {

//    INTRINSIC state => maintained by Flyweight (complicated object)
    private Object graphicalRepresentation;


//    the parameters are EXTRINSIC data ==> not stored in Flyweight, but managed by the Client
//    the movement logic is maintained by the Flyweight
    @Override
    public void move(int previousLocationX, int previousLocationY, int newLocationX, int newLocationY) {
//    delete soldier from previous location and create a new at the new location
    }
}
