package creational.factory;

public class Shipyard {

    public MotherShip buildShip(int size){
        switch (size){
            case 1: return new SmallShip();
            case 2: return new LargeShip();
            case 3: return new BigShip();
            default:return null;
        }
    }


}
