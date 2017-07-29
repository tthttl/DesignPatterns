package structural.composite;

public class Circle implements Shape {

    @Override
    public void draw(String color) {
        System.out.println(color + " " + this.getClass().getName() + " is drawn.");
    }
}
