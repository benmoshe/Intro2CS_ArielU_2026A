package imry_ta.ta_3_4.src;

public class BaseDetector {

    // Check if a character is a digit (0-9)
    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    // Check if string contains only binary digits (0 or 1)
    public static boolean isBinary(String s) {
        if (s.isEmpty()) {
            return false;
        }
        // Check each character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!isBinaryChar(c)){
                return false;
            }
        }
        return true;
    }

    public static boolean isBinaryChar(char c) {
        if (c != '0' && c != '1') {
            return false;
        }
        return true;

    }

    // Check if string contains only decimal digits (0-9)
    public static boolean isDecimal(String s) {
        if (s.isEmpty()) { //if s is empty string
            return false;
        }
        // Check each character using my isDigit helper
        for (int i = 0; i < s.length(); i++) { // for each character c in s, if c is not a digit return false
            if (!isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Check if character is a valid hexadecimal digit
    public static boolean isHexDigit(char c) {
        return isDigit(c) ||
                (c >= 'A' && c <= 'F') ||
                (c >= 'a' && c <= 'f');
    }

    // Check if string contains only hexadecimal digits
    public static boolean isHexadecimal(String s) {
        if (s.isEmpty()) {
            return false;
        }
        // Check each character
        for (int i = 0; i < s.length(); i++) { // for each character c in s, if c is not a digit OR between (inclusive) a and f return false
            if (!isHexDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Detect the base of a number string (returns 2, 10, 16, or -1 for unknown)
    public static int detectBase(String s) {
        if (s.isEmpty()) {
            return -1;
        }

        // Check from most restrictive to least restrictive
        if (isBinary(s)) {
            return 2;
        }
        if (isDecimal(s)) {
            return 10;
        }
        if (isHexadecimal(s)) {
            return 16;
        }

        return -1;  // Unknown or invalid
    }
    // Get a human-readable name for the base
    public static String getBaseName(int base) {
        switch (base) {
            case 2:
                return "Binary";
            case 10:
                return "Decimal";
            case 16:
                return "Hexadecimal";
            default:
                return "Unknown";
        }
    }

    public static void main(String[] args) {
        // check various strings
        String[] checkStrings = {
                "1010",
                "1234",
                "ABCD",
                "10203",
                "",
                "xyz",
                "FF",
                "101010"
        };
/*
        System.out.println("Base Detection Demo");
        System.out.println("===================\n");

        for (String s : checkStrings) {
            int base = detectBase(s);
            String baseName = getBaseName(base);

            System.out.printf("String: %-10s -> Base: %-2d (%s)\n",
                    "\"" + s + "\"", base, baseName);
        }*/

        System.out.println("\nDetailed checks for \"1010\":");
        String check = "1010";
        System.out.println("Is binary? " + isBinary(check));
        System.out.println("Is decimal? " + isDecimal(check));
        System.out.println("Is hexadecimal? " + isHexadecimal(check));
    }
}
