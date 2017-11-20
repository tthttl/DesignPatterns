package heap;

//not a binary search tree ==> a baloldal kisebb, mint  a jobb oldal m�r nem �rv�nyes
/*
2 tulajdons�ga van:
a) heap constraint ==> the element closer to the root should hold smaller values than elements below it. ==> The root element is the smallest in the heap.
Ez a maximumHeapn�l pont ford�tva van!
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

        //ez ugye nem binary search tree! ==> nem a bal a kisebb, meg kell n�zni melyik a kisebb. ha csak egy van, azzal kell majd cser�lni, ha kell
        //compareTo ==> kivonja az els�b�l a m�sodikat ==> ha az eredm�ny kisebb, mint 0, akkor az els� a kisebb.
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

        //ha a gyerekek k�z�l a kisebb �rt�k� kisebb, mint a current element, akkor swappolni kell, plusz �jra vizsg�lni

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
    //mindig az utols� �res indexre (amit a size tartalmaz) illeszt�nk be, innen megy�nk felfel�, am�g j� helyen nem lesz
    public void insert(T data) {

        if (size >= array.length) {
            throw new RuntimeException("Heap is full!");
        }

        array[size] = data;
        siftUp(size);
        size++;

    }

    //O(logN)  => hab�r hamar megvan az els�, de reheapifyolni kell a t�bbit is!
    //mivel priority queue mindig csak az els� elemet akarjuk remove-olni
    //hogy a lista �jra rendezett legyen ==> tr�kk: sz�nd�kosan az utols� elemet tessz�k a root hely�re, majd tolunk egy siftDownt ==> �gy a lista �jrarendezi mag�t
    public T remove() {
        if (size <= 0) {
            throw new RuntimeException("Heap is empty!");
        }

        T dataToReturn = array[0];

        //nem baj, hogy val�j�ban nem t�r�lj�k ki az elemeket, mivel az insert miatt �gyis mindig a sizen�l helyezz�k be az �jat!!
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
