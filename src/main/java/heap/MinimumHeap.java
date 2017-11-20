package heap;

//not a binary search tree ==> a baloldal kisebb, mint  a jobb oldal már nem érvényes
/*
2 tulajdonsága van:
a) heap constraint ==> the element closer to the root should hold smaller values than elements below it. ==> The root element is the smallest in the heap.
Ez a maximumHeapnél pont fordítva van!
b) shape constraint ==> leaf nodes are only allowed at the last or the last -1 level of the heap ==>
These levels must be full before adding a new LEVEl to the heap.
 */
public class MinimumHeap<T extends Comparable> extends HeapBase<T> {

    public MinimumHeap(Class<T> clazz) {
        super(clazz);
    }

    public MinimumHeap(Class<T> clazz, int maxSize) {
        super(clazz, maxSize);
    }

    //Moving an element downwards towards its place
    /*
    1: Check which child is smaller ==> This has to be switched with parent, to maintain minimum heap constraint.
    2: Check if smaller child is smaller than current element ==> if yes swap then check again.
     */
    @Override
    public void siftDown(int index) {
        int leftIndex = getIndexOfLeftChild(index);
        int rightIndex = getIndexOfRightChild(index);
        int indexOfElementWithSmallerValue = -1;

        //ez ugye nem binary search tree! ==> nem a bal a kisebb, meg kell nézni melyik a kisebb. ha csak egy van, azzal kell majd cserélni, ha kell
        //compareTo ==> kivonja az elsõbõl a másodikat ==> ha az eredmény kisebb, mint 0, akkor az elsõ a kisebb.
        if (leftIndex != -1 && rightIndex != -1) {
            if (getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex)) < 0) {
                indexOfElementWithSmallerValue = leftIndex;
            } else {
                indexOfElementWithSmallerValue = rightIndex;
            }
        } else {
            if (leftIndex == -1 && rightIndex == -1) {
                return;
            }
            if (leftIndex == -1) {
                indexOfElementWithSmallerValue = rightIndex;
            }
            if (rightIndex == -1) {
                indexOfElementWithSmallerValue = leftIndex;
            }
        }

        //ha a gyerekek közül a kisebb értékû kisebb, mint a current element, akkor swappolni kell, plusz újra vizsgálni

        if (getElementAtIndex(indexOfElementWithSmallerValue).compareTo(getElementAtIndex(index)) < 0) {
            swap(indexOfElementWithSmallerValue, index);
            siftDown(indexOfElementWithSmallerValue);
        }
    }

    public void siftUp(int index) {

        int parentIndex = getIndexOfParent(index);

        if (parentIndex != -1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) < 0) {
            swap(index, parentIndex);
            siftUp(parentIndex);
        }
    }

    //O(logN)
    //mindig az utolsó üres indexre (amit a size tartalmaz) illesztünk be, innen megyünk felfelé, amíg jó helyen nem lesz
    public void insert(T data) {

        if (size >= array.length) {
            throw new RuntimeException("Heap is full!");
        }

        array[size] = data;
        siftUp(size);
        size++;

    }

    //O(logN)  => habár hamar megvan az elsõ, de reheapifyolni kell a többit is!
    //mivel priority queue mindig csak az elsõ elemet akarjuk remove-olni
    //hogy a lista újra rendezett legyen ==> trükk: szándékosan az utolsó elemet tesszük a root helyére, majd tolunk egy siftDownt ==> így a lista újrarendezi magát
    public T remove() {
        if (size <= 0) {
            throw new RuntimeException("Heap is empty!");
        }

        T dataToReturn = array[0];

        //nem baj, hogy valójában nem töröljük ki az elemeket, mivel az insert miatt úgyis mindig a sizenál helyezzük be az újat!!
        array[0] = array[size - 1];

        size--;

        siftDown(0);

        return dataToReturn;

    }

    //Interview question ==> Get the max element in a minimum heap!
    /*
    Idea is, that the largest elements in a min heap are the leaf nodes. ==> It is enough to only scan those to find the maximum value.
    Leaf nodes are the last elements in the representing array. ==> Leaf nodes start after the last parent element.
     */
    public T getMaxElement() {
        if (isEmpty()) {
            throw new RuntimeException("Array is Empty.");
        }
        int parentIndex = getIndexOfParent(size - 1);

        int firsLeafNodeIndex = parentIndex + 1;

        T maxElement = getElementAtIndex(firsLeafNodeIndex);

        for (int i = firsLeafNodeIndex; i < size; i++) {

            if (getElementAtIndex(i).compareTo(maxElement) > 0) {
                maxElement = array[i];
            }
        }
        return maxElement;
    }




}
