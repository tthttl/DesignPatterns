package behavioral.visitor;

public class Book implements Visitable {

    int price;

    public Book(int price) {
        this.price = price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
