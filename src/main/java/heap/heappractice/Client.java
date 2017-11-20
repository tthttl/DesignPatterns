package heap.heappractice;

/*a heap egy minimum vagy maximum tree (priority queue) arrayban ábrázolva
insert => mindig a végére, aztán mozgatni felfelé => swappolgatni a parenttel, amíg lehet
remove => újra kell rendezni a heapet, amire az a trükk, hogy az utolsó elemet szándékosan a root helyére rakjuk,
aztán lefelé mozgatjuk (siftDown: a két gyerek közül a kisebbikkel/nagyobbikkal swappoljuk) amíg a helyére nem kerül, eközben a heap
automatikusan újrarendezõdik
 */
public class Client {

    public static void main(String[] args) {

        MaximumHeap maximumHeap = new MaximumHeap<>(Integer.class);

        maximumHeap.insert(1);
        maximumHeap.insert(3);
        maximumHeap.insert(6);
        maximumHeap.insert(5);
        maximumHeap.insert(4);
        maximumHeap.insert(2);

        System.out.println("Min element: " + maximumHeap.getMinElement());

        for(int i=0; i<6; i++){
            System.out.println("sizeOfHeap: " + maximumHeap.getSize());
            System.out.println("index: " + i);
            System.out.println("element removed: " + maximumHeap.remove());
        }

        maximumHeap.insert(4);
        System.out.println(maximumHeap.getSize());

        for(int i=0; i<maximumHeap.getSize(); i++){
            System.out.println("sizeOfHeap: " + maximumHeap.getSize());
            System.out.println("index: " + i);
            System.out.println("element removed: " + maximumHeap.remove());
        }

//        System.out.println("size: " + maximumHeap.getSize());
////        System.out.println("Max element: " + minHeap.getMaxElement());
//        int[] arrayToSort = {6, 5, 4, 7, 9, 8, 1, 3, 2, 10};
//        printKMaxElements(arrayToSort, 3);
    }

}
