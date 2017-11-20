package sorting;

import java.util.Arrays;

//O(N2) (quadratical), not stable(elements which are equal might be swapped), in place (no extra space is used), not adaptive (not able to realize its done early and break out)
public class Selection {

    public static void main (String[]args){

        int [] arrayToSort = {6,5,4,7,9,8,1,3,2,10};

        for (int i = 0; i<arrayToSort.length; i++){
            /*
            mindig az els�vel kezdj�k, azt�n �sszehasonl�tjuk az �sszes h�tral�v�vel, ez�rt indul k i+1t�l. ==> i m�r sorted, vagy az lesz.
            ha a k �s�bbi elem kisebb, akkor helyetcser�l i vel.
             */
            for(int k = i+1; k<arrayToSort.length; k++){
                if(arrayToSort[k]<arrayToSort[i]){
                    swap(arrayToSort, i, k);
                }
            }
            print(arrayToSort);
        }
    }

    public static int[] swap (int[]arrayToSort, int indexI, int indexK){

        int temp = arrayToSort[indexI];
        arrayToSort[indexI] = arrayToSort[indexK];
        arrayToSort[indexK] = temp;
        return arrayToSort;

    }

    public static void print(int[] arrayToSort){
        Arrays.stream(arrayToSort).forEach(System.out::print);
        System.out.println();
    }


}
