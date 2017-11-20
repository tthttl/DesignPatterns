package sorting;

import java.util.Arrays;

//O(NlogN)
//In place (no additional memory needed), not adaptive, not stable
// semmi más csak 1. heapify ==> siftdown hátulról elõre elemenként ==> ez heappé alakítja az arrayt
// aztán uaz mint a remove-nál, csak nem visszaadjuk a removolt elemet, hanem swappoljuk a végével elemenként ==> a vége lesz fully sorted
public class HeapSort {

    public static void main(String[] args) {

        int[] arrayToSort = {6, 5, 4, 7, 9, 8, 1, 3, 2, 10};
        HeapSort hs = new HeapSort();
        hs.heapSort(arrayToSort);
        print(arrayToSort);


    }

    //i*2 + 1 ==> leftChild in a heap
    public int getIndexOfLeftChild(int currentIndex, int end) {
        int leftChildIndex = currentIndex * 2 + 1;
        if (leftChildIndex > end) {
            return -1;
        }

        return leftChildIndex;

    }

    //i*2 + 2 ==> rightChild in a heap
    public int getIndexOfRightChild(int currentIndex, int end) {
        int rightChildIndex = currentIndex * 2 + 2;
        if (rightChildIndex > end) {
            return -1;
        }

        return rightChildIndex;

    }

    //az elõzõk fordítottja, lefelé kerekítéssel, mindkét esetre (left/right) jó
    public int getIndexOfParent(int currentIndex, int end) {

        if (currentIndex <= 0 || currentIndex > end) {
            return -1;
        }

        return (currentIndex - 1) / 2;

    }

    public void swap(int index1, int index2, int[] arrayToSort) {
        int temp = arrayToSort[index1];
        arrayToSort[index1] = arrayToSort[index2];
        arrayToSort[index2] = temp;
    }

    public void siftDown(int index, int end, int[] arrayToSort) {
        int leftIndex = getIndexOfLeftChild(index, end);
        int rightIndex = getIndexOfRightChild(index, end);
        int indexOfElementWithLargerValue = -1;

        if (leftIndex != -1 && rightIndex != -1) {
            if (arrayToSort[leftIndex] < arrayToSort[rightIndex]) {
                indexOfElementWithLargerValue = rightIndex;
            } else {
                indexOfElementWithLargerValue = leftIndex;
            }
        } else {
            if (leftIndex == -1 && rightIndex == -1) {
                return;
            }
            if (leftIndex == -1) {
                indexOfElementWithLargerValue = rightIndex;
            }
            if (rightIndex == -1) {
                indexOfElementWithLargerValue = leftIndex;
            }
        }

        if (arrayToSort[indexOfElementWithLargerValue] > arrayToSort[index]) {
            swap(indexOfElementWithLargerValue, index, arrayToSort);
            siftDown(indexOfElementWithLargerValue, end, arrayToSort);
        }
    }

    /* PART 1
    We need to create a heap from the array, which we want to sort ==> we need to run siftDown starting from the last parent in the array.
    Step 1: get the first parent starting from the end.
    Step 2: move up to the first element in the array, running siftDown on every parent.
     */
    public void heapify(int endIndex, int[] arrayToSort) {
        int parent = getIndexOfParent(endIndex, endIndex);

        while (parent >= 0) {

            siftDown(parent, endIndex, arrayToSort);
            parent--;

        }

    }

    /* PART 2
    The sort itself rearranges the heap ==>
    Step 1: Move the first(biggest) element from index 0 to the last index. ==> This is considered fully sorted ==> The remaining heap size is reduced to exclude the already sorted part.
    Step 2: Call siftDown on the reduced array.
    REPEAT
     */
    public void heapSort(int[] arrayToSort) {

        //Part 1.
        heapify(arrayToSort.length - 1, arrayToSort);

        //Part2.
        int end = arrayToSort.length - 1;
        while (end >= 0) {
            swap(0, end, arrayToSort);
            end--;
            siftDown(0,end,arrayToSort);
        }
    }

    public static void print(int[] arrayToSort){
        Arrays.stream(arrayToSort).forEach(System.out::print);
        System.out.println();
    }


}
