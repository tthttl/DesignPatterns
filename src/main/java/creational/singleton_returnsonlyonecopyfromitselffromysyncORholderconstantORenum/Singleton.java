package creational.singleton_returnsonlyonecopyfromitselffromysyncORholderconstantORenum;

// csak 1 instance legyen
// ==> priv�t kosntruktor, hogy csak innen lehessen l�trehozni ==> ez�rt kell a static creational.factory, ami beh�v a priv�t konstruktorba ==> ez�rt kell az instancenak is staticnak lennie
// ==> synchronized method, hogy ne tudja egyszerre 2 sz�l l�trehozni

public class Singleton {

    private Singleton(){}
    private static Singleton instance;

    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }

        return instance;
    }

}
