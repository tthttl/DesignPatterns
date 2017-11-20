package sorting;

import java.util.Arrays;

public class MergeSort {


    public static void main(String[] args) {

        int[] arrayToSort = {6, 5, 4, 7, 9, 8, 1, 3, 2, 10};

        mergeSort(arrayToSort);

    }

    /*
    Rekurz�van megh�vhat� split => A felosztand� array els� fele az els� fel�be a m�sodik fele a m�sodik fel�be megy.
    A m�sodik fel�nek indexel�se azzal, hogy kivonjuk bel�le az els� hossz�t, 0-val �jrakez�dik.
     */
    public static void split(int[] arrayToSort, int[] firstHalf, int[] secondHalf) {

        int continuouslyGrowingArrayIndex = 0;

        int secondHalfStartIndex = firstHalf.length;

        for (int element : arrayToSort) {
            if (continuouslyGrowingArrayIndex < secondHalfStartIndex) {
                firstHalf[continuouslyGrowingArrayIndex] = arrayToSort[continuouslyGrowingArrayIndex];
            } else {
                secondHalf[continuouslyGrowingArrayIndex - secondHalfStartIndex] = arrayToSort[continuouslyGrowingArrayIndex];
            }
            continuouslyGrowingArrayIndex++;
        }
    }

    /*
    Semmi m�st nem csin�l, csak �sszehasonl�tja a k�t f�llista legkisebb index� elem�t, �s a kisebbet rakja bele result list�ba.
    Akkor is m�k�dnie kell, ha egy elem� a lista, meg akkor is, ha t�bb.
    El�g mindig a legkisebb indexet n�zni, mert a list�k vagy egy darab�ak, vagy sorba vannak rendezve, azaz a k�s�bbi elem nem lehet nagyobb.
    Val�sz�n�leg a k�t lista nem egyszerre fogy el, hanem az egyikben m�g maradnak olyan elemek, amelyek biztoan nagyobbak, mint az elemek amik a m�sikban voltak,
    hiszen akkor ezek ker�ltek volna be a result listbe. �gy ezeket el�g csak hozz�adni ut�lag. (ez a k�t if/while a v�g�n).
     */

    public static void compare(int[] arrayToSort, int[] firstHalf, int[] secondHalf) {

        int FHIndex = 0;
        int SHIndex = 0;
        int resultIndex = 0;

        // sima compare, am�g az egyik lista el nem fogy mindig berakja a soronk�vetkez� legkisebb elemet a result listbe.
        while (FHIndex < firstHalf.length && SHIndex < secondHalf.length) {
            if (firstHalf[FHIndex] < secondHalf[SHIndex]) {
                arrayToSort[resultIndex] = firstHalf[FHIndex];
                FHIndex++;
            } else if (secondHalf[SHIndex] < firstHalf[FHIndex]) {
                arrayToSort[resultIndex] = secondHalf[SHIndex];
                SHIndex++;
            }
            resultIndex++;
        }

        // amelyik list�ban m�g maradt elem azokat egym�s ut�n (hiszen sortolva vannak) berakja a result listbe
        if (FHIndex < firstHalf.length) {
            while (resultIndex < arrayToSort.length) {
                arrayToSort[resultIndex++] = firstHalf[FHIndex++];
            }
        }

        if (SHIndex < secondHalf.length) {
            while (resultIndex < arrayToSort.length) {
                arrayToSort[resultIndex++] = secondHalf[SHIndex++];
            }
        }
    }

    /*
    ez csak kialak�tja az inputot a split meg a compare sz�m�ra, majd megh�vja �ket
     */
    public static void mergeSort(int[]arrayToSort){

        //Ha a merge sortban az array lengthje 1, akkor abb�l visszat�r�nk, de egy�bk�nt nem!!!
        //Az a merge sort, amiben az array lengthje hoszabb, az tov�bb megy a compare-re majd a printre!
        if (arrayToSort.length == 1){
            System.out.println("Returning from mergeSort()" + arrayToSort[0]);
            return;
        }

        int midIndex = arrayToSort.length/2 + (arrayToSort.length % 2); //arra az esetre ha v�letlen�l nem p�ros list�t akarn�nk sortolni ==> az els�ben mindig 1-gyel t�bb elem lesz

        int[]firstHalf = new int[midIndex];
        int[]secondHalf = new int[arrayToSort.length-midIndex];

        System.out.println("Splitting: ");
        Arrays.stream(arrayToSort).forEach(System.out::print);
        System.out.println();
        split(arrayToSort, firstHalf, secondHalf);

        mergeSort(firstHalf);
        mergeSort(secondHalf);

        System.out.println("Comparing: ");
        Arrays.stream(firstHalf).forEach(System.out::print);
        System.out.println();
        Arrays.stream(secondHalf).forEach(System.out::print);
        System.out.println();
        compare(arrayToSort, firstHalf, secondHalf);

//        print(arrayToSort);

    }

    public static void print (int[]arrayToSort){
        Arrays.stream(arrayToSort).forEach(System.out::print);
        System.out.println();
    }


}
