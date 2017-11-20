package interviewquestions.passbyvalue;

import java.util.Arrays;

public class Client {

    static int a = 2;

    public static void main (String[]args){

        Target object = new Target(1);

        modify(object);
        System.out.println("outside object.num = " + object.num);

        modify(a);

        System.out.println("outside a = " + a);

        System.out.println();
        reassign(object);
        System.out.println("after reassign object.num = " + object.num);

    }

    /*
    When passing arguments to a method JAVA COPIES the references!
    ==> As primitives are stored in the variable itself, the method will alter the copy, and the original variable will be left unchanged.
    ==> The copy of the object reference will point to the same object in the heap, so if we change the object itself, the original reference will still point to the same object. ==> It is changed.
    However if we reassign the reference to point to a new object, the original reference will still point to the same object!!
     */

    public static void modify(Target object){

        object.num = 10;
        System.out.println("inside modify object.num = " + object.num);

    }

    public static void reassign (Target object){

        object = new Target(100);
        System.out.println("inside reassign object.num = " + object.num);

    }

    public static void modify(int a){

        a = 10;
        System.out.println("inside modify a = " + a);

    }


}
