package heap;

public class Client {

    public static void main(String[] args) {

        MinimumHeap minHeap = new MinimumHeap<>(Integer.class);

        minHeap.insert(1);
        minHeap.insert(3);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(2);

        System.out.println("Max element: " + minHeap.getMaxElement());

        for(int i=0; i<6; i++){
            System.out.println("sizeOfHeap: " + minHeap.getSize());
            System.out.println("index: " + i);
            System.out.println("element removed: " + minHeap.remove());
        }

        minHeap.insert(4);
        System.out.println(minHeap.getSize());

        for(int i=0; i<minHeap.getSize(); i++){
            System.out.println("sizeOfHeap: " + minHeap.getSize());
            System.out.println("index: " + i);
            System.out.println("element removed: " + minHeap.remove());
        }

        System.out.println("size: " + minHeap.getSize());
//        System.out.println("Max element: " + minHeap.getMaxElement());
        int[] arrayToSort = {6, 5, 4, 7, 9, 8, 1, 3, 2, 10};
        printKMaxElements(arrayToSort, 3);
    }

    //Interview question: Print the k largest element from a stream.
    // ==> Use a minimum heap which will hold the 5 largest elements. ==> Compare the new element to the lowest and remove it if the new one is larger then that.
    // ==> The remove and insert will automatically re-heapify the rest.
    public static void printKMaxElements(int[]inputArray, int K){
        MinimumHeap minimumHeap = new MinimumHeap<>(Integer.class,K);

        for (int element : inputArray) {
            if (!minimumHeap.isFull()){
                minimumHeap.insert(element);
            } else {
                if (minimumHeap.getElementAtIndex(0).compareTo(element)<0){
                    minimumHeap.remove();
                    minimumHeap.insert(element);
                }
            }
        }
        System.out.print("The " + K + " largest elements are: ");
        for(int i=0; i<minimumHeap.size; i++) {
            System.out.print(minimumHeap.getElementAtIndex(i) + " ");
        }
    }

}
