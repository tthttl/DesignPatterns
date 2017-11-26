package creational.factorymethod_interfacewithafactorymethod;

public class FactoryImpl2 extends Factory {
    @Override
    protected Product createProduct() {
        return new ProductImpl2();
    }
}
