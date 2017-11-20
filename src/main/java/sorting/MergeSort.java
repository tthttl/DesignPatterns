package sorting;

import java.util.Arrays;

public class MergeSort {


    public static void main(String[] args) {

        int[] arrayToSort = {6, 5, 4, 7, 9, 8, 1, 3, 2, 10};

        mergeSort(arrayToSort);

    }

    /*
    Rekurzívan meghívható split => A felosztandó array elsõ fele az elsõ felébe a második fele a második felébe megy.
    A második felének indexelése azzal, hogy kivonjuk belõle az elsõ hosszát, 0-val újrakezõdik.
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
    Semmi mást nem csinál, csak összehasonlítja a két féllista legkisebb indexû elemét, és a kisebbet rakja bele result listába.
    Akkor is mûködnie kell, ha egy elemû a lista, meg akkor is, ha több.
    Elég mindig a legkisebb indexet nézni, mert a listák vagy egy darabúak, vagy sorba vannak rendezve, azaz a késõbbi elem nem lehet nagyobb.
    Valószínûleg a két lista nem egyszerre fogy el, hanem az egyikben még maradnak olyan elemek, amelyek biztoan nagyobbak, mint az elemek amik a másikban voltak,
    hiszen akkor ezek kerültek volna be a result listbe. Így ezeket elég csak hozzáadni utólag. (ez a két if/while a végén).
     */

    public static void compare(int[] arrayToSort, int[] firstHalf, int[] secondHalf) {

        int FHIndex = 0;
        int SHIndex = 0;
        int resultIndex = 0;

        // sima compare, amíg az egyik lista el nem fogy mindig berakja a soronkövetkezõ legkisebb elemet a result listbe.
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

        // amelyik listában még maradt elem azokat egymás után (hiszen sortolva vannak) berakja a result listbe
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
    ez csak kialakítja az inputot a split meg a compare számára, majd meghívja õket
     */
    public static void mergeSort(int[]arrayToSort){

        //Ha a merge sortban az array lengthje 1, akkor abból visszatérünk, de egyébként nem!!!
        //Az a merge sort, amiben az array lengthje hoszabb, az tovább megy a compare-re majd a printre!
        if (arrayToSort.length == 1){
            System.out.println("Returning from mergeSort()" + arrayToSort[0]);
            return;
        }

        int midIndex = arrayToSort.length/2 + (arrayToSort.length % 2); //arra az esetre ha véletlenül nem páros listát akarnánk sortolni ==> az elsõben mindig 1-gyel több elem lesz

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
