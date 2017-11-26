package structural.composite_everyobjectimplementsthesameinterface;

public class Triangle implements Shape{

    @Override
    public void draw(String color) {
        System.out.println(color + " " + this.getClass().getName() + " is drawn.");
    }
}
