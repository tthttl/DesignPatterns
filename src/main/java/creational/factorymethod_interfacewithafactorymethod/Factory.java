package creational.factorymethod_interfacewithafactorymethod;

public abstract class Factory {
    // az "abstract" factorynak van egy protected methodja, amit a konkrét factory fog megvalósítani és ez dönti majd el,
    // hogy mi legyen a konkrét product type amit létrehoz az egyébként publikus method, amit a user is meg tud hívni.
    // Attól függõen változik a konkrét product, hogy milyen factory.anOperationWhichNeedsAProduct() (egyébként közös) methodját hívjuk meg
    public void anOperationWhichNeedsAProduct(){
        System.out.println("doStuff");
        Product product = createProduct();
        System.out.println(product.toString());
    }

    protected abstract Product createProduct();

}
