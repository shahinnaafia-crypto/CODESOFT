// Author: Shahin Naafia S
// College: Sona College of Technology
// Internship: CodSoft Java Development Internship
// Task 1: Number Guessing Game

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        Random randomizer = new Random();
        int playerScore = 0;
        int roundCount = 0;
        int maxTries = 5;

        System.out.println("*********************************************");
        System.out.println("   WELCOME TO SHAHIN'S NUMBER GUESSING GAME  ");
        System.out.println("*********************************************");

        while (true) {
            int secretNum = randomizer.nextInt(50) + 1;
            int triesLeft = maxTries;
            boolean hasWon = false;
            roundCount++;

            System.out.println("\n--- Round " + roundCount + " Started ---");
            System.out.println("Guess a number between 1 and 50!");
            System.out.println("You have " + maxTries + " chances.");

            while (triesLeft > 0) {
                System.out.print("\nYour Guess: ");
                int playerGuess = inputReader.nextInt();
                triesLeft--;

                if (playerGuess == secretNum) {
                    System.out.println("Correct! Well done Shahin!");
                    playerScore = playerScore + (triesLeft + 1) * 5;
                    hasWon = true;
                    break;
                } else if (playerGuess < secretNum) {
                    System.out.println("Too small! Try a bigger number.");
                    System.out.println("Chances left: " + triesLeft);
                } else {
                    System.out.println("Too big! Try a smaller number.");
                    System.out.println("Chances left: " + triesLeft);
                }
            }

            if (!hasWon) {
                System.out.println("Better luck next time! The number was: " + secretNum);
            }

            System.out.println("Your Score So Far: " + playerScore);
            System.out.print("\nDo you want to play another round? (yes / no): ");
            String playAgain = inputReader.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\n*********************************************");
        System.out.println("  GAME OVER!");
        System.out.println("  Total Rounds Played : " + roundCount);
        System.out.println("  Your Final Score    : " + playerScore);
        System.out.println("*********************************************");
        inputReader.close();
    }
}