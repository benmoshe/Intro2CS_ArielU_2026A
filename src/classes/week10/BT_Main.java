package classes.week10;

/**
 * This main function runs the class 10 example.
 *
 */
public class BT_Main {
    public static void main(String[] args) {
        int[]  a = {5, 7, 9, 15, 4, 19, 2, 3};
        BinaryTree<Integer> t = new BinaryTree1<>(a[3]);
        t.add(a[2], 1);
        BinaryTree l = t.getLeft();
        l.add(a[1],1);
        l = l.getLeft();
        l.add(a[0],1);
        t.add(a[6],0);
        BinaryTree r = t.getRight();
        r.add(a[4],1);
        r = r.getLeft();
        r.add(a[5],0);
        r = t.getRight();
        r.add(a[7],0);

        printInOrder(t);
        System.out.println();
        printInOrder(t, "");
        BinaryTreeAlgo.draw(t);
    }
    public static void printInOrder(BinaryTree<Integer> t) {
        if (t == null) return;
        printInOrder(t.getLeft());
        System.out.print(t.getRoot()+", ");
        printInOrder(t.getRight());
    }
    public static void printInOrder(BinaryTree<Integer> t, String p) {
        if (t == null) return;
        printInOrder(t.getLeft(), p+"L");
        System.out.println(p+": "+t.getRoot());
        printInOrder(t.getRight(), p+"R");
    }
}
