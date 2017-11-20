package datastructures.queue;

import datastructures.circularqueue.CircularQueue;

   /*
    A ccess => O(n)
    S earch => O(n)
    I nsertion => O(1) (To the tail)
    D elete => O(1) (From head or tail)
     */

public class Queue<T> {

    private Element<T> head = null;
    private Element<T> tail = null;

    private int size = 0;

    public void enqueue(T data){
        if (head == null){
            head = new Element<>(data);
            tail = head;
            size++;
            return;
        }
        Element<T> newElement = new Element<>(data);
        tail.setNext(newElement);
        tail = newElement;
        size++;
    }

    public T dequeue () throws CircularQueue.QueueUnderFlowException {
        if(head == null){
            throw new CircularQueue.QueueUnderFlowException();
        }
        T toDequeue = head.getData();
        head = head.getNext();
        size--;
        return toDequeue;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size<1;
    }


    public static class Element<T> {

        private T data;
        private Element<T> next;

        public Element(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Element<T> getNext() {
            return next;
        }

        public void setNext(Element<T> next) {
            this.next = next;
        }
    }

    public static class QueueUnderFlowException extends Exception{

    }

}
