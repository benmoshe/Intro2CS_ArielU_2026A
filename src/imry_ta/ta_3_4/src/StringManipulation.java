package imry_ta.ta_3_4.src;

public class StringManipulation {
    public static boolean isThere(String s) {
        String c = "1";
        if (s.contains(c)) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c.charAt(0)) {
                return true;
            }
        }
        return false;
    }

    // Reverse a string manually (without using built-in reverse)
    public static String reverse(String s) {
        String result = "";
        // Loop backwards through the string
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }

    // Check if a string is a palindrome
    public static boolean isPalindrome(String s) {
        // Compare original with its reverse
        return s.equals(reverse(s));
    }

    // Check if palindrome (more efficient, no reverse needed)
    public static boolean isPalindromeEfficient(String s) {
        int left = 0;
        int right = s.length() - 1;

        // Compare characters from both ends moving inward
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Count occurrences of a character in a string
    public static int countChar(String s, char target) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == target) {
                count++;
            }
        }
        return count;
    }

    // Count digits in a string
    public static int countDigits(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                count++;
            }
        }
        return count;
    }

    // Count letters in a string
    public static int countLetters(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                count++;
            }
        }
        return count;
    }

    // Remove all spaces from a string
    public static String removeSpaces(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                result += s.charAt(i);
            }
        }
        return result;
    }

    // Check if two strings are anagrams (same letters, different order)
    public static boolean areAnagrams(String s1, String s2) {
        // Remove spaces and convert to lowercase
        s1 = removeSpaces(s1).toLowerCase();
        s2 = removeSpaces(s2).toLowerCase();

        // Different lengths means not anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Check if each character appears same number of times
        for (char c = 'a'; c <= 'z'; c++) {
            if (countChar(s1, c) != countChar(s2, c)) {
                return false;
            }
        }
        return true;
    }

    // Extract only digits from a string
    public static String extractDigits(String s) {

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                result += c;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        s3.toUpperCase();

        System.out.println(s1==s2);
        System.out.println(s2==s1);
        System.out.println(s3.equals(s1));
        System.out.println(s3.equals(s2));


        /*
        System.out.println("String Manipulation Demo");
        System.out.println("========================\n");

        // check reverse
        System.out.println("String Reversal:");
        //String[] stringsCheck = {"hello", "racecar", "12345"};
        for (String s : args) {
            System.out.printf("  \"%s\" reversed is \"%s\"\n", s, reverse(s));
        }
        // check palindrome
        System.out.println("\nPalindrome Check:");
        String[] palindromeChecks = {"racecar", "hello", "madam", "12321", "check"};
        for (String s : palindromeChecks) {
            System.out.printf("  \"%s\" is palindrome? %b\n", s, isPalindrome(s));
        }

        // check character counting
        System.out.println("\nCharacter Counting:");
        String sample = "hello world 123";
        System.out.printf("  String: \"%s\"\n", sample);
        System.out.printf("  Digits: %d\n", countDigits(sample));
        System.out.printf("  Letters: %d\n", countLetters(sample));
        System.out.printf("  Letter 'l': %d\n", countChar(sample, 'l'));

        // check space removal
        System.out.println("\nSpace Removal:");
        String withSpaces = "hello world from java";
        System.out.printf("  Original: \"%s\"\n", withSpaces);
        System.out.printf("  Without spaces: \"%s\"\n", removeSpaces(withSpaces));

        // check anagrams
        System.out.println("\nAnagram Check:");
        String[][] anagramPairs = {
                {"listen", "silent"},
                {"hello", "world"},
                {"The Eyes", "They See"}
        };
        for (String[] pair : anagramPairs) {
            boolean result = areAnagrams(pair[0], pair[1]);
            System.out.printf("  \"%s\" and \"%s\": %b\n",
                    pair[0], pair[1], result);
        }

        // check digit extraction
        System.out.println("\nDigit Extraction:");
        String mixed = "abc123def456";
        System.out.printf("  From \"%s\": \"%s\"\n",
                mixed, extractDigits(mixed));*/
    }
}
