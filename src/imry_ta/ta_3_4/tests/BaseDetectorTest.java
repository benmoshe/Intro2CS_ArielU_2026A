package imry_ta.ta_3_4.tests;

import imry_ta.ta_3_4.src.BaseDetector;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BaseDetectorTest {
    // add missing tests!
    @Test
    public void testIsBinary_not_binary(){
        assertFalse(BaseDetector.isBinary("ABCD"));
    }
    @Test
    public void testIsBinary_binary(){
        assertTrue(BaseDetector.isBinary("1010"));
    }
    @Test
    public void testDetectBase_binary() {
        assertEquals(2, BaseDetector.detectBase("1010"));
    }

    @Test
    public void testDetectBase_decimal() {
        assertEquals(10, BaseDetector.detectBase("1234"));
    }

    @Test
    public void testDetectBase_hex() {
        assertEquals(16, BaseDetector.detectBase("ABCD"));
    }

    @Test
    public void testDetectBase_empty() {
        assertEquals(-1, BaseDetector.detectBase(""));
    }

    @Test
    public void testDetectBase_invalid() {
        assertEquals(-1, BaseDetector.detectBase("xyz"));
    }
}