package imry_ta.ta_3_4.tests;

import imry_ta.ta_3_4.src.StringManipulation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringManipulationTest {

    @Test
    public void testCaseForIndexOfExists(){ // char exists
        String s = "hello";
        assertEquals(1, s.indexOf('e'));
    }
    @Test
    public void testCaseForIndexOfNotExists(){ // char exists
        String s = "hello";
        assertEquals(-1, s.indexOf('r'));
    }
    @Test
    public void testReverse_simple() {
        assertEquals("olleh", StringManipulation.reverse("hello"));
    }

    @Test
    public void testReverse_empty() {
        assertEquals("", StringManipulation.reverse(""));
    }

    @Test
    public void testIsPalindrome_true() {
        assertTrue(StringManipulation.isPalindrome("racecar"));
    }

    @Test
    public void testIsPalindrome_false() {
        assertFalse(StringManipulation.isPalindrome("hello"));
    }

    @Test
    public void testCountDigits() {
        assertEquals(3, StringManipulation.countDigits("abc123"));
    }
}