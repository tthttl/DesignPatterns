package creational.prototype;

public class Sheep implements Animal {

    public void sayBee(){
        System.out.println("Beeeeeeeee");
    }
// bewrappeljuk a super.clone methodot, így hozunk létre több ugyanolyan objectet.. annyi, hogy extendelnie kell a prototypenak a Cloneable interfacet a checked exception miatt
    @Override
    public Animal makeClone() {
        try {
            return (Animal) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
