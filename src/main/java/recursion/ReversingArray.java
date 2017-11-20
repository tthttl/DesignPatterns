package recursion;

import java.util.Arrays;

public class ReversingArray {

    public static void main(String[] args) {

        int[] arrayToReverse = {1, 2, 3};

        reverse(arrayToReverse, 0, arrayToReverse.length - 1);

        Arrays.stream(arrayToReverse).forEach(System.out::print);
    }

    private static void reverse(int[] arrayToReverse, int low, int high) {
        if (high == 0) {
            return;
        } else {
            swap(arrayToReverse, low, high);
            reverse(arrayToReverse, low + 1, high - 1);
        }
    }

    private static void swap(int[] arrayToReverse, int low, int high) {

        int temp = arrayToReverse[low];
        arrayToReverse[low] = arrayToReverse[high];
        arrayToReverse[high] = temp;

    }



}
