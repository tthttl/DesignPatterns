package behavioral.strategy;

public class Chicken {

    private Behaviour behaviour;

    public Chicken(Behaviour behaviour) {
        this.behaviour = behaviour;
    }

    public void makeAMove(){
        behaviour.move();
    }
}
