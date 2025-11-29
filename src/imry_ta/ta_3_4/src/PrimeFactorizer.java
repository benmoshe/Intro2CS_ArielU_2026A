package imry_ta.ta_3_4.src;

public class PrimeFactorizer {

    // Check if a number is prime
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        // Only need to check up to square root
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Find the smallest prime factor of n
    public static int smallestPrimeFactor(int n) {
        // Try each potential factor starting from 2
        for (int i = 2; i <= n; i++) {
            // If it divides evenly and is prime, found it
            if (n % i == 0 && isPrime(i)) {
                return i;
            }
        }
        return n;  // n itself is prime
    }

    // More efficient version: find smallest factor (doesn't check if it's prime)
    public static int smallestFactor(int n) {
        if (n < 2) {
            return n;
        }
        // Try each potential factor
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return i;
            }
        }
        return n;  // n itself is prime
    }

    // Print all prime factors in the format: n = p1 * p2 * p3 * ...
    public static void printPrimeFactors(int n) {
        System.out.print(n + " = ");

        if (n < 2) {
            System.out.println("(no prime factorization for numbers less than 2)");
            return;
        }

        int remaining = n;
        boolean first = true;

        // Keep factoring until we reach 1
        while (remaining > 1) {
            int factor = smallestFactor(remaining);

            if (!first) {
                System.out.print(" * ");
            }
            System.out.print(factor);

            remaining = remaining / factor;
            first = false;
        }
        System.out.println();
    }

    // Return prime factors as an array
    public static int[] getPrimeFactors(int n) {
        // First, count how many factors there are
        int count = 0;
        int temp = n;
        while (temp > 1) {
            int factor = smallestFactor(temp);
            count++;
            temp = temp / factor;
        }

        // Create array and fill it
        int[] factors = new int[count];
        int index = 0;
        while (n > 1) {
            int factor = smallestFactor(n);
            factors[index] = factor;
            n = n / factor;
            index++;
        }

        return factors;
    }

    // Count how many times a prime appears in the factorization
    public static int countPrimeFactor(int n, int prime) {
        int count = 0;
        while (n % prime == 0) {
            count++;
            n = n / prime;
        }
        return count;
    }

    // Print factors with exponents (more compact format)
    public static void printPrimeFactorsWithExponents(int n) {
        System.out.print(n + " = ");

        if (n < 2) {
            System.out.println("(no prime factorization for numbers less than 2)");
            return;
        }

        boolean first = true;
        int remaining = n;

        while (remaining > 1) {
            int factor = smallestFactor(remaining);
            int exponent = countPrimeFactor(remaining, factor);

            if (!first) {
                System.out.print(" * ");
            }

            if (exponent == 1) {
                System.out.print(factor);
            } else {
                System.out.print(factor + "^" + exponent);
            }

            // Divide out all instances of this factor
            for (int i = 0; i < exponent; i++) {
                remaining = remaining / factor;
            }
            first = false;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Prime Factorization Demo");
        System.out.println("========================\n");

        // check isPrime function
        /*System.out.println("checking isPrime function:");
        int[] checkPrimes = {2, 3, 4, 17, 20, 23, 100};
        for (int num : checkPrimes) {
            System.out.printf("  %d is prime? %b\n", num, isPrime(num));
        }*/

        System.out.println("\nPrime Factorizations:");
        int[] numbersToFactor = {12, 28, 100, 17, 60, 128, 2025};
        for (int num : numbersToFactor) {
            System.out.print("  ");
            printPrimeFactors(num);
        }

        System.out.println("\nPrime Factorizations (with exponents):");
        for (int num : numbersToFactor) {
            System.out.print("  ");
            printPrimeFactorsWithExponents(num);
        }

        System.out.println("\nGetting factors as an array:");
        int checkNum = 60;
        int[] factors = getPrimeFactors(checkNum);
        System.out.print("  Factors of " + checkNum + ": ");
        for (int i = 0; i < factors.length; i++) {
            System.out.print(factors[i]);
            if (i < factors.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
