package sorting.CorrectQuickSort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arrayToSort = new int[]{24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
        quickSort(arrayToSort, 0, arrayToSort.length - 1);
    }

    /*
    Divide & conquer ==> folyamatosan kett�osztja a list�t �gy, hogy v�laszt egy pivot elemet (ennek strat�gi�ja ak�r random is lehet, itt az els�t v�lasztjuk)
    Azt�n minden t�bbi elemet hozz�m�r a pivothoz, ha �RT�K�K kisebb akkor balra, ha nagyobb akkor jobbra mennek.
    ==> Ezt �gy �ri el, hogy egy while n�zi az indexeket h�tulr�l el�re cs�kken� sorrendben, egy m�sik pedig el�lr�l h�tra n�vekv� sorrendben.
    ==> Ha egy kis index� elem �RT�KE nagyobb mint a pivot akkor azt megcser�li egy olyan elemmel, melynek indexe nagyobb, viszont �RT�KE kisebb, mint a pivot.
    Ezt addig csin�lja am�g az array k�t v�g�r�l indul� index nem tal�lkozik.
    Ekkor egyed�l a pivot van j� helyen (SORTED), viszont a t�le kisebb sz�mok bal, a t�le nagyobb sz�mok a jobb oldalon vannak.
    A recursion itt annyi, hogy ugyanezt kell csin�lni az �gy l�trej�tt sublist�kra is, am�g az ellent�tes ir�nyb�l indul� indexek nem tal�lkoznak a QuickSort f�ggyv�nyben is!!
     */
    private static void quickSort(int[] arrayToSort, int lowEnd, int highEnd) {
        if (lowEnd >= highEnd) {
            return;
        }

        int indexOfPivot = partition(arrayToSort, lowEnd, highEnd);

        // A -1 + 1 a pivot kihagy�s�ra utal, hiszen ez m�r j� helyen van.
        quickSort(arrayToSort, lowEnd, indexOfPivot - 1);
        quickSort(arrayToSort, indexOfPivot + 1, highEnd);

    }

    // A pviot index�t adja vissza, hogy ennek kihagy�s�val fel lehessen osztani az arrayt k�t sublistre.
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
        /*Mivel az els� whileban a <= miatt az els� iter�ci�val a pivotElementet a hely�n hagytuk (nem swappoltuk) �gy a array[lowEnd] tov�bbra is a pivot element.
        A highIndex pedig addig cs�kken, m�g az indexen l�v� elem, m�r kisebb, mint a pivot ==> �gy ha ezt az elemet megcser�lj�k a pivot-tal �gy biztos, hogy a pivot
        j� helyre fog ker�lni(hiszen t�le jobbra, csak nagyobbak vannak), a megcser�lt elemnek meg mindegy, l�nyeg az, hogy marad bal oldalon.
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
