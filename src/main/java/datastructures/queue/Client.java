package datastructures.queue;

import datastructures.circularqueue.CircularQueue;

public class Client {

    public static void main (String[]args){

        Queue<Integer> queue = new Queue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        try {
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
        } catch (CircularQueue.QueueUnderFlowException e) {
            e.printStackTrace();
        }

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        try {
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
        } catch (CircularQueue.QueueUnderFlowException e) {
            e.printStackTrace();
        }


    }

}
