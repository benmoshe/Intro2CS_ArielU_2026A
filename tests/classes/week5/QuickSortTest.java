package classes.week5;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class QuickSortTest {
	@Test
	void testSort() {
		double[] arr = {7,6,5,4,9,2,1,8,3,0};
		QuickSort.sort(arr);
		boolean b = MyArrayLibrary.isSortedAscending(arr);
		if(b!=true) {
			fail("ERR: the array should be sorted!");
		}
	}
    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void testSort2() {
        int size = 1000*1000;
        double[] arr = MyArrayLibrary.randomDoubleArray(size,0 ,size*10);
        QuickSort.sort(arr);
        boolean b = MyArrayLibrary.isSortedAscending(arr);
        assertTrue(b);
    }
    @Test
    @Timeout(value = 2000, unit = TimeUnit.MILLISECONDS)
    void testSort3() {
        int size = 1000*1000*5;
        double[] arr = MyArrayLibrary.randomDoubleArray(size,0 ,size);
        QuickSort.sort(arr);
    }
}
