package heap;

import java.lang.reflect.Array;

public abstract class HeapBase<T extends Comparable> {

    private static int MAX_SIZE = 40;
    protected T[] array;
    protected int size = 0;

    public HeapBase(Class<T> clazz) {
        this(clazz, MAX_SIZE);
    }

    //Ez a móka a clazz-zal, meg a max size-zal csak azért releváns, hogy létre lehessen hozni egy generikus heapet, ami nem más mint egy array ==> létrehozáshoz kell a típusa, meg a mérete
    public HeapBase(Class<T> clazz, int maxSize) {
        array = (T[]) Array.newInstance(clazz, maxSize);
    }

    //i*2 + 1 ==> leftChild in a heap
    public int getIndexOfLeftChild(int currentIndex) {
        int leftChildIndex = currentIndex * 2 + 1;
        if (leftChildIndex > size) {
            return -1;
        }

        return leftChildIndex;

    }

    //i*2 + 2 ==> rightChild in a heap
    public int getIndexOfRightChild(int currentIndex) {
        int rightChildIndex = currentIndex * 2 + 2;
        if (rightChildIndex > size) {
            return -1;
        }

        return rightChildIndex;

    }

    //az elõzõk fordítottja, lefelé kerekítéssel, mindkét esetre (left/right) jó
    public int getIndexOfParent(int currentIndex) {

        if (currentIndex <= 0 || currentIndex > size) {
            return -1;
        }

        return (currentIndex - 1) / 2;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public int getSize() {
        return size;
    }

    public void swap(int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    //O(1)
    public T getElementAtIndex(int index) {
        return array[index];
    }

    public abstract void siftDown(int index);


}
