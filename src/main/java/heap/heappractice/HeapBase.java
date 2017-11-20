package heap.heappractice;

import java.lang.reflect.Array;

public abstract class HeapBase<T extends Integer> {

    private static final int MAX_HEAP_SIZE = 20;
    protected T[] heap;
    protected int size;

    public HeapBase(Class<T> clazz) {
        this(clazz, MAX_HEAP_SIZE);
    }

    private HeapBase(Class<T> clazz, int heapSize) {
        this.heap = (T[]) Array.newInstance(clazz, heapSize);
        this.size = 0;
    }

    public int getIndexOfLeftChild(int indexOfParent) {
        int indexOfLeftChild = indexOfParent * 2 + 1;
        if (indexOfLeftChild > size) {
            return -1;
        }
        return indexOfLeftChild;
    }

    public int getIndexOfRightChild(int indexOfParent) {
        int indexOfRightChild = indexOfParent * 2 + 2;
        if (indexOfRightChild > size) {
            return -1;
        }
        return indexOfRightChild;
    }

    public int getIndexOfParent(int indexOfChild) {
        int indexOfParent = (indexOfChild - 1) / 2;
        if (indexOfParent < 0 || indexOfChild > size) {
            return -1;
        }
        return indexOfParent;
    }

    public T getElementAtIndex(int index) {
        return heap[index];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull(){
        return size == heap.length;
    }

    public void swap (int index1, int index2){
        T temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public abstract void siftDown(int index);

    public abstract void siftUp(int index);

}
