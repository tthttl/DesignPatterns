package structural.flyweight_singletonfactory;

public class SoldierFactory {

//    Static field means there is only one object in the memory at all times, and this object is not related to any other object.
    private static Soldier SOLDIER;

    public static synchronized Soldier getSoldier(){

        if (SOLDIER == null){
            SOLDIER = new SoldierImp();
        }
        return SOLDIER;

    }

}
