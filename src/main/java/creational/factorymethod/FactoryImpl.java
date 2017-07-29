package creational.factorymethod;

public class FactoryImpl extends Factory {
    @Override
    protected Product createProduct() {
        return new ProductImpl();
    }
}
