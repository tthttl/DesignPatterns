package datastructures.stack;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
    A ccess => O(n)
    S earch => O(n)
    I nsertion => O(1) (To the top)
    D elete => O(1) (From the top)
     */
public class Stack<T> {
    private static final int MAX_SIZE = 50;
    private Element<T> top;
    private int size = 0;

    public Stack() {
        this.top = null;
    }

    public void push(T newData) throws StackOverFlowException {
        if (this.size == MAX_SIZE) {
            throw new StackOverFlowException();
        }
        Element<T> newElement = new Element<>(newData, top);
        top = newElement;
        size++;
    }

    public T pop() throws StackUnderFlowException {
        if (this.size == 0) {
            throw new StackUnderFlowException();
        }
        T dataToPop = top.getData();
        top = top.getNext();
        size--;
        return dataToPop;
    }

    public T peek() throws StackUnderFlowException {
        if (this.size == 0) {
            throw new StackUnderFlowException();
        }
        return top.getData();
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == MAX_SIZE;
    }




    /*
    Non-static nested classes (inner classes) have access to other members of the enclosing class, even if they are declared private.
    As a member of the OuterClass, a nested class can be declared private, public, protected, or package private. (Recall that outer classes can only be declared public or package private.)
    ADVANTAGES OF INNER CLASSES:
    - It increases encapsulation: Consider two top-level classes, A and B, where B needs access to members of A that would otherwise be declared private.
    By hiding class B within class A, A's members can be declared private and B can access them. In addition, B itself can be hidden from the outside world.

    Instantiation:
    OuterClass outerObject = new OuterClass();
    OuterClass.InnerClass innerObject = outerObject.new InnerClass();

    STATIC NESTED CLASSES:
    !! Static nested classes do not have access to other members of the enclosing class. Mert nem tudják, melyik példányhoz férjenek hozzá !! ==>
    A static nested class interacts with the instance members of its outer class (and other classes) just like any other top-level class.
    In effect, a static nested class is behaviorally a top-level class that has been nested in another top-level class for packaging convenience.
    - It is a way of logically grouping classes that are only used in one place: If a class is useful to only one other class,
    then it is logical to embed it in that class and keep the two together. Nesting such "helper classes" makes their package more streamlined. ==> Ennyi, ha a helper classnak
    nem kell hozzá férnie a külsõ osztály fieldjeihez, akkor lehet static, egyébként legyen sima.

    Instantiation: (nem kell elöször a külsõt példányosítani)
    OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
     */
    private static class Element<T> {

        private T data;
        private Element<T> next;

        /*
        A sima linkedList esetében a next refernce mindig null a konstruktorban, mert ott mindig a list végére szúrúnk be, így az
        utolsó elem, ami újonnan jön létre a nullra mutat.
         */
        public Element(T data, Element<T> next) {
            this.data = data;
            this.next = next;
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

    public static class StackOverFlowException extends Exception {

    }

    public static class StackUnderFlowException extends Exception {

    }

}
