package binarytree.bstpractice;

public class Client {

    public static void main(String[] args) {
        Bst<Integer> bst = new Bst<>();

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
        bst.insert(199);

        bst.depthFirstTraversal(bst.root);

        System.out.println(bst.find(199));
        System.out.println("minValue: " + bst.findMinData());
        System.out.println("maxDepth: " + bst.getMaxDepth(bst.root));
        System.out.println("before mirror: isBST: " + bst.isBst(bst.root));
        System.out.println("before mirror: isBST: " + bst.isBstRecursively());
        bst.mirror(bst.root);
        System.out.println("after mirror: isBST: " + bst.isBst(bst.root));
        System.out.println("after mirror: isBST: " + bst.isBstRecursively());

    }





}
