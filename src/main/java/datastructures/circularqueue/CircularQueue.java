package datastructures.circularqueue;

import static java.lang.reflect.Array.newInstance;

public class CircularQueue<T> {

    /*
    A normal queue would implement the linkedList, with a reference to the tail Node as well.
    A k�rk�r�s queuenak fix m�rete van. A fix m�ret ut�n megint a 0 index ker�l kioszt�sra, persze csak akkor, ha szabad.
    Az�rt tud felszabadulni az els� index, mert a queueba mindig legh�tulra rakunk be �s mindig legel�lr�l vesz�nk ki.
    Minden m�velet O(1).
     */

    private static final int QUEUE_IS_EMPTY = -1;
    private static final int MAX_SIZE = 10;

    private int headIndex = QUEUE_IS_EMPTY;
    private int tailIndex = QUEUE_IS_EMPTY;

    private T[] circle;

    /*az�rt kell a clazz, mert nem akarjuk a queue belsej�ben l�v� classt is magunk l�trehozni (azt�n �tadni a konstruktornak)
    ,csak megmondani, hogy milyen elemeket akarunk benne t�rolni.
    */
    public CircularQueue(Class<T> clazz) {
        this(clazz, MAX_SIZE);
    }

    public CircularQueue(Class<T> clazz, int size) {
        this.circle = (T[]) newInstance(clazz, size);
    }

    /* Ez a marad�kos oszt�s ami visszaford�tja az array indexel�s�t. Ha m�r az utols� index ut�n megint a 0 j�nne az �gy der�l ki, hogy megn�zz�k, mi lenne a k�vetkez� index.
    Ha ez elosztva a max m�rettel 0-�t ad marad�kul, az azt jelenti, hogy el�rt�nk a v�g�re �s �jra 0-t�l kell kezdeni az indexel�st, persze csak akkor, ha a headindex nem a 0-n �ll,
    mert akkor tele az array. De egy�bk�nt nem csak a 0-ra m�k�dik, hanem b�rmelyik m�sik indexre is. Pl: head 5 tail 6. ==> 6+1=7%10 = 7 ==> 7 !=5 teh�t nem full, az �j tail a 7 lesz
    DE head 5 tail 4 ==> tail+1 = 5 = head ==> teh�t full!!
    */
    public boolean isFull() {
        int nextIndex = (tailIndex + 1) % MAX_SIZE;
        return nextIndex == headIndex;
    }

    public boolean isEmpty() {
        return headIndex == QUEUE_IS_EMPTY;
    }

    public void enqueue(T data) throws QueueOverFlowException {
        if (isFull()) {
            throw new QueueOverFlowException();
        }
        // ez az�rt kell, hogy k�rbeforduljon az index, ha el�rte a max size-ot �s �jra el�lr�l kezd�dj�n, ha id�k�zben t�r�lt�k az els� elemet.
        tailIndex = (tailIndex + 1) % MAX_SIZE;
        circle[tailIndex] = data;
        //ha ez az els� elem
        if (headIndex == QUEUE_IS_EMPTY) {
            headIndex = tailIndex;
        }
    }

    public void enqueuePractice(T data) {
        if (isFull()) {
            throw new RuntimeException("Queue is full.");
        }
        tailIndex = tailIndex + 1 % MAX_SIZE;
        circle[tailIndex] = data;
        if (headIndex == QUEUE_IS_EMPTY) {
            headIndex = tailIndex;
        }

    }

    public T dequeue() throws QueueUnderFlowException {
        if (isEmpty()) {
            throw new QueueUnderFlowException();
        }
        T dequeuedItem = circle[headIndex];
        // ha ez volt az utols� elem
        if (headIndex == tailIndex) {
            headIndex = QUEUE_IS_EMPTY;
        } else {
            headIndex = (headIndex + 1) % MAX_SIZE;
        }
        return dequeuedItem;
    }

    public T dequeuePractice() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }
        T dataToReturn = circle[headIndex];
        if (headIndex == tailIndex) {
            headIndex = QUEUE_IS_EMPTY;
        } else {
            headIndex = headIndex - 1 % MAX_SIZE;
        }
        return dataToReturn;

    }

    public static class QueueOverFlowException extends Exception {

    }

    public static class QueueUnderFlowException extends Exception {

    }

}
