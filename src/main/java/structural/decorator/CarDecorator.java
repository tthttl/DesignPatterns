package structural.decorator;

//    The decorator also implements the interface AND has a composite with the interface type (the original decorator both haa a Car field and implements the Car interface)
public class CarDecorator implements Car {

    private Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }


    //    When implementing the interface's method its actually a call to the composite's method.
    @Override
    public void assemble() {
        car.assemble();
    }
}
