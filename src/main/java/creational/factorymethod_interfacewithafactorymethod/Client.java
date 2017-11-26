package creational.factorymethod_interfacewithafactorymethod;

public class Client {

    public static void main(String[] args) {

        Factory factory = new FactoryImpl();
        factory.anOperationWhichNeedsAProduct();

        Factory factory2 = new FactoryImpl2();
        factory2.anOperationWhichNeedsAProduct();

    }

}
