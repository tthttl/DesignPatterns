package datastructures.array;

import java.util.Arrays;

public class Client {

    public static void main(String[] args){

        int[] a = {1,2,3};
        int[] b = {1,2,3};

        System.out.println(a == b);

        a = b;

        /* DECLARATION */

        int[] c = new int [3];
        int[] d = new int []{1,2,3};
        int[] e = {1,2,3};


        System.out.println(a == b);

        Array notActuallyAnArrayCauseItsNotInstantiatedFromAClass = new Array(0);
        int[] f = notActuallyAnArrayCauseItsNotInstantiatedFromAClass.delete(d,1);

        Arrays.stream(f).forEach(System.out::println);

        f = notActuallyAnArrayCauseItsNotInstantiatedFromAClass.add(f,2,1);

        System.out.print("After add: ");

        Arrays.stream(f).forEach(System.out::print);

        System.out.println();
        System.out.println("14%10: " + 14%10);


    }







}
