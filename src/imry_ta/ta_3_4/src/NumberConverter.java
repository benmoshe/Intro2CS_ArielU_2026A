package imry_ta.ta_3_4.src;

public class NumberConverter {

    // Convert binary string to decimal integer
    public static int binaryToDecimal(String binary) {
        int result = 0;
        int power = 1;  // Start with 2^0

        // Loop from right to left through the string
        for (int i = binary.length() - 1; i >= 0; i--) {
            // If this position has a 1, add its value
            if (binary.charAt(i) == '1') {
                result += power;
            }
            // Move to next power of 2
            power *= 2;
        }
        return result;
    }

    // Convert decimal integer to binary string
    public static String decimalToBinary(int decimal) {
        // Handle special case
        if (decimal == 0) {
            return "0";
        }

        String result = "";

        // Keep dividing by 2 and collect remainders
        while (decimal > 0) {
            int remainder = decimal % 2;
            // Add remainder to front of string (building backwards)
            result = remainder + result;
            decimal = decimal / 2;
        }
        return result;
    }

    // Convert hexadecimal string to decimal integer
    public static int hexToDecimal(String hex) {
        int result = 0;
        int power = 1;  // Start with 16^0

        // Loop from right to left
        for (int i = hex.length() - 1; i >= 0; i--) {
            char c = hex.charAt(i);
            int digitValue = getHexDigitValue(c);
            result += digitValue * power;
            // Move to next power of 16
            power *= 16;
        }
        return result;
    }

    // Convert a hex character to its numeric value
    public static int getHexDigitValue(char c) {
        if (c == '0') {
            return 0;
        }
        if (c == '1') {
            return 1;
        }
        /*
         *
         * */
        if (c == 'e' || c == 'E') {
            return 14;
        }
        if (c == 'f' || c == 'F') {
            return 15;
        }
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'F') {
            return c - 'A' + 10;
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'a' + 10;
        }
        return -1;  // Invalid character
    }

    // Convert decimal integer to hexadecimal string
    public static String decimalToHex(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        String result = "";
        String hexDigits = "0123456789ABCDEF"; // this is the actual order in hexa-base (0, 1, ... , 14, 15)

        // Keep dividing by 16
        while (decimal > 0) {
            int remainder = decimal % 16;
            // Get the hex character for this remainder
            result = hexDigits.charAt(remainder) + result;
            decimal = decimal / 16;
        }
        return result;
    }

    // Convert any base to decimal (supports bases 2-16)
    public static int anyBaseToDecimal(String number, int base) {
        int result = 0;
        int power = 1;

        // Loop from right to left
        for (int i = number.length() - 1; i >= 0; i--) {
            char c = number.charAt(i);
            int digitValue;

            if (base <= 10) {
                digitValue = c - '0';
            } else {
                digitValue = getHexDigitValue(c);
            }

            result += digitValue * power;
            power *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Number Conversion Demo");
        System.out.println("======================\n");

        // Binary to Decimal examples
        System.out.println("Binary to Decimal:");
        String[] binaryNumbers = {"1010", "1111", "10000", "101010"};
        for (String bin : binaryNumbers) {
            int dec = binaryToDecimal(bin);
            System.out.printf("  %s (binary) = %d (decimal)\n", bin, dec);
        }

        System.out.println("\nDecimal to Binary:");
        int[] decimalNumbers = {10, 15, 16, 42, 255};
        for (int dec : decimalNumbers) {
            String bin = decimalToBinary(dec);
            System.out.printf("  %d (decimal) = %s (binary)\n", dec, bin);
        }

        System.out.println("\nHexadecimal to Decimal:");
        String[] hexNumbers = {"A", "FF", "10", "1A2B"};
        for (String hex : hexNumbers) {
            int dec = hexToDecimal(hex);
            System.out.printf("  %s (hex) = %d (decimal)\n", hex, dec);
        }

        System.out.println("\nDecimal to Hexadecimal:");
        int[] decForHex = {10, 255, 16, 6827};
        for (int dec : decForHex) {
            String hex = decimalToHex(dec);
            System.out.printf("  %d (decimal) = %s (hex)\n", dec, hex);
        }

        System.out.println("\nRound-trip check (binary):");
        String original = "11010110";
        int decimal = binaryToDecimal(original);
        String converted = decimalToBinary(decimal);
        System.out.printf("  Original: %s -> Decimal: %d -> Back: %s\n",
                original, decimal, converted);
        System.out.println("  Match? " + original.equals(converted));
    }
}