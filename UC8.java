import java.util.Random;
import java.util.Scanner;
public class UC8 {
        static char[][] board = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };

        static boolean isHumanTurn = true;
        static boolean gameOver = false;

        static char humanSymbol = 'X';
        static char computerSymbol = 'O';

        static Scanner scanner = new Scanner(System.in);
        static Random random = new Random();

        /**
         * Entry point of the program.
         * Demonstrates the structure of a continuous game loop.
         */
        public static void main(String[] args) {

            printBoard();

            while (!gameOver) {

                if (isHumanTurn) {
                    humanMove();
                } else {
                    computerMove();
                }

                printBoard();

                // Check win or draw
                if (checkWin()) {
                    gameOver = true;
                    if (isHumanTurn) {
                        System.out.println("Human wins!");
                    } else {
                        System.out.println("Computer wins!");
                    }
                } else if (checkDraw()) {
                    gameOver = true;
                    System.out.println("It's a draw!");
                } else {
                    // Switch turn
                    isHumanTurn = !isHumanTurn;
                }
            }
        }

        // Human move
        static void humanMove() {
            int row, col;

            while (true) {
                System.out.print("Enter row (0-2): ");
                row = scanner.nextInt();
                System.out.print("Enter col (0-2): ");
                col = scanner.nextInt();

                if (isValidMove(row, col)) {
                    placeMove(row, col, humanSymbol);
                    break;
                } else {
                    System.out.println("Invalid move, try again.");
                }
            }
        }

        // Computer move (random valid)
        static void computerMove() {
            while (true) {
                int slot = random.nextInt(9) + 1;
                int row = (slot - 1) / 3;
                int col = (slot - 1) % 3;

                if (isValidMove(row, col)) {
                    placeMove(row, col, computerSymbol);
                    System.out.println("Computer chose slot: " + slot);
                    break;
                }
            }
        }

        // Validate move
        static boolean isValidMove(int row, int col) {
            return row >= 0 && row < 3 &&
                    col >= 0 && col < 3 &&
                    board[row][col] == '-';
        }

        // Place move
        static void placeMove(int row, int col, char symbol) {
            board[row][col] = symbol;
        }

        // Check win
        static boolean checkWin() {
            // Rows & Columns
            for (int i = 0; i < 3; i++) {
                if (board[i][0] != '-' &&
                        board[i][0] == board[i][1] &&
                        board[i][1] == board[i][2]) return true;

                if (board[0][i] != '-' &&
                        board[0][i] == board[1][i] &&
                        board[1][i] == board[2][i]) return true;
            }

            // Diagonals
            if (board[0][0] != '-' &&
                    board[0][0] == board[1][1] &&
                    board[1][1] == board[2][2]) return true;

            if (board[0][2] != '-' &&
                    board[0][2] == board[1][1] &&
                    board[1][1] == board[2][0]) return true;

            return false;
        }

        // Check draw
        static boolean checkDraw() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == '-') {
                        return false;
                    }
                }
            }
            return true;
        }

        // Print board
        static void printBoard() {
            System.out.println();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
