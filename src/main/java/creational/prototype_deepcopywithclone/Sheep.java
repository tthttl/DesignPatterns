package creational.prototype_deepcopywithclone;

public class Sheep implements Cloneable {

    public void sayBee(){
        System.out.println("Beeeeeeeee");
    }

    @Override
    public Sheep clone() {
        return new Sheep();
    }
}
