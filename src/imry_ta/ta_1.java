package imry_ta;

import java.util.Scanner;

public class ta_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Run specific exercise by uncommenting the desired line
        // togetherWhile(scanner);
        // together(scanner);
        // exercise1a(scanner);
        // exercise1b(scanner);
        // exercise2(scanner);
        // exercise3(scanner);
        // exercise4a(scanner);
        // exercise4b(scanner);
        // exercise5(scanner);
        // exercise6a(scanner);
        // exercise6b(scanner);
        // exercise7a(scanner);
        // exercise7b(scanner);
        // exercise8a(scanner);
        // exercise8b(scanner);

        scanner.close();
    }

    public static void togetherWhile(Scanner scanner) {
        System.out.print("Enter x: ");
        int x = scanner.nextInt();
        System.out.print("Enter y: ");
        int y = scanner.nextInt();
        while (x > 10) {
            if (x > y) {
                System.out.println("x is bigger than y (x = " + x-- + ")");
            } else if (x == y) {
                System.out.println("x is equal to y (x = " + x-- + ")");
            } else {
                System.out.println("x is less than y (x = " + x-- + ")");
            }
        }
    }

    public static void together(Scanner scanner) {
        System.out.print("Enter x: ");
        int x = scanner.nextInt();
        System.out.print("Enter y: ");
        int y = scanner.nextInt();
        if (x > y) {
            System.out.print("x is bigger than y");
        } else if (x == y) {
            System.out.print("x is equal to y");
        } else {
            System.out.print("x is less than y");
        }

    }

    // Exercise 1a - Swap with temp variable
    public static void exercise1a(Scanner scanner) {
        System.out.println("\n=== Exercise 1a - Swap with temp ===");
        System.out.print("Enter x: ");
        int x = scanner.nextInt();
        System.out.print("Enter y: ");
        int y = scanner.nextInt();

        System.out.println("Before: x=" + x + ", y=" + y);

        int temp = x;
        x = y;
        y = temp;

        System.out.println("After: x=" + x + ", y=" + y);
    }

    // Exercise 1b - Swap without temp variable
    public static void exercise1b(Scanner scanner) {
        System.out.println("\n=== Exercise 1b - Swap without temp ===");
        System.out.print("Enter x: ");
        int x = scanner.nextInt();
        System.out.print("Enter y: ");
        int y = scanner.nextInt();

        System.out.println("Before: x=" + x + ", y=" + y);

        x = x + y;
        y = x - y;
        x = x - y;

        System.out.println("After: x=" + x + ", y=" + y);
    }

    // Exercise 2 - Integer average
    public static void exercise2(Scanner scanner) {
        System.out.println("\n=== Exercise 2 - Integer Average ===");
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        int average = (num1 + num2) / 2;
        System.out.println("Average: " + average);
    }

    // Exercise 3 - Real numbers average
    public static void exercise3(Scanner scanner) {
        System.out.println("\n=== Exercise 3 - Real Numbers Average ===");
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        double average = (num1 + num2) / 2;
        System.out.println("Average: " + average);
    }

    // Exercise 4a - Exact average using 2.0
    public static void exercise4a(Scanner scanner) {
        System.out.println("\n=== Exercise 4a - Exact Average (divide by 2.0) ===");
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        double average = (num1 + num2) / 2.0;
        System.out.println("Exact average: " + average);
    }

    // Exercise 4b - Exact average using casting
    public static void exercise4b(Scanner scanner) {
        System.out.println("\n=== Exercise 4b - Exact Average (casting) ===");
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        double average = (double) (num1 + num2) / 2;
        System.out.println("Exact average: " + average);
    }

    // Exercise 5 - Remainder
    public static void exercise5(Scanner scanner) {
        System.out.println("\n=== Exercise 5 - Remainder ===");
        System.out.print("Enter x: ");
        int x = scanner.nextInt();
        System.out.print("Enter y: ");
        int y = scanner.nextInt();

        int remainder = x % y;
        System.out.println("Remainder: " + remainder);
    }

    // Exercise 6a - Sum of digits (direct extraction)
    public static void exercise6a(Scanner scanner) {
        System.out.println("\n=== Exercise 6a - Sum of Digits (direct) ===");
        System.out.print("Enter a 3-digit number: ");
        int number = scanner.nextInt();

        int digit1 = number / 100;
        int digit2 = (number / 10) % 10;
        int digit3 = number % 10;

        int sum = digit1 + digit2 + digit3;
        System.out.println("Sum of digits: " + sum);
    }

    // Exercise 6b - Sum of digits (loop)
    public static void exercise6b(Scanner scanner) {
        System.out.println("\n=== Exercise 6b - Sum of Digits (loop) ===");
        System.out.print("Enter a 3-digit number: ");
        int number = scanner.nextInt();

        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        System.out.println("Sum of digits: " + sum);
    }

    // Exercise 7a - Circle (if-else)
    public static void exercise7a(Scanner scanner) {
        System.out.println("\n=== Exercise 7a - Circle (if-else) ===");
        System.out.print("Enter 'c' for circumference or 'a' for area: ");
        char choice = scanner.next().toLowerCase().charAt(0);

        System.out.print("Enter radius: ");
        double radius = scanner.nextDouble();

        if (choice == 'c') {
            double circumference = 2 * Math.PI * radius;
            System.out.println("Circumference: " + circumference);
        } else if (choice == 'a') {
            double area = Math.PI * radius * radius;
            System.out.println("Area: " + area);
        } else {
            System.out.println("Invalid choice");
        }
    }

    // Exercise 7b - Circle (switch)
    public static void exercise7b(Scanner scanner) {
        System.out.println("\n=== Exercise 7b - Circle (switch) ===");
        System.out.print("Enter 'c' for circumference or 'a' for area: ");
        char choice = scanner.next().toUpperCase().charAt(0);

        System.out.print("Enter radius: ");
        double radius = scanner.nextDouble();

        switch (choice) {
            case 'C':
                double circumference = 2 * Math.PI * radius;
                System.out.println("Circumference: " + circumference);
                break;
            case 'A':
                double area = Math.PI * radius * radius;
                System.out.println("Area: " + area);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    // Exercise 8a - Time conversion (basic)
    public static void exercise8a(Scanner scanner) {
        System.out.println("\n=== Exercise 8a - Time Conversion ===");
        System.out.print("Enter seconds: ");
        int totalSeconds = scanner.nextInt();

        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;

        System.out.println(hours + ":" + minutes + ":" + seconds);
    }

    // Exercise 8b - Time conversion (formatted)
    public static void exercise8b(Scanner scanner) {
        System.out.println("\n=== Exercise 8b - Time Conversion (formatted) ===");
        System.out.print("Enter seconds: ");
        int totalSeconds = scanner.nextInt();

        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;

        System.out.printf("%d:%02d:%02d\n", hours, minutes, seconds);
    }
}