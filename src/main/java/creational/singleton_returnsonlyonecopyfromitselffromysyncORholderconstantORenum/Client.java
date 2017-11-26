package creational.singleton_returnsonlyonecopyfromitselffromysyncORholderconstantORenum;

public class Client {

    public static void main(String[] args) {

        Singleton singleton = Singleton.getInstance();
        SingletonII singletonII = SingletonII.getInstance();
        SingletonIII singletonIII = SingletonIII.INSTANCE;

    }


}
