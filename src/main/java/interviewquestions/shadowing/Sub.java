package interviewquestions.shadowing;

public class Sub extends Parent {

    public int a;

    public Sub(int a) {
        super(a);
    }

    public int returnA(){
        return a;
    }

    public int returnSUMofSubAndParent(){
        return returnA() + super.returnA();
    }

}
