package imry_ta.ta_5.src;

import java.util.Scanner;

public class MultiplicationTable {

    private static int getTableSize(Scanner scanner) {
        System.out.print("Enter N for NxN multiplication table: ");
        return scanner.nextInt();
    }

    private static int[][] createMultiplicationTableOriginal(int n) {
        int[][] table = new int[n][n];

        // Fill all cells independently
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }

        return table;
    }

    private static int[][] createMultiplicationTableFast(int n) {
        int[][] table = new int[n][n];

        // Fill only upper triangle and diagonal, then mirror to lower triangle
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int value = (i + 1) * (j + 1);
                table[i][j] = value;
                // Mirror to the symmetric position
                table[j][i] = value;
            }
        }

        return table;
    }

    private static void displayTable(int[][] table, int n) {
        System.out.println("\nMultiplication Table:");
        // Limit display for large tables
        int displaySize = Math.min(n, 12);
        for (int i = 0; i < displaySize; i++) {
            for (int j = 0; j < displaySize; j++) {
                System.out.printf("%4d", table[i][j]);
            }
            System.out.println();
        }
        if (n > 12) {
            System.out.println("... (showing first 12x12 only)");
        }
    }

    private static void getAndDisplayResult(Scanner scanner, int[][] table, int n) {
        System.out.print("\nEnter first number (1-" + n + "): ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number (1-" + n + "): ");
        int num2 = scanner.nextInt();

        if (num1 < 1 || num1 > n || num2 < 1 || num2 > n) {
            System.out.println("Numbers must be between 1 and " + n);
        } else {
            int result = table[num1 - 1][num2 - 1];
            System.out.println(num1 + " x " + num2 + " = " + result);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter N for performance comparison: ");
        int n = scanner.nextInt();

        // Run performance comparison
        System.out.println("\n--- Performance Comparison ---");

        // check original approach
        long startTime = System.nanoTime();
        int[][] table1 = createMultiplicationTableOriginal(n);
        long endTime = System.nanoTime();
        long originalTime = endTime - startTime;

        // check optimized approach
        startTime = System.nanoTime();
        int[][] table2 = createMultiplicationTableFast(n);
        endTime = System.nanoTime();
        long optimizedTime = endTime - startTime;

        System.out.println("Original approach: " + originalTime + " ns");
        System.out.println("Optimized approach: " + optimizedTime + " ns");
        System.out.println("Speedup: " + ((double)originalTime / optimizedTime) + "x");

        // Continue with normal program flow using optimized version
        displayTable(table2, n);
        getAndDisplayResult(scanner, table2, n);

        scanner.close();
    }
}
