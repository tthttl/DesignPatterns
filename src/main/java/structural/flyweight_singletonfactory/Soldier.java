package structural.flyweight_singletonfactory;

public interface Soldier {

//    Aim of the Flyweight pattern is to share the same object (Soldier) among multiple Clients and thus spare the memory cost of creating a new one for every Client.
//    Especially useful if the Soldier is a complex heavy object.
//    The object's internal state is shared and the external state is stored in the multiple Clients.
//    Majd a Client változtat rajta, kiegészíti ha akarja, de az alap amit visszakap az mindig ugyanaz a már létező static object
//   (vagy egy elem egy setből/mapből) így megspóroljuk azt, hogy mindig egy újat kelljen létrehozni szerver oldalon ==> elég lesz client oldalon

    void move(int previousLocationX,
              int previousLocationY,
              int newLocationX,
              int newLocationY);

}
