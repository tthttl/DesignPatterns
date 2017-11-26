package behavioral.interpreter_contexttobinarytohexastring;

public class Client {

//    Interpret the input with the help of a context, which may have multiple transform methods.
// ==> The interface method receives the context and the implementations chose which method of the context to use.
    public static void main (String[] args){

        Interpreter toBinary = new ToBinary(121);
        Interpreter toHex = new ToHex(121);

        toBinary.interpret(new InterpreterContext());
        toHex.interpret(new InterpreterContext());
        
    }

}
