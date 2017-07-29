package homework.immutable;

public class ImmutableCounter {

    private final int result;

    public static ImmutableCounter getCounter() {
        return new ImmutableCounter();
    }

    private ImmutableCounter(int previousCounter, int newNumber, Methods method) {
        switch (method) {
            case PLUS:
                this.result = previousCounter + newNumber;
                break;
            case MINUS:
                this.result = previousCounter - newNumber;
                break;
            case MULTIPLY:
                this.result = previousCounter * newNumber;
                break;
            case DIVIDE:
                this.result = previousCounter / newNumber;
                break;
            default: throw new IllegalArgumentException();
        }
    }

    private ImmutableCounter() {
        this.result = 0;
    }

    public ImmutableCounter add(int number) {
        return new ImmutableCounter(this.result, number, Methods.PLUS);
    }

    public ImmutableCounter deduct(int number) {
        return new ImmutableCounter(this.result, number, Methods.MINUS);
    }

    public ImmutableCounter multiply(int number) {
        return new ImmutableCounter(this.result, number, Methods.MULTIPLY);
    }

    public ImmutableCounter divide(int number) {
        return new ImmutableCounter(this.result, number, Methods.DIVIDE);
    }

    public int getResult() {
        return result;
    }

    // To create immutable class in java, you have to do following steps.

//    1. Declare the class as final so it can’t be extended. A more sophisticated approach is to make the constructor private and construct instances in factory methods.
//    2. Make all fields private so that direct access is not allowed.
//    3. Don’t provide setter methods for variables
//    4. Make all mutable fields final so that it’s value can be assigned only once.
//    5. Initialize all the fields via a constructor performing deep copy/defensive copy (pass a new Object not the original parameter).
//    6. Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference. ==> Only necessary in case of mutable variables. Strings/Primitive Wrappers
//    are immutable, primitives cannot be altered through method calls because of pass by value.

    // Innately thread safe; can be cached; can be used as key in map;

}
