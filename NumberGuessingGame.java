import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0; 
        String playAgain;

        do {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0; 
            boolean guessed = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Guess the number (between 1 and 100):");

            while (!guessed) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You've guessed the number.");
                    System.out.println("It took you " + attempts + " guesses.");
                    guessed = true;
                    score++;
                } else {
                    int difference = Math.abs(userGuess - numberToGuess);

                    if (difference <= 6) {
                        System.out.println("Almost there! You're very close.");
                    } else {
                        if (userGuess < numberToGuess) {
                            System.out.println("Too low! Try again.");
                        } else {
                            System.out.println("Too high! Try again.");
                        }
                    }
                }

                if (attempts >= 10) {
                    System.out.println("You've reached the maximum attempts. The number was: " + numberToGuess);
                    System.out.println("Better luck next time!");
                    break;
                }
            }

            System.out.println("Your current score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next();
        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thank you for playing! Final score: " + score);
    }
}
