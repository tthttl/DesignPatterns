package sorting;

import java.util.Arrays;

public class Insertion {

    //Complexity: O(N2) Quadratical, Adaptive (Can break out early), Stable (Do not move equal elements), Sorts in place, do not require additional space.
    //Faster on a nearly sorted list, requires fewer swaps than bubble sort. 
    public static void main(String[] args) {

        int[] arrayToSort = {6, 5, 4, 7, 9, 8, 1, 3, 2, 10};

        // itt ez csak az iterációk száma, hogy végigmenjünk minden elemen
//        for (int i = 0; i < arrayToSort.length - 1; i++) {
//            //minden elemet megpróbálunk bubble sortolni, de egyesével jobbra haladva és, csak akkor, ha kisebb, mint
//            //a már sortednak feltételezz lista jobbszéle.
//            for (int k = i + 1; k > 0; k--) {
//                if (arrayToSort[k] < arrayToSort[k - 1]) {
//                    swap(arrayToSort, k, k - 1);
//                } else {
//                    break;
//                }
//            }
//            print(arrayToSort);
//        }

        insertionSortPractice(arrayToSort);

    }

    private static void insertionSortPractice(int[]arrayToSort){

        for (int i = 0; i<arrayToSort.length-1; i++){
            for (int k = i+1; k>0; k--){
                if (arrayToSort[k]<arrayToSort[k-1]){
                    swap(arrayToSort,k,k-1);
                } else {
                    break;
                }
            }
            print(arrayToSort);
        }

    }

    public static int[] swap(int[] arrayToSort, int indexK, int indexK_1) {

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
