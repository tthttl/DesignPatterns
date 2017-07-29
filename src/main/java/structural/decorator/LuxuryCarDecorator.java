package structural.decorator;

public class LuxuryCarDecorator extends CarDecorator {

    public LuxuryCarDecorator(Car car) {
        super(car);
    }

    //    Other decorators are children of the original decorator, and they add additional functionality to the original method declared by the interface and implemented by the original object.
    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding luxury.");
    }
}
