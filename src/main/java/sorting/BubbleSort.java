package sorting;

import java.util.Arrays;

public class BubbleSort {

    //Complexity: O(N2) Quadratical, Adaptive (Can break out early), Stable (Do not move equal elements), Sorts in place, do not require additional space.
    //Faster on a nearly sorted list
    public static void main(String[] args) {

        int[] arrayToSort = {6, 5, 4, 7, 9, 8, 1, 3, 2, 10};

        // itt ez csak az iterációk száma, hogy végigmenjünk minden elemen, ha kell
//        for (int i = 0; i < arrayToSort.length; i++) {
//            boolean isSwapped = false;
//            // egymás melletti elemeket hasonlítunk össze ==> k<k-1, és minden iterációnál eggyel több elem van sortolva, ezért csak i ig
//            for (int k = arrayToSort.length - 1; k > i; k--) {
//                if (arrayToSort[k] < arrayToSort[k - 1]) {
//                    swap(arrayToSort, k - 1, k);
//                    isSwapped = true;
//                }
//            }
//            if (!isSwapped) {
//                break;
//            }
//            print(arrayToSort);
//        }

        bubbleSortPractice(arrayToSort);

    }

    private static void bubbleSortPractice(int[] arrayToSort) {

        for (int i = 0; i < arrayToSort.length; i++) {
            boolean isSwapOccurred = false;
            for (int k = arrayToSort.length - 1; k > i; k--) {
                if (arrayToSort[k] < arrayToSort[k - 1]) {
                    swap(arrayToSort, k - 1, k);
                    isSwapOccurred = true;
                }
            }
            print(arrayToSort);
            if (!isSwapOccurred) {
                break;
            }
        }

    }


    public static int[] swap(int[] arrayToSort, int indexK_1, int indexK) {

        int temp = arrayToSort[indexK_1];
        arrayToSort[indexK_1] = arrayToSort[indexK];
        arrayToSort[indexK] = temp;
        return arrayToSort;

    }

    public static void print(int[] arrayToSort) {
        Arrays.stream(arrayToSort).forEach(System.out::print);
        System.out.println();
    }

}
