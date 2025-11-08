package classes.week2;

import java.util.Scanner;

/**
 * This function computes the closest prime number to the input.
 * Examples:
 * ClosestPrime === cp
 * cp(3) --> 3
 * cp(4) --> 3
 * cp(-4) -->2
 * cp(27) --> 29
 */
public class ClosestPrime {
    public static void main(String[] args) {
//int x 27;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int x = sc.nextInt();
        long a = getClosestPrime(x);
        System.out.println(a);
    }
    public static long getClosestPrime(long n){
       // int n = 3331-10;
        int i = 0;; ///0,1,2,3
        long ans = -1;
        boolean found = false;
        while(!found) {
            if(isPrime(n-i)) {
                found = true;
                ans= n-i;
         //       System.out.println(ans);
            }
            else {
                if(isPrime(n+i)) {
                    found = true;
                    ans= n+i;
            //        System.out.println(ans);
                }
            }
            i=i+1;
        }
        return ans;
    }
    public static boolean isPrime(long n) {
        boolean ans = true;
        if(n==2) {ans = true;}
        else {
            if(n<2 || n%2==0) {ans = false;}
        }
        long p = 3;
        while (ans && p<n) {
            if(n%p==0) {ans = false;}
            p = p + 2;
        }
        return ans;
    }
}
