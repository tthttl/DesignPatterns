package interviewquestions.shadowing;

public class Client {

    public static void main (String[]args){

        Parent parent = new Parent(1);
        Sub sub = new Sub(1);

        System.out.println("parent.a = "  + parent.a);
        System.out.println("parent.printA() = " + parent.returnA());
        System.out.println("sub.a = "  + sub.a); //variable shadowing
        System.out.println("sub.printA() = " + sub.returnA()); //method override

        Parent parentReferenceToASubInstance = new Sub(1);

        System.out.println("parentReferenceToASubInstance.a = " + parentReferenceToASubInstance.a); //Variables names are resolved by reference type
        System.out.println("parentReferenceToASubInstance.returnA = " + parentReferenceToASubInstance.returnA()); //Only those methods can be called which are present at the parent class, but if they are overridden in subclass, the overridden method will be called!

        System.out.println();

        System.out.println(sub.returnSUMofSubAndParent()); //Superrel meghívhatjuk a parent eredeti methodját, amit a sub-ban overridoltunk.
    }

}
