package sorting.CorrectQuickSort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arrayToSort = new int[]{24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
        quickSort(arrayToSort, 0, arrayToSort.length - 1);
    }

    /*
    Divide & conquer ==> folyamatosan kettéosztja a listát úgy, hogy választ egy pivot elemet (ennek stratégiája akár random is lehet, itt az elsõt választjuk)
    Aztán minden többi elemet hozzámér a pivothoz, ha ÉRTÉKÜK kisebb akkor balra, ha nagyobb akkor jobbra mennek.
    ==> Ezt úgy éri el, hogy egy while nézi az indexeket hátulról elõre csökkenõ sorrendben, egy másik pedig elõlrõl hátra növekvõ sorrendben.
    ==> Ha egy kis indexû elem ÉRTÉKE nagyobb mint a pivot akkor azt megcseréli egy olyan elemmel, melynek indexe nagyobb, viszont ÉRTÉKE kisebb, mint a pivot.
    Ezt addig csinálja amíg az array két végérõl induló index nem találkozik.
    Ekkor egyedül a pivot van jó helyen (SORTED), viszont a tõle kisebb számok bal, a tõle nagyobb számok a jobb oldalon vannak.
    A recursion itt annyi, hogy ugyanezt kell csinálni az így létrejött sublistákra is, amíg az ellentétes irányból induló indexek nem találkoznak a QuickSort függyvényben is!!
     */
    private static void quickSort(int[] arrayToSort, int lowEnd, int highEnd) {
        if (lowEnd >= highEnd) {
            return;
        }

        int indexOfPivot = partition(arrayToSort, lowEnd, highEnd);

        // A -1 + 1 a pivot kihagyására utal, hiszen ez már jó helyen van.
        quickSort(arrayToSort, lowEnd, indexOfPivot - 1);
        quickSort(arrayToSort, indexOfPivot + 1, highEnd);

    }

    // A pviot indexét adja vissza, hogy ennek kihagyásával fel lehessen osztani az arrayt két sublistre.
    private static int partition(int[] arrayToSort, int lowEnd, int highEnd) {
        int pivotElement = arrayToSort[lowEnd];
        int lowIndex = lowEnd;
        int highIndex = highEnd;

        while (lowIndex < highIndex) {
            /*When the subArray is so small that it consists of only the pivotElement this would enter into the while because of the <= sign
            The increase would result in ArrayIndexOutOfBounds without the && condition. If we choose the highEnd, the >= and the && condition should go to the other while.
            */
            while (arrayToSort[lowIndex] <= pivotElement && lowIndex<highIndex) {
                lowIndex++;
            }
            while (arrayToSort[highIndex] > pivotElement) {
                highIndex--;
            }
            if (lowIndex < highIndex) {
                swap(arrayToSort, lowIndex, highIndex);
            }
        }
        /*Mivel az elsõ whileban a <= miatt az elsõ iterációval a pivotElementet a helyén hagytuk (nem swappoltuk) így a array[lowEnd] továbbra is a pivot element.
        A highIndex pedig addig csökken, míg az indexen lévõ elem, már kisebb, mint a pivot ==> így ha ezt az elemet megcseréljük a pivot-tal így biztos, hogy a pivot
        jó helyre fog kerülni(hiszen tõle jobbra, csak nagyobbak vannak), a megcserélt elemnek meg mindegy, lényeg az, hogy marad bal oldalon.
        */
        swap(arrayToSort,lowEnd,highIndex);
        print(arrayToSort);
        return highIndex;
    }


    private static void swap(int[] arrayToSort, int i, int j) {
        int temp = arrayToSort[i];
        arrayToSort[i] = arrayToSort[j];
        arrayToSort[j] = temp;
    }

    private static void print(int[] arrayToSort) {
        Arrays.stream(arrayToSort).forEach(element -> System.out.print(element + " "));
        System.out.println();
    }


}
