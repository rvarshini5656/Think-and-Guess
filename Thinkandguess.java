import java.util.Random;
import java.util.Scanner;

class Game1 {
    private int noOfGuesses = 0;
    public int inputNo;
    private int randomNumber;
    
    // Constructor initializes a random number between 1 and 100
    public Game1() {
        Random rand = new Random();
        int upperBound = 100;
        randomNumber = rand.nextInt(upperBound) + 1; // Random number from 1 to 100
    }

    // Method to take user input
    public void takeUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your guess (between 1 and 100): ");
        while (true) {
            try {
                inputNo = sc.nextInt();
                if (inputNo < 1 || inputNo > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next(); // Clear invalid input
            }
        }
    }

    // Method to get the number of guesses
    public int getNoOfGuesses() {
        return noOfGuesses;
    }

    // Method to check if the guess is correct
    public boolean checkGuess() {
        noOfGuesses++;
        if (inputNo == randomNumber) {
            System.out.println("Congratulations! 🎉 You guessed the correct number: " + randomNumber);
            System.out.println("It took you " + noOfGuesses + " attempts.");
            return true;
        } else if (inputNo > randomNumber) {
            System.out.println("Your guess is too high. Try again!");
        } else {
            System.out.println("Your guess is too low. Try again!");
        }
        return false;
    }

    // Method to reset the game for replay
    public void resetGame() {
        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1;
        noOfGuesses = 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;
        
        while (playAgain) {
            Game1 game = new Game1();
            System.out.println("Welcome to the Guessing Game! 🎮");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("Can you guess what it is?");

            boolean isCorrect = false;
            while (!isCorrect) {
                game.takeUserInput();
                isCorrect = game.checkGuess();
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = sc.next();
            if (response.equalsIgnoreCase("no")) {
                playAgain = false;
                System.out.println("Thank you for playing! Goodbye 👋");
            } else {
                game.resetGame(); // Reset the game if user wants to play again
                System.out.println("\nStarting a new round...\n");
            }
        }

        sc.close();
    }
}
