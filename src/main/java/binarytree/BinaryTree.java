package binarytree;

import datastructures.circularqueue.CircularQueue;
import datastructures.queue.Queue;

public class BinaryTree<T extends Integer> {

    //BREADTH FIRST TRAVERSAL WITH QUEUE
    public void breadthFirstTraversal(Node node) throws CircularQueue.QueueUnderFlowException {

        if (node == null) {
            return;
        }
        //Mivel ez FIFO ezért amit elõször berakunk enqueue-val azt is vesszük ki ==> folyamatosan az egymás mellettiek gyerekeit pakoljuk bele
        Queue<Node> queue = new Queue<>();
        queue.enqueue(node);

        while (!queue.isEmpty()) {
            Node current = queue.dequeue();
            System.out.println(current.getData());
            if (current.getLeft() != null) {
                queue.enqueue(current.getLeft());
            }
            if (current.getLeft() != null) {
                queue.enqueue(current.getRight());
            }
        }
    }

    //DEPTH FIRST TRAVERSALS WITH RECURSION ==> Difference between the orders is, when will be the parent node processed (printed) pre (first) in(after left child) post(after both children)
    public void preOrderTraversal (Node root){

        if (root == null) {
            return;
        }


        System.out.println(root.getData());

        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());

    }

    //to root will be processed after the left side of the tree is processed
    public void inOrderTraversal(Node root){

        if(root == null){
            return;
        }

        inOrderTraversal(root.getLeft());
        System.out.println(root.getData());
        inOrderTraversal(root.getRight());

    }

    //the root will be the last to be processed
    public void postOrderTraversal(Node root){

        if (root == null){
            return;
        }

        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        System.out.println(root.getData());

    }


    public static class Node<T> {

        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

    }


}
