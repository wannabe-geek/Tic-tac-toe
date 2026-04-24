import java.util.Random;

public class UC2{

    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {
        tossAndAssignSymbols();
        displayTossResult();
    }

    // Toss logic
    static void tossAndAssignSymbols() {
        Random random = new Random();

        // 0 → Human starts, 1 → Computer starts
        int toss = random.nextInt(2);

        if (toss == 0) {
            isHumanTurn = true;
            humanSymbol = 'X';
            computerSymbol = 'O';
        } else {
            isHumanTurn = false;
            humanSymbol = 'O';
            computerSymbol = 'X';
        }
    }

    // Display result
    static void displayTossResult() {
        System.out.println("Toss Result:");

        if (isHumanTurn) {
            System.out.println("You won the toss!");
            System.out.println("You play first.");
        } else {
            System.out.println("Computer won the toss!");
            System.out.println("Computer plays first.");
        }

        System.out.println("Your Symbol: " + humanSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
    }
}