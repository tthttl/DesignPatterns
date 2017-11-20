package sorting;

public class BinarySearch {

    //O(logN)

    public static void main(String[] args) {

        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //SORTED !!!

        System.out.println(findIndexOfElement(sortedArray, 0, sortedArray.length - 1, 10));


    }

    public static int findIndexOfElement(int[] array, int leftEnd, int rightEnd, int elementToFind){

        if (leftEnd > rightEnd){
            return -1;
        }

        int pivotIndex = leftEnd + (rightEnd - leftEnd)/2;

        //akkor van meg, ha pont középen van, addig felezgetjük, mindkét oldalt, amíg el nem találjuk
        if (array[pivotIndex] == elementToFind){
            return pivotIndex;
        }

        if (array[pivotIndex]>elementToFind){
            return findIndexOfElement(array, leftEnd, pivotIndex-1, elementToFind);
        } else {
            return findIndexOfElement(array, pivotIndex+1, rightEnd, elementToFind);
        }
    }


}
