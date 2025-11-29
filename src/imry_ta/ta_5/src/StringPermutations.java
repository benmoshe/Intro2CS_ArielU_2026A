package imry_ta.ta_5.src;

import java.util.*;
// Java Program to generate all unique
// permutations of a string from https://www.geeksforgeeks.org/dsa/write-a-c-program-to-print-all-permutations-of-a-given-string/
// modified by Imry Rodkin
class StringPermutations {
    // {A, B, C}
    static void recurPermute(int index, char[] chars, String[] ans, int[] counter) {
        if (index == chars.length) {
            ans[counter[0]++] = new String(chars);
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            recurPermute(index + 1, chars, ans, counter);
            swap(chars, index, i);
        }
    }

    static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    static String[] findPermutation(String s) {
        int size = factorial(s.length());
        String[] ans = new String[size];
        int[] counter = new int[1];
        char[] chars = s.toCharArray();
        recurPermute(0, chars, ans, counter);
        Arrays.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        String s = "BAC";
        String[] res = findPermutation(s);
        for (String x : res) {
            System.out.print(x + " ");
        }
    }
}
