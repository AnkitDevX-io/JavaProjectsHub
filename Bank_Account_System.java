import java.util.Scanner;

public class Bank_Account_System {
    static long balance = 0; // Shared balance for all transactions
    static Scanner sc = new Scanner(System.in); // Global Scanner to avoid multiple instances

    public static void simpleDeposit() {
        System.out.println("\n💰 How much money do you want to deposit?");
        System.out.println("1. ₹10,000 \t 2. ₹20,000");
        System.out.println("3. ₹50,000 \t 4. Other Amount");
        System.out.print("Enter your choice: ");

        byte choice = sc.nextByte();
        int rs1 = 10000, rs2 = 20000, rs3 = 50000;
        long rs = 0;

        switch (choice) {
            case 1 -> balance += rs1;
            case 2 -> balance += rs2;
            case 3 -> balance += rs3;
            case 4 -> {
                System.out.print("Enter Amount: ₹");
                rs = sc.nextLong();
                balance += rs;
            }
            default -> {
                System.out.println("❌ Invalid choice! Please try again.");
                return;  // Exit the method if invalid input
            }
        }

        System.out.println("✅ ₹" + (choice == 4 ? rs : (choice == 1 ? rs1 : choice == 2 ? rs2 : rs3)) +
                " successfully added to your account! 😊");
        checkBalance(); // Show updated balance
    }

    public static void withdrawalCash() {
        System.out.println("\n💸 Enter amount to withdraw: ₹");
        long amount = sc.nextLong();

        if (amount > balance) {
            System.out.println("❌ Insufficient balance! Current Balance: ₹" + balance);
        } else {
            balance -= amount;
            System.out.println("✅ ₹" + amount + " withdrawn successfully!");
        }
    }

    public static void checkBalance() {
        System.out.println("\n💳 Your current bank balance is: ₹" + balance);
    }

    public static void main(String[] args) {
        System.out.println("----- 🏦 Welcome to SBL Bank System ----\n");

        String[] customerName = {
                "ANKIT SURESH RATHOD",
                "MAHESH DEVIDAS JADHAO",
                "VISHAL SURESH RATHOD",
                "SUMIT BIBICHAND JADHAO",
                "NIKHIL ULHAS RATHOD"
        };

        System.out.print("👤 Enter your full name : ");
        String customerName1 = sc.nextLine().trim();

        boolean found = false;

        for (String name : customerName) {
            if (customerName1.equalsIgnoreCase(name)) {
                found = true;
                System.out.println("\n✅ Welcome back, " + customerName1 + "! 😊");

                boolean continueBanking = true;
                while (continueBanking) {
                    System.out.println("\n🔹 Choose an operation:");
                    System.out.println("1️⃣ Deposit Cash");
                    System.out.println("2️⃣ Withdraw Cash");
                    System.out.println("3️⃣ Check Balance");
                    System.out.println("4️⃣ Exit");
                    System.out.print("Enter your choice: ");
                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1 -> simpleDeposit();
                        case 2 -> withdrawalCash();
                        case 3 -> checkBalance();
                        case 4 -> {
                            System.out.println("\n🙏 Thank you for using SBL Bank! Have a great day! 😊");
                            continueBanking = false; // Exit the loop
                        }
                        default -> System.out.println("❌ Invalid choice! Please select a valid option.");
                    }
                }
                break; // Exit loop after successful login
            }
        }

        if (!found) {
            System.out.println("❌ User not found. Please check your name and try again.");
        }

        sc.close(); // Close the Scanner at the end
    }
}
