package classes.week10;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This main function runs the class 10 example.
 *
 */
public class BT_Main {
    public static void main(String[] args) {
        int[]  a = {5, 7, 9, 15, 4, 19, 2, 3};
        BinaryTree<Integer> t = new BinaryTree1<>(a[3]);
        addLeft(t, a[2]);
        BinaryTree l = t.getLeft();
        addLeft(l, a[1]);
        l = l.getLeft();
        addLeft(l, a[0]);
        addRight(t, a[6]);
        BinaryTree r = t.getRight();
        addLeft(r, a[4]);
        r = r.getLeft();
        addRight(r, a[5]);
        r = t.getRight();
        addRight(r, a[7]);


        printInOrder(t);
        System.out.println();
        printInOrder(t, "");
        BinaryTreeAlgo.draw(t);
      //  Iterator<Integer> itr = t.iterator();
        Iterator<Integer> itr = t.iteratorByLevel();
        while (itr.hasNext()) {
            int i = itr.next();
               System.out.println(i);
        }

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
    private static void addLeft(BinaryTree<Integer> t, Integer p) {
        if (t != null) {t.add(p, 1);}
    }
    private static void addRight(BinaryTree<Integer> t, Integer p) {
        if (t != null) {t.add(p, 0);}
    }
}
