package imry_ta.ta_3_4.tests;

import imry_ta.ta_3_4.src.PrimeFactorizer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimeFactorizerTest {

    @Test
    public void testIsPrime_two() {
        assertTrue(PrimeFactorizer.isPrime(2));
    }

    @Test
    public void testIsPrime_negativeNumber() {
        assertFalse(PrimeFactorizer.isPrime(-5));
    }

    @Test
    public void testIsPrime_composite() {
        assertFalse(PrimeFactorizer.isPrime(4));
    }

    @Test
    public void testIsPrime_largePrime() {
        assertTrue(PrimeFactorizer.isPrime(17));
    }
}