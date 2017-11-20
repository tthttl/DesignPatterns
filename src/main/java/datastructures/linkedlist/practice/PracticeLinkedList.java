package datastructures.linkedlist.practice;

public class PracticeLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int length;

    public void add(T data) {
        if (head == null) {
            head = new Node<>(data);
            tail = head;
            return;
        }
//        Node<T> current = head;
//        while (current.getNext() != null) {
//            current = current.getNext();
//        }
//        current.setNext(new Node<>(data));
//        tail = current.getNext();
        tail.setNext(new Node<>(data));
        tail = tail.getNext();
        length++;
    }

    public T getHead() {
        if (head == null) {
            return null;
        }
        return head.getData();
    }

    public T getTail() {
        if (tail == null) {
            return null;
        }
        return tail.getData();
    }

    public int getLength() {
        return length;
    }

    public Node<T> remove() {
        if (head == null) {
            return null;
        }
        Node<T> result = head;
        head = head.getNext();
        length--;
        return result;
    }

    public boolean remove(T data) {
        if (head == null) {
            return false;
        }
        Node<T> current = head;
        if (current.getData().equals(data)) {
            head = head.getNext();
            return true;
        }
        while (current != null) {
            if (current.getNext().getData().equals(data)) {
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    private static class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

}
