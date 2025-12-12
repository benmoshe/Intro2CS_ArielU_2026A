package classes.week7;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class represents a simple solution for the class quiz, see:
 * https://docs.google.com/document/d/1xyHtUNoxbQ2bYiXHIfNlJqNT6TTdSG2-zY7nbnfa3Y0/edit?usp=sharing
 * Note: this class is not well written and in is mainly "paper version" of a code.
 */

public class Quiz {
    /// ///////////// Q1 /////////////////
    public static int[] toSet(int[] arr) { //…
        int[] ans = null;
        if(arr!=null) {
            int len = arr.length, count=0, j=0;
            for(int i=0;i<len;i=i+1) {if(!contains(arr,i+1, arr[i])) {count+=1;}}
            ans = new int[count];
            for(int i=0;i<len;i=i+1) {if(!contains(arr,i+1, arr[i])) {ans[j]=arr[i]; j+=1;}}
        }
        return ans;
    }
    private static boolean contains(int[] arr, int start, int value) {
        boolean ans = false;
        for(int i=start;!ans && arr!=null && i<arr.length; i+=1) {
            if(arr[i]==value) {ans = true;}
        }
        return ans;
    }
    /// ///////////// Q2 /////////////////
    @Test
    public void testToSet() { //…
        int[][] arr1 = {null, {}, {1}, {1,1,1}, {1,2,1,2,1,2,2,3}};
        int [][] res = {null, {}, {1}, {1}, {1,2,3}};
        for(int i=0;i<arr1.length;i+=1) {
            int[] a = toSet(arr1[i]);
            assertTrue(eq(a, res[i]));
        }
    }
    private static boolean eq(int[] a, int[] b) {
        boolean ans = true;
        if(a==null && b==null) {return true;}
        if(a==null | b==null) {return false;}
        if(a.length != b.length) {return false;}
        for(int i=0;i<a.length & ans; i+=1) {
            if(!contains(b,0,a[i])) {
                ans = false;}
        }
        for(int i=0;i<b.length & ans; i+=1) { if(!contains(a,0,b[i])) {
            ans = false;}}
        return ans;
    }
    /// ///////////// Q3 /////////////////

    public static int max2Index(double[] arr) {
        int ans = -1;
        double[] cp = new double[arr.length];
        for (int j = 0; j < arr.length; j++) {cp[j] = arr[j];}
        int maxInd = maxIndex(cp, 0); //sort(cp), v2 = cp[cp.length-2];
        swap(cp, 0, maxInd);
        int i2 = maxIndex(cp, 1);
        double v2 = cp[i2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == v2) {ans = i;}
        }
        return ans;
    }
    private static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static int maxIndex(double[] arr, int start) {
        int ans = start;
        for(int i=start+1;i<arr.length;i+=1) {if(arr[ans]<arr[i]) {ans = i;}}
        return ans;
    }
    /// ///////////// Q4 /////////////////
    @Test
    public void testMax2Index() { //…
        double[][] arrs = {{1,2}, {2,1,0}, {1,2,3,0}, {-5,-100,0.1,0.2,-0.3,-0.4}};
        int[] res = {0, 1, 1, 2};
        for(int i=0;i<arrs.length;i+=1) {
            int i2 =max2Index(arrs[i]);
            assertEquals(i2, res[i]);
        }
    }
/// ///////////// Q5 /////////////////
    public static double[] random(int size, double min, double max) { //…
        double[] ans = new double[size];
        for(int i=0;i<size;i+=1) {
            double rand = Math.random(); // return a random double in range [0,1).
            double dx = max - min;
            ans[i] = min + (rand * dx); // [min, max) === [min, min + (max-min))}
        }
        return ans;
    }
}
