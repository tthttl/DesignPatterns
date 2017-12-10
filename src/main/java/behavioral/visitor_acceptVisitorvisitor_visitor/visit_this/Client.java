package behavioral.visitor;

// Goal: Outsourcing a common logic from similar (Visitable) objects into a different class
// ==> The new class will be the visitor and its VISIT method gets called by the visitable objects inside their ACCEPT method which takes a Visitor as argument
//(very similar to Observer)
public class Client {

    public static void main (String[] args) {

        Book book = new Book(12);
        Fruit fruit = new Fruit(1,3);

        PriceCalculator calculator = new PriceCalculator();

        book.accept(calculator);
        fruit.accept(calculator);

        System.out.println(calculator.sum);

    }

}
