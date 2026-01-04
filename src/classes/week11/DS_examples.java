package classes.week11;

import classes.week6.Point2D;
import classes.week7.Circle2D;
import classes.week7.GeoShape;
import classes.week7.Rect2D;

import java.util.*;

public class DS_examples {
    public static void main(String[] args) {
        ArrayList<GeoShape> a1 = new ArrayList<GeoShape>();
        Hashtable<String, GeoShape> a2 = new Hashtable<String, GeoShape>();
        HashMap<Integer, GeoShape> a3  = new HashMap<Integer, GeoShape>();

        GeoShape[] gs = createGeoShapeArr();
        for(int i = 0; i < gs.length; i++) {
            a1.add(gs[i]);
            a2.put(gs[i].toString(), gs[i]);
            a3.put(gs[i].hashCode(), gs[i]);
        }

        Iterator<GeoShape> it = a1.iterator();
        System.out.println("*** The 4 GeoShapes in 3 different data structures: ***");
        while(it.hasNext()) {
            GeoShape g = it.next();
            System.out.println("ArrayList: "+g);
            GeoShape g2 = a2.get(g.toString());
            System.out.println("HashTable: "+g2);
            GeoShape g3 = a3.get(g.hashCode());
            System.out.println("HashMap: "+g3);
        }
        Set<String> keys = a2.keySet();
        Iterator<String> itr2  = keys.iterator();
        Set<Integer> keys3 = a3.keySet();
        Iterator<Integer> itr3  = keys3.iterator();
        System.out.println();
        System.out.println("*** The 4 Keys of the Hashtable and the HashMap: ***");
        while(itr2.hasNext()) {
            String key = itr2.next();
            System.out.println("HashTableKey: "+key);
            Integer ikey = itr3.next();
            System.out.println("HashMapKey: "+ikey);
        }

        it = a1.iterator();
        int i=0;
        Point2D v1 = new Point2D(1,2);
        while(it.hasNext()) {
            GeoShape g = it.next();
            if(i%2==0) {a1.get(i).move(v1);}  // modifying the even index GeoShape
            i+=1;
        }

        keys = a2.keySet();
        itr2  = keys.iterator();
        keys3 = a3.keySet();
        itr3  = keys3.iterator();
        System.out.println();
        System.out.println("*** The Keys, two are modified : ***");
        while(itr2.hasNext()) {
            String key = itr2.next();
            System.out.println("HashTableKey: "+key);
            Integer ikey = itr3.next();
            System.out.println("HashMapKey: "+ikey);
        }
        it = a1.iterator();
        System.out.println();
        System.out.println("*** The modified GeoShapes leads to unknow keys: ***");
        while(it.hasNext()) {
            GeoShape g = it.next();
            System.out.println("ArrayList: "+g);
            GeoShape g2 = a2.get(g.toString());
            System.out.println("HashTable: "+g2);
            GeoShape g3 = a3.get(g.hashCode());
            System.out.println("HashMap: "+g3);
        }
    }

    private static GeoShape[] createGeoShapeArr() {
        ArrayList<GeoShape> a1 = new ArrayList<GeoShape>();
        Point2D p1 = new Point2D(1, 2);
        Point2D p2 = new Point2D(1, 3);
        Point2D p3 = new Point2D(2, 4);
        Point2D p4 = new Point2D(2, 1);
        Circle2D c1 = new Circle2D(p1,3);
        Circle2D c2 = new Circle2D(p2,3.5);
        Rect2D r1 = new Rect2D(p1,p3);
        Rect2D r2 = new Rect2D(p2,p4);
        a1.add(c1);
        a1.add(c2);
        a1.add(r1);
        a1.add(r2);
        return a1.toArray(new GeoShape[0]);
    }
}
