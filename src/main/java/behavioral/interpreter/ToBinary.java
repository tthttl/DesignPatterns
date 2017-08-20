package behavioral.interpreter;

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
