package structural.decorator;

public class App {

//    Decorator adds additional functionality at RUNTIME.

    public static void main (String[] args){

        Car car = new CarImp(120);

        SportsCarDecorator sportsCarDecorator = new SportsCarDecorator(car);

        LuxuryCarDecorator luxuryCarDecorator = new LuxuryCarDecorator(sportsCarDecorator);

        luxuryCarDecorator.assemble();

    }

}
