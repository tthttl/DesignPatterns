package creational.factory;

public abstract class MotherShip {

    private String shipType;

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public void displayShip(){
        System.out.println("This is a "+shipType+"!");
    }

}
