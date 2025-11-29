package imry_ta.ta_5.src;

// Java Program for binary search
// from https://www.geeksforgeeks.org/dsa/binary-search/
// modified by Imry Rodkin
public class BinarySearch {
    static int binarySearchLoop(int[] arr, int x) {
        /*
        int arr[] = {2, 3, 4, 5, 6, 8, 10, 12, 30, 40};
        int x = 10;
         */
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if x is present at mid
            if (arr[mid] == x)
                return mid;

            // If x greater, ignore left half
            if (arr[mid] < x)
                low = mid + 1;

                // If x is smaller, ignore right half
            else
                high = mid - 1;
        }

        // If we reach here, then element was
        // not present
        return -1;
    }

    static int binarySearchRec(int[] arr, int low, int high, int x) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearchRec(arr, low, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearchRec(arr, mid + 1, high, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {2, 3, 4, 5, 6, 8, 10, 12, 30, 40};
        int n = arr.length;
        int x = 10;
        // int result = binarySearchLoop(arr, x);
        int result = binarySearchRec(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println(
                    "Element is not present in array");
        else
            System.out.println(
                    "Element is present at index " + result);
    }
}
