package behavioral.interpreter_contexttobinarytohexastring;

public class ToBinary implements Interpreter{

    int input;

    public ToBinary(int input) {
        this.input = input;
    }


    @Override
    public void interpret(InterpreterContext context) {
        context.toBinaryString(input);
    }
}
