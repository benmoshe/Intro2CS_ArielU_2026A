package classes.week5;
/**
 * Java program for implementation of QuickSort 
 * @author Rajat Mishra, from: https://www.geeksforgeeks.org/quick-sort/
 * The code was eddited by Boaz Ben-Moshe, KISS.
 */

class QuickSort 
{ 
 /** This function takes the first element as a pivot,
    places the pivot element at its correct 
    position in sorted array, and places all 
    smaller (smaller than pivot) to left of 
    pivot and all greater (or equals) elements to right
    of the pivot */
 public static int partition(double arr[], int low, int high) 
 { 
	 double pivot = arr[low];
     int i = low+1; // index of the first element after the pivot.
     for (int j=i; j<high; j++) {
         // If current element is smaller than the pivot
         if (arr[j] < pivot) {
             swap(arr, i, j);
             i++;
         } 
     }
     i=i-1;
     // swap the pivot (arr[low]) with arr[i] (the pivot's position).
     swap(arr,low,i);
     return i;
 }
    public static void sort(int arr[]) {
        int len = arr.length;
        double[] tmp = new double[len];
        for(int i=0;i<len;i=i+1) {tmp[i]=arr[i];}
        sort(tmp);
        for(int i=0;i<len;i=i+1) {arr[i] = (int)tmp[i];}
    }
 /**
  * The main function that implements QuickSort()
    arr[] --> the array to be sorted.
    the function calls a recursive function with all the range of the array [0,length).
  */
public static void sort(double arr[]) {
    quickSort(arr, 0, arr.length);
}

 /** The main function that implements QuickSort()
   arr[] --> Array to be sorted, 
   low  --> Starting index, 
   high  --> Ending index (not including) */
 public static void quickSort(double arr[], int low, int high) 
 { 
     if (low < high) 
     { 
         /* pi is partitioning index, arr[pi] is now at right place all of
         the smaller elements are to the left of the pivot, and all the other are to the right.
          */
         int pi = partition(arr, low, high); 
         // Recursively sort elements before. partition and after partition
         quickSort(arr, low, pi); // [low,pi)
         quickSort(arr, pi+1, high); // [pi+1,high)
     } 
 }
    // swaps array elements i and j
    public static void swap(double[] a, int i, int j) {
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
 /* A utility function to print array of size n */
 public static void printArray(double arr[]) 
 {
     int n = arr.length; 
     for (int i=0; i<n; ++i) 
         System.out.print(arr[i]+" "); 
     System.out.println(); 
 } 

 // Driver program 
 public static void main(String args[]) 
 { 
     double arr[] = {10, 7, 8, 9, 1, 5}; 
     int n = arr.length; 
     sort(arr); 
     System.out.println("sorted array"); 
     printArray(arr); 
 } 
}