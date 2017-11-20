package recursion;

public class Fibonacci {

    public static void main(String[] args) {

        System.out.println(calculateFibonaccis(10));

    }

    public static int calculateFibonaccis(int num){
        return calculateFibonaccis(0, 1, num-2);
    }

    public static int calculateFibonaccis(int pre, int num, int limit) {

        if (limit == 0){
            return num;
        }

        int next = pre + num;

        return calculateFibonaccis(num, next, limit-1);

    }

}
