package datastructures.linkedlist;

public class LinkedList <T extends Comparable<T>> implements Cloneable {

    private Node<T> head = null;

    public LinkedList() {
    }

    /*
    A ccess => O(n)
    S earch => O(n)
    I nsertion => O(1) (To the front)
    D elete => O(1) (From head or tail)
     */
    //O(N)
    public Node<T> find (T data){
        Node<T> h = head;
        while (h != null){
            h = h.getNext();
            if (h.getData().equals(data)){
                return h;
            }
        }
        return null;
    }

    //O(N) ==> can be O(1) if we store the length in a variable, which we update every time we add or remove an element
    public int length(){
        if(head == null){
            return 0;
        } else {
            Node<T> current = head;
            int length = 0;
            while (current != null){
                current = current.getNext();
                length++;
            }
            return length;
        }
    }

    //O(N) ==> can be O(1) if we store the last Node as well
    public void add(T data){
        if (head == null){
            head = new Node<>(data);
        } else {
            Node<T> lastNode = head;
            while (lastNode.getNext() != null){
                lastNode = lastNode.getNext();
            }
            lastNode.setNext(new Node<>(data));
        }
    }

    //O(1) ==> nem a NODE-ot adjuk vissza, csak a benne tárolt datát
    public T pop(){
        if(head == null){
            return null;
        }
        T elementToRemove = head.getData();
        head = head.getNext();
        return elementToRemove;
    }


}
