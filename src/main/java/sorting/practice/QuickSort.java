package sorting.practice;

import java.util.Arrays;

public class QuickSort {

    //O(NLOGN), nem adapt�v, nem stabil, kell add�cion�lis space neki, viszont mivel csak worst case O(N2) ez�rt ezt haszn�lja minden java library

    public static void main(String[] args) {

        int[] arrayToSort = {6, 5, 4, 7, 9, 8, 1, 3, 2, 10};

        quickSort(arrayToSort, 0, arrayToSort.length-1);

    }

    public static void quickSort(int[] arrayToSort, int leftEnd, int rightEnd) {

        int leftIndex = leftEnd;
        int rightIndex = rightEnd;

        //finding the ELEMENT at middle position at every recursion by:
        // 1: adjusting starting point (leftEnd)
        // 2: halving the distance between start and end point (tulk�pp ez a felez�s)
        int pivotElement = arrayToSort[leftEnd + (rightEnd - leftEnd) / 2];

        while (leftIndex <= rightIndex) {

            //finding the first element on the wrong side ==> having greater value than pivotElement on the left
            while (arrayToSort[leftIndex] < pivotElement) {
                leftIndex++;
            }
            //finding the first element on the wrong side ==> having smaller value than pivotElement on the right
            while (arrayToSort[rightIndex] > pivotElement) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(arrayToSort, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }

        //a sorrend itt nem sz�m�t, mert mindk�t oldalon csak olyan elemek vannak, amiket a m�sik oldallal m�r nem kell cser�lni
        //addig mozog az index, am�g el nem �r az ellent�tes v�ghez, mert akkor van megcser�lve az utols� elem is biztosan
        if (rightIndex>leftEnd){
            quickSort(arrayToSort, leftEnd, rightIndex);
            print(arrayToSort);
            System.out.println("leftend" + leftEnd);
            System.out.println("rightIndex" + rightIndex);
        }
        if (leftIndex<rightEnd){
            quickSort(arrayToSort, leftIndex, rightEnd);
//            print(arrayToSort);
//            System.out.println("leftIndex" + leftIndex);
//            System.out.println("rightEnd" + rightEnd);

        }

    }


    public static void swap(int[] arrayToSort, int leftIndex, int rightIndex) {

        int temp = arrayToSort[leftIndex];
        arrayToSort[leftIndex] = arrayToSort[rightIndex];
        arrayToSort[rightIndex] = temp;

    }

    public static void print (int[] arrayToSort){

        Arrays.stream(arrayToSort).forEach(System.out::print);
        System.out.println();

    }

}
