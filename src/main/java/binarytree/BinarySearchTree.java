package binarytree;

//A Binary Search Tree is BALANCED if the depth difference between the left and right side is max 1 (nincs eltolódva egyik oldalra sem)
public class BinarySearchTree {

    public Node root;

    public Node insert(int data) {

        return root = this.insert(root, new Node(data));

    }

    //Search, insert ==> O(logN) ==> we halve the tree at every Node
    private Node insert(Node currentNode, Node nodeToInsert) {

        //EXIT condition!! Mert a bináris fa közepére nem lehet illeszteni! Mindenképpen a fa aljára megy az új elem
        if (currentNode == null) {
            return nodeToInsert;
        }

        //Ennyit kell checkelni, semmi mást. Ha a fa aljára értünk, akkor beállítjuk utolsó elemnek az új elemet aztán minden mást is újra beállítunk a láncban ugyanoda és kész.
        if (nodeToInsert.getData() < currentNode.getData()) {
            currentNode.setLeft(insert(currentNode.getLeft(), nodeToInsert));
        } else {
            currentNode.setRight(insert(currentNode.getRight(), nodeToInsert));
        }
        return currentNode;

    }

    public Node findNodeWithData(int data) {

        return findNodeWithData(root, data);
    }

    private Node findNodeWithData(Node current, int data) {

        if (current.getData() == data) {
            return current;
        }

        if (data < current.getData()) {
            return findNodeWithData(current.getLeft(), data);
        } else {
            return findNodeWithData(current.getRight(), data);
        }
    }

    public int findMin() {
        return findMin(root);
    }

    private int findMin(Node current) {

        if (current == null) {
            return -1;
        }

        if (current.getLeft() == null) {
            return current.getData();
        }

        return findMin(current.getLeft());

    }

    public int findMax() {

        return findMax(root);

    }

    private int findMax(Node current) {

        if (current == null) {
            return -1;
        }

        if (current.getRight() == null) {
            return current.getData();
        }

        return findMax(current.getRight());

    }

    public boolean isBst() {
        return isBst(root);
    }

    private boolean isBst(Node input) {
        Node current = input;
        while (current.getLeft() != null) {
            if (current.getLeft().getData() > current.getData()) {
                return false;
            }
            current = current.getLeft();
        }
        current = input;
        while (current.getRight() != null) {
            if (current.getRight().getData() < current.getData()) {
                return false;
            }
            current = current.getRight();
        }
        return true;
    }

    public boolean isBstRecursively(){
        if(root.getLeft() == null || root.getRight() == null){
            return true;
        }
        //Either the min or the max value is irrelevant when we check either the left or the right child against the parent value.
        return isBstRecursively(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Compare the children against the parent ==> left should be smaller, right should be higher ==> Either half of the if condition is always irrelevant!
    private boolean isBstRecursively(Node current, int min, int max){

        //EXIT condition ==> ha idáig eljutunk akkor BST a fa
        if(current == null){
            return true;
        }
        if (current.getData()<min || current.getData() > max){
            return false;
        }

        //this is how we check both branches (&&)
        return isBstRecursively(current.getLeft(), min, current.getData()) && isBstRecursively(current.getRight(), current.getData(), max);

    }

    public void traverseInOrder(Node current) {

        if (current == null) {
            return;
        }

        traverseInOrder(current.getLeft());
        System.out.println(current.getData());
        traverseInOrder(current.getRight());

    }

    private int getMaxDepth(Node current) {

        if (current == null) {
            return 0;
        }

        if (current.getLeft() == null && current.getRight() == null) {
            return 0;
        }

        int leftDepth = 1 + getMaxDepth(current.getLeft());
        int rightDepth = 1 + getMaxDepth(current.getRight());

        return Math.max(leftDepth, rightDepth);

    }

    public int findMaxDepth() {
        return getMaxDepth(root);
    }

    private void mirror(Node current) {

        if (current == null) {
            return;
        }

        Node temp = current.getLeft();
        current.setLeft(current.getRight());
        current.setRight(temp);
        mirror(current.getLeft());
        mirror(current.getRight());

    }

    public void mirror() {
        mirror(root);
    }

    public static class Node<Integer> {

        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
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
