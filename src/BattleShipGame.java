import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
public class BattleShipGame {
    public static void main(String[] args) {
    BattleShip[] battleships = createBattleships();
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> targets = new ArrayList<>();

    for (BattleShip battleShip : battleships) {
        targets.addAll(Arrays.asList(battleShip.getBoardLocations()));
    }
    int attempts = 0;
    while (!targets.isEmpty()) {
        String guess = getUserInput("Select A Target..");
        attempts++;

        if (targets.remove(guess)) {
            System.out.println("Confirmed Hit!");

            for (BattleShip battleShip : battleships) {
                if (battleShip.checkUserGuess(guess) && battleShip.battleshipSunk()) {
                    System.out.println("You Sank The " + battleShip.getName() + "!");
                }
            }

        } else {
            System.out.println("You Missed!");
        }
    }
    System.out.println("Congratulations! You Sank All The Battleships In" + attempts + " Attempts.");
    }
    static String getUserInput(String prompt) {
        System.out.println(prompt + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }
    static BattleShip[] createBattleships() {
        return new BattleShip[] {
                new BattleShip("Law", new String[]{"a4", "a5", "a6"}),
                new BattleShip("Julia", new String[]{"b2", "b3", "b4"}),
                new BattleShip("Nina", new String[]{"c5", "c6", "c7"})

        };
    }
}
