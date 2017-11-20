package recursion;

public class Factorial {

    public static void main (String[]args){

        int n = 5;

        System.out.println(calculateFactorial(n));

    }

    private static int calculateFactorial(int n) {

        //Exit condition
        if (n == 0){
            return 1;
        }

        return n * calculateFactorial(n - 1);

    }

}
