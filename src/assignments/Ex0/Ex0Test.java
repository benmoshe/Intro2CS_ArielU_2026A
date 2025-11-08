package assignments.Ex0;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This JUnit class represents a simple example regarding how to test Ex0
 * and functions in general - using the notion of Unit Testing.
 * It tests both correctness and runtime performance (using the @Timeout notion).
 * Note: add an explanation for every @Test, you are welcome to add your own tests.
 *
 */
class Ex0Test {
    @Test
    void isPrime() {
        boolean prime = Ex0.isPrime(2);
        assertTrue(prime);
        prime = Ex0.isPrime(3);
        assertTrue(prime);
        prime = Ex0.isPrime(29);
        assertTrue(prime);
        prime = Ex0.isPrime(33331);
        assertTrue(prime);
    }
    @Test
    void isNotPrime() {
        boolean isPrime = Ex0.isPrime(2);
        isPrime = Ex0.isPrime(0);
        assertFalse(isPrime);
        isPrime = Ex0.isPrime(1);
        assertFalse(isPrime);
        isPrime = Ex0.isPrime(-30);
        assertFalse(isPrime);
        long notAPrime = 2*3*5*7*11*13+1;
        isPrime = Ex0.isPrime(notAPrime);
        assertFalse(isPrime);
        isPrime = Ex0.isPrime(333333331);
        assertFalse(isPrime);
    }
    @Test
    void getPrimePair() {
        long n1= 20, n2 = 2, bigStart = 10000;
        long p1 = Ex0.getPrimePair(2,n1);
        assertEquals(3, p1);
        long p2 = p1 + n1;
        assertTrue(Ex0.isPrime(p2));

        p1 = Ex0.getPrimePair(bigStart,n2);
        assertTrue(Ex0.isPrime(p1));
        p2 = p1 + n2;
        assertTrue(Ex0.isPrime(p2));
    }

    @Test
    void getClosestPrimePair() {
        long n1= 120, bigStart = 10000;
        long p1 = Ex0.getClosestPrimePair(bigStart,n1);
        assertTrue(Ex0.isPrime(p1));
        long p2 = p1 + n1;
        assertTrue(Ex0.isPrime(p2));
        long i = p1+1;
        while(i<p2) {
            assertFalse(Ex0.isPrime(i));
            i=i+1;
        }
    }

    @Test
    void getMthClosestPrimePair() {
        long n1= 2;
        int bigM = 10000;
        long p1 = Ex0.getMthClosestPrimePair(0,n1);
        assertEquals(3,p1);
        p1 = Ex0.getMthClosestPrimePair(1,n1);
        assertEquals(5,p1);
        p1 = Ex0.getMthClosestPrimePair(2,n1);
        assertEquals(11,p1);
        p1 = Ex0.getMthClosestPrimePair(4,n1);
        assertEquals(29,p1);
        p1 = Ex0.getMthClosestPrimePair(bigM,n1);
        assertEquals(1261079,p1);
    }

    /// /////////// RUN TIME ///////////////
    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void getClosestPrimePairRuntime1() {
        getClosestPrimePair();
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    void getClosestPrimePairRuntime2() {
        long n1 = 2, bigStart = 10000;
        long p1 = Ex0.getClosestPrimePair(bigStart, n1);
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void getMthClosestPrimePairRuntime() {
        long n1= 2;
        int bigM = 10000;
        long p1 = Ex0.getMthClosestPrimePair(bigM,n1);
        assertEquals(1261079,p1);
    }
}