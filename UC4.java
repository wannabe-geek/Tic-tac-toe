public class UC4{

    public static void main(String[] args) {
        int slot = 7;

        System.out.println("Row: " + getRowFromSlot(slot));
        System.out.println("Column: " + getColFromSlot(slot));
    }

    // Convert slot to row index
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    // Convert slot to column index
    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }
}