package creational.singleton_returnsonlyonecopyfromitselffromysyncORholderconstantORenum;

// csak 1 instance legyen
// ==> privát kosntruktor, hogy csak innen lehessen létrehozni ==> ezért kell a static creational.factory, ami behív a privát konstruktorba ==> ezért kell az instancenak is staticnak lennie
// ==> synchronized method, hogy ne tudja egyszerre 2 szál létrehozni

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
