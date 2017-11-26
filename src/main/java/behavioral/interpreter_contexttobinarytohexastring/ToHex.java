package behavioral.interpreter_contexttobinarytohexastring;

public class ToHex implements Interpreter {

    int input;

    public ToHex(int input) {
        this.input = input;
    }

    @Override
    public void interpret(InterpreterContext context) {
        context.toHexaDecimalString(input);
    }
}
