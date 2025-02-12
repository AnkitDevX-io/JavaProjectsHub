import java.util.Scanner;

public class simple_calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char repeat;

        do {
            System.out.println("***** Simple Calculator *****\n");
            System.out.println("\t1. Addition\n\t2. Subtraction\n\t3. Multiplication\n\t4. Division\n\t5. Modulus\n\t6. Factorial\n");
            System.out.print("\tEnter your choice: ");
            int choice = sc.nextInt();

            if (choice == 6) {
                factorialNum();
            } else if (choice >= 1 && choice <= 5) {
                System.out.print("\tEnter first number: ");
                int x = sc.nextInt();
                System.out.print("\tEnter second number: ");
                int y = sc.nextInt();

                switch (choice) {
                    case 1 -> sumTwoNumber(x, y);
                    case 2 -> subtractTwoNumber(x, y);
                    case 3 -> multTwoNumber(x, y);
                    case 4 -> divTwoNumber(x, y);
                    case 5 -> modTwoNumber(x, y);
                }
            } else {
                System.out.println("\tYou entered an invalid number! Please enter a valid number.");
            }

            System.out.print("\nDo you want to perform another calculation? (y/n): ");
            repeat = sc.next().charAt(0);
            System.out.println();

        }
        while (repeat == 'y' || repeat == 'Y');

        System.out.println("Thanks for using the calculator! 😊");
        sc.close();
    }

    public static void sumTwoNumber(int x, int y) {
        System.out.println("\tSum is " + (x + y) + ".");
    }

    public static void subtractTwoNumber(int x, int y) {
        System.out.println("\tSubtraction is " + (x - y) + ".");
    }

    public static void multTwoNumber(int x, int y) {
        System.out.println("\tMultiplication is " + (x * y) + ".");
    }

    public static void divTwoNumber(int x, int y) {
        if (y == 0) {
            System.out.println("\tDivision by zero is not possible, please enter another number.");
        } else {
            System.out.println("\tDivision is " + (x / y) + ".");
        }
    }

    public static void modTwoNumber(int x, int y) {
        System.out.println("\tModulus is " + (x % y) + ".");
    }

    public static void factorialNum() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\tEnter a number: ");
        int f = sc.nextInt();
        int fact = 1;
        for (int i = 1; i <= f; i++) {
            fact *= i;
        }
        System.out.println("\tFactorial of " + f + " is " + fact + ".");
    }
}
