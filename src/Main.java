import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        while (playAgain) {
            char playerA, playerB;
            do {
                System.out.print("Player A, enter your move (R, P, S): ");
                playerA = scanner.next().toUpperCase().charAt(0);
                if (playerA != 'R' && playerA != 'P' && playerA != 'S') {
                    System.out.println("You entered an invalid move. Please enter R, P, or S.");
                }
            } while (playerA != 'R' && playerA != 'P' && playerA != 'S');
            do {
                System.out.print("Player B, enter your move (R, P, S): ");
                playerB = scanner.next().toUpperCase().charAt(0);
                if (playerB != 'R' && playerB != 'P' && playerB != 'S') {
                    System.out.println("You entered an invalid move. Please enter R, P, or S.");
                }
            } while (playerB != 'R' && playerB != 'P' && playerB != 'S');
            if (playerA == playerB) {
                System.out.println("It's a Tie! " + getMoveName(playerA) + " vs " + getMoveName(playerB));
            } else if ((playerA == 'R' && playerB == 'S') ||
                    (playerA == 'P' && playerB == 'R') ||
                    (playerA == 'S' && playerB == 'P')) {
                System.out.println(getMoveResult(playerA, playerB) + " - Player A Wins!");
            } else {
                System.out.println(getMoveResult(playerB, playerA) + " - Player B Wins!");
            }

            System.out.print("Do you want to play again? (Y/N): ");
            playAgain = scanner.next().trim().equalsIgnoreCase("Y");
        }
        scanner.close();
    }
    static String getMoveName(char move) {
        return switch (move) {
            case 'R' -> "Rock";
            case 'P' -> "Paper";
            case 'S' -> "Scissors";
            default -> "";
        };
    }
    static String getMoveResult(char winner, char loser) {
        if (winner == 'R' && loser == 'S') return "Rock breaks Scissors";
        if (winner == 'P' && loser == 'R') return "Paper covers Rock";
        if (winner == 'S' && loser == 'P') return "Scissors cuts Paper";
        return "";
    }
}
