package behavioral.visitor;

public class Fruit implements Visitable {

    int price;
    int weight;

    public Fruit(int price, int weight) {
        this.price = price;
        this.weight = weight;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
