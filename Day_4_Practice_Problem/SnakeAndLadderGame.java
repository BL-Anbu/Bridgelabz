package Day_4_Practice_Problem;


import java.util.Map;
import java.util.Random;
import java.util.Scanner;

//  UC1 --- Snake and Ladder game played with single player at start position 0
//  UC2 --- The Player rolls the die to get a number between 1 to 6.b
//              - Use ((RANDOM)) to get the number between 1 to 6
//  UC3 --- The Player then checks for a Option. They are No Play,Ladder or Snake.
//                  - Use ((RANDOM)) to check for Options
//                  - In Case of No Play the player stays in the same position
//                  - In Case of Ladder the player moves ahead by the number of position received in the die
//                  - In Case of Snake the player moves behind by the number of position recived in the dice
//      UC4 --- Repeat till the Player reaches the winning position 100.
//                  - Note In case the player position moves below 0, then the player restarts from 0
//      UC5 --- Ensure the player gets to exact winning position 100.
//                  - Note in case the player position go above 100, the player stays in the same previous
//                      position till the player gets the exact number that adds to 100
//      UC6 --- Report the number of times the dice was played to win the game and also the position
//              after every die role
//      UC7 --- Play the game with 2 Palyer
//              In this case if a Player gets a Ladder then plays again.
//              Finally report which Player won the game
public class SnakeAndLadderGame {

    private int postion = 0;
    private static final int MAX_POINT = 100;
    private static final Random randomNumber = new Random();
    private static final Scanner sc = new Scanner(System.in);
    private static final Map<Integer, Integer> snakesMap = Map.ofEntries(Map.entry(4, 1), Map.entry(9, 2), Map.entry(15, 5), Map.entry(20, 10), Map.entry(26, 12), Map.entry(31, 14), Map.entry(37, 17), Map.entry(42, 21), Map.entry(48, 30), Map.entry(53, 33), Map.entry(59, 40), Map.entry(64, 43), Map.entry(70, 50), Map.entry(75, 56), Map.entry(81, 61), Map.entry(86, 66), Map.entry(92, 72), Map.entry(97, 78));
    static Map<Integer, Integer> ladderMap = Map.of(3, 22, 8, 26, 13, 29, 22, 41, 28, 55, 34, 67, 44, 79, 50, 91);

    public static void main(String[] args) {

        System.out.println("---------WELCOME TO SNAKE AND LADDER GAME---------");
        boolean run = true;
        while (run) {
            multiPlayerMethod();
            try {
                System.out.println("You want rematch type Y/y");
                String ch = sc.nextLine();
                if (ch == "Y" || ch == "y") {
                    continue;
                } else {
                    run = false;

                }
            } catch (Exception e) {
                System.out.print("Exiting.............");
                run = false;
            }
        }
    }

    private static void multiPlayerMethod() {

        System.out.println("\n--- Two Player Mode ---");
        int pos1 = 0;
        int pos2 = 0;
        int diceCount = 0;
        int currentPlayer = 1;

        System.out.println("Players take turns. Press Enter to roll. If you type 'q' you return to menu.");

        while (pos1 != MAX_POINT && pos2 != MAX_POINT) {
            System.out.print("Player " + currentPlayer + " - Press Enter to roll: ");
            String line = sc.nextLine();
            if (line != null && line.equalsIgnoreCase("q")) {
                System.out.println("Returning to main menu.");
                return;
            }
            int dice = randomNumber.nextInt(6) + 1;
            diceCount++;
            System.out.println("Player " + currentPlayer + " rolled: " + dice);
            if (currentPlayer == 1) {
                if (pos1 + dice <= MAX_POINT) {
                    pos1 += dice;
                } else {
                    System.out.println("Move would exceed " + MAX_POINT + ". Stay at: " + pos1);
                }
                if (ladderMap.containsKey(pos1)) {
                    int to = ladderMap.get(pos1);
                    System.out.println("Player 1 found a Ladder! " + pos1 + " -> " + to);
                    pos1 = to;
                } else if (snakesMap.containsKey(pos1)) {
                    int to = snakesMap.get(pos1);
                    System.out.println("Player 1 hit a Snake! " + pos1 + " -> " + to);
                    pos1 = to;
                } else {
                    currentPlayer = 2;
                }

                System.out.println("Player 1 position: " + pos1);
            } else { // player 2
                if (pos2 + dice <= MAX_POINT) {
                    pos2 += dice;
                } else {
                    System.out.println("Move would exceed " + MAX_POINT + ". Stay at: " + pos2);
                }

                if (ladderMap.containsKey(pos2)) {
                    int to = ladderMap.get(pos2);
                    System.out.println("Player 2 found a Ladder! " + pos2 + " -> " + to);
                    pos2 = to;
                } else if (snakesMap.containsKey(pos2)) {
                    int to = snakesMap.get(pos2);
                    System.out.println("Player 2 hit a Snake! " + pos2 + " -> " + to);
                    pos2 = to;
                } else {
                    currentPlayer = 1;
                }

                System.out.println("Player 2 position: " + pos2);
            }

            System.out.println("Total dice rolls: " + diceCount);
            System.out.println("-------------------------------");
        }

        if (pos1 == MAX_POINT) {
            System.out.println("Player 1 wins! Reached " + MAX_POINT + " in " + diceCount + " rolls.");
        } else {
            System.out.println("Player 2 wins! Reached " + MAX_POINT + " in " + diceCount + " rolls.");
        }
    }


}
