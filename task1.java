import java.util.Random;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int roundsWon = 0;
        int totalAttempts = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Guess the Number game!");

        while (playAgain) {
            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("Guess the number between " + minRange + " and " + maxRange + ".");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess number : ");
                int userGuess;
                try {
                     userGuess = s.nextInt();

                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    s.nextLine(); // Consume the invalid input
                    continue;
                }
                attempts++;
                totalAttempts++;

                if (userGuess < secretNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else if (userGuess > secretNumber) {
                    System.out.println("Your guess is too high. Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts
                            + " attempts.");
                    roundsWon++;
                    break;
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The secret number was "
                            + secretNumber + ".");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = s.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        System.out
                .println("\nYou completed " + roundsWon + " round(s) with a total of " + totalAttempts + " attempts.");
        System.out.println("Thank you for playing!");

        s.close();
    }
}
