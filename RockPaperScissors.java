import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int playerScore = 0;
        int computerScore = 0;

        String[] choices = {"Rock", "Paper", "Scissors"};
        boolean playAgain = true;

        System.out.println("Welcome to Rock-Paper-Scissors!");

        while (playAgain) {
            System.out.println("\nChoose your move: Rock, Paper, or Scissors.");
            System.out.print("Your choice: ");
            String playerMove = scanner.nextLine().trim().toLowerCase();

            // Validate player input
            if (!playerMove.equals("rock") && !playerMove.equals("paper") && !playerMove.equals("scissors")) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            // Computer's move
            int computerIndex = random.nextInt(3); // Generate random number between 0 and 2
            String computerMove = choices[computerIndex].toLowerCase();

            System.out.println("Computer chose: " + choices[computerIndex]);

            // Determine winner
            if (playerMove.equals(computerMove)) {
                System.out.println("It's a tie!");
            } else if ((playerMove.equals("rock") && computerMove.equals("scissors")) ||
                       (playerMove.equals("paper") && computerMove.equals("rock")) ||
                       (playerMove.equals("scissors") && computerMove.equals("paper"))) {
                System.out.println("You win this round!");
                playerScore++;
            } else {
                System.out.println("Computer wins this round!");
                computerScore++;
            }

            // Display score
            System.out.println("Score: Player " + playerScore + " - Computer " + computerScore);

            // Ask if the player wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nThanks for playing! Final Score: Player " + playerScore + " - Computer " + computerScore);
        scanner.close();
    }
}
