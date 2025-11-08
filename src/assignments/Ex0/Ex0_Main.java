package assignments.Ex0;
import java.util.Scanner;

/**
 * This class is a simple main class for running Ex0 of I2CS (ArielU 2026).
 * Note: this is not a JUnit test class - make sure to test your code with the Ex0Test (JUnit) class.
 *
 */
public class Ex0_Main {
    public static void main(String[] args) {

        final long KILO=1024, MEGA=KILO*KILO, GIGA=MEGA*KILO, TERA=MEGA*MEGA; //
        final long minN = 2, maxN = 100;     // Max n value number
        final int times = 32; // starting from 0, the i"th closest pair of primes.
        long bigNumber = TERA;

        System.out.println("This is a very slow (DEBUG + OBF) solution for Ex0, make sure your code is a way faster");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural even number in range of ["+minN+","+maxN+"] : ");
        long n = sc.nextLong(); // input of an integer (long) number
        if (n < minN || n % 2 != 0 || n > maxN) { // testing the input - should be natural even number > 4.
            System.err.println("Error: you should enter a natural even >= 2, ans smaller than " + maxN + " yet, you have entered " + n + " quiting!");
            System.exit(-1); // quiting the program
        }
        long start = System.currentTimeMillis(); // starting the "timer" for computing the runtime
        ///////////// section a /////////////
        // computing a prime integer (p1), such that p2 = p1+n is a integer as well.
        long p1 = Ex0.getPrimePair(2, n);
        System.out.println("a) First prime pair of range = "+n+" : ["+p1+", "+(p1+n)+"]");
        long p2 = Ex0.getPrimePair(bigNumber, n);
        System.out.println("b) Prime pair above "+bigNumber+" with range of "+n+"  : ["+p2+", "+(p2+n)+"]");
        long p3 = Ex0.getClosestPrimePair(0,n);
        System.out.println("c) The Prime closest pair of range "+n+" : ["+p3+", "+(p3+n)+"]");
        long p4 = Ex0.getMthClosestPrimePair(times,n);
        System.out.println("d) The "+times+"'th closest prime pair of range "+n+" : ["+p4+", "+(p4+n)+"]");
        ///////////// runtime /////////////
        long end = System.currentTimeMillis();
        double dt_sec = (end - start) / 1000.0;
        System.out.println("e) The program runtime is: " + dt_sec + " seconds");
    }
}