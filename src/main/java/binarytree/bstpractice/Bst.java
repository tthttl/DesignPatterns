package binarytree.bstpractice;

import java.util.PriorityQueue;
import java.util.Queue;

public class Bst<T extends Integer> {

    public Node<T> root;

    public Node<T> insert(T data) {
        root = insert(root, new Node<>(data));
        return root;
    }

    private Node<T> insert(Node<T> current, Node<T> nodeToInsert) {
        if (current == null) {
            return nodeToInsert;
        }

        if (nodeToInsert.getData().compareTo(current.getData()) < 0) {
            current.setLeft(insert(current.getLeft(), nodeToInsert));
        } else {
            current.setRight(insert(current.getRight(), nodeToInsert));
        }
        //always return the root! ==> Azért kell visszatérni, mert az exit condition-ben nem tudnánk, hogy a leftet, vagy a rightot állítsuk-e be. így viszont még a rekurzió elején megmondhatjuk
        //plusz hozzá is kell rendelni az új láncolatot a root elemhez!!
        return current;
    }

    public Node find(T data) {
        return find(root, data);
    }

    private Node find(Node<T> current, T data) {
        if (current == null) {
            return null;
        }

        if (current.getData().equals(data)) {
            return current;
        }
        if (data.compareTo(current.getData()) > 0) {
            return find(current.getRight(), data);
        } else {
            return find(current.getLeft(), data);
        }

    }

    public int findMinData() {
        return findMinData(root);
    }

    private int findMinData(Node current) {
        if (current == null) {
            return -1;
        }
        if (current.getLeft() == null) {
            return current.getData();
        }

        return findMinData(current.getLeft());

    }

    public void breadthFirstTraversal(Node<T> root) {

        Queue<Node<T>> queue = new PriorityQueue<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> current = queue.remove();
            System.out.println(current.getData());

            if (current.getLeft() == null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() == null) {
                queue.add(current.getRight());
            }
        }
    }

    public void depthFirstTraversal(Node<T> current) {

        if (current == null) {
            return;
        }

        System.out.println(current.getData());
        depthFirstTraversal(current.getLeft());
        depthFirstTraversal(current.getRight());

    }

    public boolean isBst(Node<T> root) {

        if (root == null) {
            return true;
        }
        Node<T> current = root;
        while (current.getLeft() != null) {
            if (current.getLeft().getData().compareTo(current.getData()) > 0) {
                return false;
            }
            current = current.getLeft();
        }
        current = root;
        while (current.getRight() != null) {
            if (current.getRight().getData().compareTo(current.getData()) < 0) {
                return false;
            }
            current = current.getRight();
        }
        return true;
    }

    public boolean isBstRecursively() {
        return isBstRecursively(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean isBstRecursively(Node<T> current, Integer max, Integer min) {

        if (current == null) {
            return true;
        }

        if (current.getData().compareTo(max) > 0) {
            return false;
        }
        if (current.getData().compareTo(min) < 0) {
            return false;
        }

        return isBstRecursively(current.getLeft(), current.getData(), min) && isBstRecursively(current.getRight(), max, current.getData());

    }

    public int getMaxDepth(Node<T> root) {
        // one of the child nodes is null ==> end of a level
        if (root == null) {
            return 0;
        }

        //that's also the end of a level ==> here there are no child nodes
        if (root.getLeft() == null && root.getRight() == null) {
            return 0;
        }

        int leftDepth = 1 + getMaxDepth(root.getLeft());
        int rightDepth = 1 + getMaxDepth(root.getRight());

        return Math.max(leftDepth, rightDepth);

    }

    public void mirror(Node<T> root) {

        if (root == null) {
            return;
        }

        Node<T> temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);

        mirror(root.getLeft());
        mirror(root.getRight());

    }


    private static class Node<T extends Integer> {

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

        @Override
        public String toString() {
            String left = this.left == null ? null : "" + this.left.getData();
            String right = this.right == null ? null : "" + this.right.getData();

            return "Node data = " + this.getData() + " left = " + left + " right = " + right;
        }

    }

}
