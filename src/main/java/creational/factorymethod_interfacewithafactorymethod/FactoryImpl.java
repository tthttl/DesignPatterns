package creational.factorymethod_interfacewithafactorymethod;

public class FactoryImpl extends Factory {
    @Override
    protected Product createProduct() {
        return new ProductImpl();
    }
}
