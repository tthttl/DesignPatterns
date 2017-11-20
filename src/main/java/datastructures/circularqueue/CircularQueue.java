package datastructures.circularqueue;

import static java.lang.reflect.Array.newInstance;

public class CircularQueue<T> {

    /*
    A normal queue would implement the linkedList, with a reference to the tail Node as well.
    A körkörös queuenak fix mérete van. A fix méret után megint a 0 index kerül kiosztásra, persze csak akkor, ha szabad.
    Azért tud felszabadulni az elsõ index, mert a queueba mindig leghátulra rakunk be és mindig legelõlrõl veszünk ki.
    Minden mûvelet O(1).
     */

    private static final int QUEUE_IS_EMPTY = -1;
    private static final int MAX_SIZE = 10;

    private int headIndex = QUEUE_IS_EMPTY;
    private int tailIndex = QUEUE_IS_EMPTY;

    private T[] circle;

    /*azért kell a clazz, mert nem akarjuk a queue belsejében lévõ classt is magunk létrehozni (aztán átadni a konstruktornak)
    ,csak megmondani, hogy milyen elemeket akarunk benne tárolni.
    */
    public CircularQueue(Class<T> clazz) {
        this(clazz, MAX_SIZE);
    }

    public CircularQueue(Class<T> clazz, int size) {
        this.circle = (T[]) newInstance(clazz, size);
    }

    /* Ez a maradékos osztás ami visszafordítja az array indexelését. Ha már az utolsó index után megint a 0 jönne az úgy derül ki, hogy megnézzük, mi lenne a következõ index.
    Ha ez elosztva a max mérettel 0-át ad maradékul, az azt jelenti, hogy elértünk a végére és újra 0-tól kell kezdeni az indexelést, persze csak akkor, ha a headindex nem a 0-n áll,
    mert akkor tele az array. De egyébként nem csak a 0-ra mûködik, hanem bármelyik másik indexre is. Pl: head 5 tail 6. ==> 6+1=7%10 = 7 ==> 7 !=5 tehát nem full, az új tail a 7 lesz
    DE head 5 tail 4 ==> tail+1 = 5 = head ==> tehát full!!
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
        // ez azért kell, hogy körbeforduljon az index, ha elérte a max size-ot és újra elõlröl kezdõdjön, ha idõközben törölték az elsõ elemet.
        tailIndex = (tailIndex + 1) % MAX_SIZE;
        circle[tailIndex] = data;
        //ha ez az elsõ elem
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
        // ha ez volt az utolsó elem
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
