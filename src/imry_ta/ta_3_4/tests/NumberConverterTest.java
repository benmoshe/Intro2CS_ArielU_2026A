package imry_ta.ta_3_4.tests;

import imry_ta.ta_3_4.src.NumberConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberConverterTest {

    @Test
    public void testBinaryToDecimal_zero() {
        assertEquals(0, NumberConverter.binaryToDecimal("0"));
    }

    @Test
    public void testBinaryToDecimal_simple() {
        assertEquals(5, NumberConverter.binaryToDecimal("101"));
    }

    @Test
    public void testBinaryToDecimal_allOnes() {
        assertEquals(7, NumberConverter.binaryToDecimal("111"));
    }

    @Test
    public void testBinaryToDecimal_largerNumber() {
        assertEquals(42, NumberConverter.binaryToDecimal("101010"));
    }

    @Test
    public void testBinaryToDecimal_powerOfTwo() {
        assertEquals(16, NumberConverter.binaryToDecimal("10000"));
    }

    @Test
    public void testDecimalToBinary_zero() {
        assertEquals("0", NumberConverter.decimalToBinary(0));
    }

    @Test
    public void testDecimalToBinary_simple() {
        assertEquals("101", NumberConverter.decimalToBinary(5));
    }

    @Test
    public void testDecimalToBinary_largerNumber() {
        assertEquals("11111111", NumberConverter.decimalToBinary(255));
    }

    @Test
    public void testDecimalToBinary_powerOfTwo() {
        assertEquals("10000", NumberConverter.decimalToBinary(16));
    }

    @Test
    public void testBinaryConversionRoundTrip() {
        int original = 42;
        String binary = NumberConverter.decimalToBinary(original);
        int converted = NumberConverter.binaryToDecimal(binary);
        assertEquals(original, converted);
    }

    @Test
    public void testHexConversionRoundTrip() {
        int original = 255;
        String hex = NumberConverter.decimalToHex(original);
        int converted = NumberConverter.hexToDecimal(hex);
        assertEquals(original, converted);
    }

    @Test
    public void testNotHexaHexaToDecimal(){
        char c = 'T';
        int result = NumberConverter.getHexDigitValue(c);
        assertEquals(-1, result);
    }
    @Test
    public void testNotEqualsNotHexaHexaToDecimal(){
        char c = 'F';
        int result = NumberConverter.getHexDigitValue(c);
        assertNotEquals(-1, result);
    }
    @Test
    public void testDoesEqualsNotHexaHexaToDecimal(){
        char c = 'F';
        int result = NumberConverter.getHexDigitValue(c);
        assertEquals(15, result);
    }
}