public class UC5 {
    static char[][] board = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
    };

    public static void main(String[] args) {
        System.out.println(isValidMove(1, 1)); // true (valid move)
        System.out.println(isValidMove(3, 0)); // false (out of bounds)
        System.out.println(isValidMove(0, 0)); // true (empty)

        board[0][0] = 'X';
        System.out.println(isValidMove(0, 0)); // false (already occupied)
        }
        static boolean isValidMove(int row, int col) {

            // Boundary check (0–2)
            if (row < 0 || row > 2 || col < 0 || col > 2) {
                return false;
            }

            // Check if cell is empty
            if (board[row][col] != '-') {
                return false;
            }

            return true;
        }
    }
}
