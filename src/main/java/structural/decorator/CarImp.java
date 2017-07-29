package structural.decorator;

public class CarImp implements Car{

    private int speed;

    public CarImp(int speed) {
        this.speed = speed;
    }

    @Override
    public void assemble() {
        System.out.println("This car's speed is: "+speed);
    }
}
