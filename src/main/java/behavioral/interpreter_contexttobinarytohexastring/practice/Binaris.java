package behavioral.interpreter_contexttobinarytohexastring.practice;

public class Binaris implements Tolmacs {

    private int input;

    public Binaris(int input) {
        this.input = input;
    }

    @Override
    public String fordit(TolmacsContext context) {
        return context.toBinaris(input);
    }
}
