package assignments.Ex0.sol;

/**
 * Here is a class solution for Ex0 - code only.
 *

 */
public class Ex0 {
    /**
     * A boolean array with all the "small primes" until PRIME_MEM_SIZE.
     * The array was computed using this method: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     */
    private static boolean[] primes = null;
    public static final int PRIME_MEM_SIZE = 1000*1000*15;// this number can be optimized it really depends on the actual testing.
    /**
     * This function checks if n is a prime number.
     * I.e.; for each integer p with in [2,n) --> n%p!=0
     * Note: this function is actually colling another (concrete) isPrime function(slow-naive, fast-checking till sqrt(n), memory-usage compute first all the small primes till say 10^7.
     * @param n (Integer) - represented as long
     * @return true if and only if there is no integer (p) within the range of [2,n) which divides n.
     *
     */
    public static boolean isPrime(long n) {
      //  return isPrimeFast(n);
        return isPrimeMem(n); // this is significant faster.
    }
    ///
    /**
     * This function finds the first prime integer (p1) >= start, for which p2=p1+n is also a prime number.
     * @param start - a starting value from which p1 should be searched for.
     * @param n - a positive (even) integer value.
     * @return the first prime number p1 such that: i) p1>=start, ii) p1+n is a prime number.
     * in case a wrong value is given to the function
     * (n<2 or n is an odd number) the function returns -1.
     *
     */
    public static long getPrimePair(long start, long n) {
        long ans = -1;
        if(n>=2 && n%2==0) {
            if(start%2==0) {start +=1;}
            long p1 = Math.max(3,start); // no point starting at a starting point before max(3,start).
            while(ans==-1) {
                if(isPrime(p1+n) && isPrime(p1)) {
                    ans = p1;
                }
                else {
                    p1 = p1 + 2;
                }
            }
        }
        return ans;
    }
    /**
     * This function compute the first prime number p1 for which:
     * i) p1 >= start (p1 is a prime number)
     * ii) p1+n==p2 ia a prime number.
     * iii) there are no prime numbers in the (p1,p2) range.
     *
     * @param start a positive integer which is the lower bound of p1.
     * @param n - a positive even integer.
     * @return a prime number p1>=start that the following prime number is p1+n.
     */
    public static long getClosestPrimePair(long start, long n) {
        long p1 = getPrimePair(start, n);
        long p2 = p1+n;
        while (hasPrime(p1+1,p2)) {
             p1 = getPrimePair(p2, n);
             p2 = p1+n;
        }
        return p1;
    }

    /**
     * This function compute the m'th positive integer p1 for which:
     * i) p1 is a prime number.
     * ii) p1+n==p2 ia a prime number.
     * iii) there are no prime numbers in the (p1,p2) range.
     *
     * @param m a none negative integer.
     * @param n - a positive even integer.
     * @return a prime number p1>=start that the following prime number is p1+n.
     *
     */
    public static long getMthClosestPrimePair(int m, long n) {
        if(m<0 | n<0 | n%2!=0) {
            System.err.println("Invalid input: got m="+m+", n="+n+"  |  m should be >=0 & n should be a positive even integer ");
            return -1;
        }
        int i=0;
        long p2 = 2;
        while (i<=m) {
            p2 = getClosestPrimePair(p2, n) + n;
            i=i+1;
        }
        return p2-n; //
    }

    /// /////// Private functions ///////////

    /**
     * This function checks if there is a prime number in the [start,end) range.
     * Note: the number 2 is the first prime number.

     * @param start the lowest value of the range (including start).
     * @param end the end of the range (not including end).
     * @return the true if and only if there are no prime numbers in the [start,end) range.
     */
    private static boolean hasPrime(long start, long end) {
        boolean found_a_prime = false;
        if(start>=2 & start<end) {
            if(start==2) {found_a_prime=true;}
            long p = start;
            if(p%2==0) {p=p+1;} // p should be an odd number
            while (p<end && !found_a_prime) {
                if(isPrime(p)) {found_a_prime=true;}
                p+=2;
            }
        }
        return found_a_prime;
    }
    private static int getNextPrimeInTable(int n) {
        int ans = -1;
        n++;
        while (ans==-1 && n<=primes.length) {
            if(isPrime(n)) {ans = n;}
            else {n++;}
        }
        return ans;
    }
    /**
     * This static function test if n is a prime number be going over only the
     * odd numbers until the sqrt of n, as is n is not a prime number --> n=a*b, denote that min(a,b)<=sqrt(n).
     *
     * @param n
     * @return
     */
    private static boolean isPrimeFast(long n) {
        boolean ans = true;
        if(n==2) {ans = true;}
        else {
            if(n<2 | n%2==0) {ans = false;}
        }
        long p = 3;
        double rn = Math.sqrt(n);
        while (ans && p<=rn) {
            if(n%p==0) {ans = false;}
            p = p + 2;
        }
        return ans;
    }

    /**
     * Naive (aka slow) method for testing ot n is a prome number.
     * @param n
     * @return
     */
    private static boolean isPrimeSlow(long n) {
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

    /**
     * This static function uses static memory inorder to compute all "small primes
     * using https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes.
     * This computation is only performed once (at the first call of this function).
     *
     * @param n
     * @return
     */
    private static boolean isPrimeMem(long n) {
        boolean ans = true;
        if(primes==null) {init(PRIME_MEM_SIZE);} // first time
       if(n<primes.length && n>=0) {
           ans = primes[(int)n];
       }
       else {ans = isPrimeFast(n);}
        return ans;
    }
    /**
     * inits an array of boolean representing the n first integers: true it prime, false if not.
     * @param n
     */

    private static void init(int n) {
        if(primes==null || n>primes.length) {
            primes = new boolean[n]; // all false by default
            primes[2] = true;
            for (int i = 3; i < n; i+=2) {primes[i] = true;}
            int i=2;
            double sqn = Math.sqrt(n);
            while (i<=sqn) {
                i=getNextPrimeInTable(i);
                int j=2;
                while(j*i<n) {
                    primes[j*i]=false;
                    j=j+1;
                }
            }
        }
    }
}
