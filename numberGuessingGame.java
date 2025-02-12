import javax.swing.JOptionPane;
import java.util.Random;

public class numberGuessingGame {
    public static void main(String[] args) {
        Random rm = new Random();
        String repeat;

        do {
            int number = 0;
            boolean validInput = false;

            // Loop to ensure valid integer input
            while (!validInput) {
                try {
                    number = Integer.parseInt(JOptionPane.showInputDialog("Enter a number between 1 and 10:"));
                    if (number < 1 || number > 10) {
                        JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 10.");
                    } else {
                        validInput = true;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.");
                }
            }

            int x = rm.nextInt(10) + 1;

            if (number == x) {
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the correct number.");
            } else {
                JOptionPane.showMessageDialog(null, "You guessed wrong. The correct number is " + x);
            }

            repeat = JOptionPane.showInputDialog("Do you want to play again? (y/n)");

        } while (repeat != null && repeat.equalsIgnoreCase("y"));

        JOptionPane.showMessageDialog(null, "Thanks for playing!");
    }
}
