package behavioral.interpreter_contexttobinarytohexastring.practice;

public class Hexa implements Tolmacs {

    private int input;

    public Hexa(int input) {
        this.input = input;
    }

    @Override
    public String fordit(TolmacsContext context) {
        return context.toHexa(input);
    }
}
