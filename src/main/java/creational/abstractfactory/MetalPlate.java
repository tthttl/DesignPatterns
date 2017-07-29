package creational.abstractfactory;

public class MetalPlate implements Shield {
    @Override
    public void shieldsUp() {
        System.out.println("The hull is intact");
    }
}
