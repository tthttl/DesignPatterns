package structural.decorator_implementsANDwrapstheoriginalobject;

public class App {

    //    Decorator adds additional functionality at RUNTIME.
    //    The decorator also implements the interface (to be able to use the DECORATED object in place of a SIMPLE object) AND
    //    has a composite with the interface type (to be able to add extra functionality to the original) (after calling super first to preserve the original function)

    public static void main(String[] args) {

        Car car = new CarImp(120);

        SportsCarDecorator sportsCarDecorator = new SportsCarDecorator(car);

        LuxuryCarDecorator luxuryCarDecorator = new LuxuryCarDecorator(sportsCarDecorator);

        luxuryCarDecorator.assemble();

    }

}
