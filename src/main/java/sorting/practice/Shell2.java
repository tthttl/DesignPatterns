package sorting.practice;

import java.util.Arrays;

public class Shell2 {

    public static void main(String[] args) {

        int[] arrayToSort = {6, 5, 4, 7, 9, 8, 1, 3, 2, 10};

        shellSort(arrayToSort);

    }

    public static void shellSort(int[] arrayToSort) {
        int gap = arrayToSort.length / 2;
        while (gap >= 1) {
            insertionSort(arrayToSort, gap);
            gap = gap / 2;
        }
    }

    public static void insertionSort(int[] arrayToSort, int gap) {
        for (int i = 0; i < arrayToSort.length - gap; i = i + gap) {
            for (int k = Math.min(i + gap, arrayToSort.length-1);
                 k > 0;
                 k = k - gap) {
                if (arrayToSort[k] < arrayToSort[k - gap]){
                    swap(arrayToSort, k, k - gap);
                } else {
                    break;
                }
                print(arrayToSort);
            }
        }
    }

    public static void swap(int[] arrayToSort, int indexK, int indexK_1) {

        int temp = arrayToSort[indexK_1];
        arrayToSort[indexK_1] = arrayToSort[indexK];
        arrayToSort[indexK] = temp;

    }

    public static void print(int[] arrayToSort) {

        Arrays.stream(arrayToSort)
                .forEach(System.out::print);

        System.out.println();

    }

}
