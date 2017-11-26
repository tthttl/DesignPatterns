package creational.factorymethod_interfacewithafactorymethod;

public abstract class Factory {
    // az "abstract" factorynak van egy protected methodja, amit a konkr�t factory fog megval�s�tani �s ez d�nti majd el,
    // hogy mi legyen a konkr�t product type amit l�trehoz az egy�bk�nt publikus method, amit a user is meg tud h�vni.
    // Att�l f�gg�en v�ltozik a konkr�t product, hogy milyen factory.anOperationWhichNeedsAProduct() (egy�bk�nt k�z�s) methodj�t h�vjuk meg
    public void anOperationWhichNeedsAProduct(){
        System.out.println("doStuff");
        Product product = createProduct();
        System.out.println(product.toString());
    }

    protected abstract Product createProduct();

}
