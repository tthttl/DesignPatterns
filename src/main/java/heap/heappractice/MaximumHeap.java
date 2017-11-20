package heap.heappractice;

public class MaximumHeap<T extends Integer> extends HeapBase<T> {

    public MaximumHeap(Class<T> clazz) {
        super(clazz);
    }

    @Override
    public void siftDown(int index) {

        int leftChild = getIndexOfLeftChild(index);
        int rightChild = getIndexOfRightChild(index);
        T currentElement = getElementAtIndex(index);
        int largerChild = -1;

        //check if it has children, and if yes, which is the larger
        if (leftChild != -1 && rightChild != -1) {
            if (getElementAtIndex(leftChild).compareTo(getElementAtIndex(rightChild)) > 0) {
                largerChild = leftChild;
            } else {
                largerChild = rightChild;
            }
        } else {
            if (leftChild == -1 && rightChild == -1) {
                return;
            }
            if (leftChild == -1) {
                largerChild = rightChild;
            }
            if (rightChild == -1) {
                largerChild = leftChild;
            }
        }
        //if the element is smaller than the child it has to be swapped with the LARGER ==> to maintain heap constraint ==> larger elements closer to the root
        if (currentElement.compareTo(getElementAtIndex(largerChild)) < 0) {
            swap(index, largerChild);
            siftDown(largerChild);
        }

    }

    @Override
    public void siftUp(int index) {
        int parentIndex = getIndexOfParent(index);
        T currentElement = getElementAtIndex(index);

        if (parentIndex != -1) {
            if (currentElement.compareTo(getElementAtIndex(parentIndex)) > 0) {
                swap(index, parentIndex);
                siftUp(parentIndex);
            }
        }
    }

    public void insert(T data) {

        if (isFull()) {
            throw new RuntimeException("Heap is full");
        }

        heap[size] = data;
        siftUp(size);
        size++;

    }

    public T remove() {

        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }

        T elementToRemove = heap[0];

        heap[0] = heap[size - 1];

        siftDown(0);

        size--;

        return elementToRemove;

    }

    public T getMinElement() {

        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }

        //TRICK: az utolsó leaf parentje az utolsó parent ==> ettõl a parenttõl jobbra már csak leafek vannak
        int indexOfLastParent = getIndexOfParent(size - 1);
        int firstLeafNodeIndex = indexOfLastParent + 1;

        T minElement = getElementAtIndex(firstLeafNodeIndex);

        for (int i = firstLeafNodeIndex + 1; i < size; i++) {
            if (minElement.compareTo(getElementAtIndex(i)) > 0) {
                minElement = getElementAtIndex(i);
            }
        }

        return minElement;

    }

}
