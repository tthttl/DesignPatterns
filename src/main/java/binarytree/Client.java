package binarytree;

public class Client {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(100);
        bst.insert(200);
        bst.insert(80);
        bst.insert(95);
        bst.insert(33);
        bst.insert(30);
        bst.insert(31);
        bst.insert(185);
        bst.insert(220);
        bst.insert(175);
        bst.insert(190);
        bst.insert(210);
        bst.insert(250);
        System.out.println(bst.insert(199));

        System.out.println();
        bst.traverseInOrder(bst.root);

        System.out.println(bst.findNodeWithData(199));
        System.out.println("minValue: " + bst.findMin());
        System.out.println("maxValue: " + bst.findMax());
        System.out.println("maxDepth: " + bst.findMaxDepth());
        System.out.println("before mirror: isBST: " + bst.isBst());
        System.out.println("before mirror: isBST: " + bst.isBstRecursively());
        bst.mirror();
        System.out.println("minValue: " + bst.findMin());
        System.out.println("maxValue: " + bst.findMax());
        System.out.println("after mirror: isBST: " + bst.isBst());
        System.out.println("after mirror: isBST: " + bst.isBstRecursively());
    }

}
