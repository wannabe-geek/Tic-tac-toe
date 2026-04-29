public class UC10 {
        static char[][] board = new char[3][3];

        /**
         * Entry point of the program. Tests draw detection logic.
         */
        public static void main(String[] args) {

            // Fill board completely (simulate draw)
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = 'X'; // no empty cells
                }
            }

            System.out.println(isDraw()); // Expected: true
        }

        /**
         * Traverses the board to check for any remaining empty cells.
         * Output: true if draw, false otherwise.
         */
        static boolean isDraw() {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    if (board[r][c] == '\0') { // correct empty check
                        return false;
                    }
                }
            }
            return true;
        }
    }