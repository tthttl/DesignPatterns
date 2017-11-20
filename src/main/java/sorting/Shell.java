package sorting;

import java.util.Arrays;

public class Shell {

    /*
    Sima insertion sort egyre cs�kken� spread� sublistekre, majd a v�g�n 1-re
    Az increment az ami feldarabolja a list�t, ami kiszedi minden incrementedik elemet.
    Azt�n ezeket sorba rakjuk insertion sorttal ==> ami mindig a list jobbra l�v� elem�t tolja balra, ha kisebb(like bubblesort).
     */




    public static void main(String[]args){

        int[] arrayToSort = {6, 5, 4, 7, 9, 8, 1, 3, 2, 10};

        shellSort(arrayToSort);

    }

    public static void shellSort(int[]arrayToSort){
        int increment = arrayToSort.length/2;

        //Minden increment nagys�gra a lista minden elem�t sortoljuk, csak ugye mindig sublistenk�nt, de mindig 1-gyel n�vekv� startindexr�l.
        while (increment>=1){
            for (int startIndex = 0; startIndex<increment; startIndex++){
                insertionSort(arrayToSort,startIndex,increment);
            }
            increment = increment/2;
        }


    }


    public static void insertionSort(int[]arrayToSort, int startIndex, int increment){

        for (int i=startIndex; i<arrayToSort.length-increment; i= i+increment){
            for(int k = Math.min(i+increment, arrayToSort.length-1);
                k>startIndex;
                k= k-increment){
                if (arrayToSort[k]<arrayToSort[k-increment]){
                    swap(arrayToSort,k,k-increment);
                } else {
                    break;
                }
            }
            print(arrayToSort);
        }

    }

    public static void swap (int[]arrayToSort, int indexK, int indexK_1){

        int temp = arrayToSort[indexK_1];
        arrayToSort[indexK_1] = arrayToSort[indexK];
        arrayToSort[indexK] = temp;

    }

    public static void print (int[]arrayToSort){

        Arrays.stream(arrayToSort)
                .forEach(System.out::print);

        System.out.println();

    }


}
