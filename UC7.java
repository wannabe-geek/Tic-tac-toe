import java.util.Random;
public class UC7 {

        static char[][] board = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };

        static char computerSymbol = 'O';

        /**
         * Entry point of the program. Triggers the computer move.
         */
        public static void main(String[] args) {
            computerMove();
            printBoard();
        }

        /**
         * Generates random slot values until a valid move is found,
         * then places the computer symbol on the board.
         */
        static void computerMove() {
            Random random = new Random();

            while (true) {
                int slot = random.nextInt(9) + 1; // 1–9

                int row = (slot - 1) / 3;
                int col = (slot - 1) % 3;

                if (isValidMove(row, col)) {
                    placeMove(row, col, computerSymbol);
                    System.out.println("Computer chose slot: " + slot);
                    break;
                }
            }
        }

        /**
         * Checks if the move is valid (within bounds + empty cell)
         */
        static boolean isValidMove(int row, int col) {
            return row >= 0 && row < 3 &&
                    col >= 0 && col < 3 &&
                    board[row][col] == '-';
        }

        /**
         * Places the symbol on the board
         */
        static void placeMove(int row, int col, char symbol) {
            board[row][col] = symbol;
        }

        /**
         * Prints the board
         */
        static void printBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
