import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int secretNumber = random.nextInt(max - min + 1) + min;
        int guess = 0;
        int numTries = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + min + " and " + max + ".");
        
        while (guess != secretNumber) {
            System.out.print("Guess a number: ");
            try {
                guess = scanner.nextInt();
                numTries++;

                if (guess < secretNumber) {
                    System.out.println("Too low!");
                } else if (guess > secretNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + numTries + " tries.");
                }
            } catch (Exception e) {
                // If input is not an integer, prompt user to enter a valid input
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear scanner buffer
            }
        }
    }
}
