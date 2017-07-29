package structural.flyweight;

public interface Soldier {

//    Aim of the Flyweight pattern is to share the same object (Soldier) among multiple Clients and thus spare the memory cost of creating a new one for every Client.
//    Especially useful if the Soldier is a complex heavy object.
//    The object's internal state is shared and the external state is stored in the multiple Clients.

    void move(int previousLocationX,
              int previousLocationY,
              int newLocationX,
              int newLocationY);

}
