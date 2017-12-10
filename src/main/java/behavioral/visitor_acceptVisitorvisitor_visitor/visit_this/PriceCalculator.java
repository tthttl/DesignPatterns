package behavioral.visitor;

public class PriceCalculator implements Visitor {

    int sum;

    @Override
    public void visit(Book book) {
        this.sum += book.price;
    }

    @Override
    public void visit(Fruit fruit) {
        this.sum = this.sum + fruit.price* fruit.weight;
    }
}
