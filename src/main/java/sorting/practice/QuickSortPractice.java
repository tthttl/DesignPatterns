package sorting.practice;

import java.util.Arrays;

public class QuickSortPractice {

    public static void main(String[] args) {

        int[] arrayToSort = {6, 5, 4, 7, 9, 8, 1, 3, 2, 10};
        int[] input = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
//        quickSort(arrayToSort, 0, arrayToSort.length - 1);
        quickSort(input, 0, input.length-1);

    }


    public static void quickSort(int[] arrayToSort, int leftEnd, int rightEnd) {

        int leftIndex = leftEnd;
        int rightIndex = rightEnd;

        int pivotElement = arrayToSort[leftEnd + (rightEnd - leftEnd) / 2];

        while (leftIndex <= rightIndex) {

            while (arrayToSort[leftIndex] < pivotElement) {
                leftIndex++;
            }
            while (arrayToSort[rightIndex] > pivotElement) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                swap(arrayToSort, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
            print(arrayToSort);
        }

        if (leftIndex < rightEnd) {
            quickSort(arrayToSort, leftIndex, rightEnd);
        }
        if (rightIndex > leftEnd) {
            quickSort(arrayToSort, leftEnd, rightIndex);
        }
    }


    public static void swap(int[] arrayToSort, int leftIndex, int rightIndex) {

        int temp = arrayToSort[leftIndex];
        arrayToSort[leftIndex] = arrayToSort[rightIndex];
        arrayToSort[rightIndex] = temp;

    }

    public static void print(int[] arrayToSort) {

        Arrays.stream(arrayToSort).forEach(
                element -> {
                    System.out.print(element + "  ");
                }
        );
        System.out.println();

    }

}
