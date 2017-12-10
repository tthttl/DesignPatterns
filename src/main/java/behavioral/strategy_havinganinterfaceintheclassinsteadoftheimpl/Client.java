package behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

// Goal: Basic interface logic ==> The implementing classes can have different behaviours depending on their own implementation...
// Decoupling + Composition ==> Not the behaviour is passed directly, only an interface as a field ==> remains interchangeable, can be refactored
public class Client {

    public static void main (String[] args){

        Behaviour agressive = new Agressive();
        Behaviour defensive = new Defensive();
        Behaviour cool = new Cool();

        Chicken agressiveChicken = new Chicken(agressive);
        Chicken scared = new Chicken(defensive);
        Chicken coolCat = new Chicken(cool);

        List<Chicken> chicks = new ArrayList<>();

        chicks.add(agressiveChicken);
        chicks.add(scared);
        chicks.add(coolCat);

        chicks.stream().forEach(Chicken::makeAMove);

    }

}
