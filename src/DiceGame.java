import java.io.Console;
import java.util.*;

public class DiceGame {

    private static Scanner reader = new Scanner(System.in);
    private static DiceGame game = null;
    private static int numberOfPlayer;
    private static HashMap<String, String> players = new HashMap<String, String>();


    public static void main(String[] args) {

        System.out.println("\n!!!! Welcome to the Sticks Game !!!!");

        try {
            game = new DiceGame();
            game.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void start() {
        try {
            Referee referee = new Referee();
            getPlayers();
            System.out.println();
            players.forEach((name, type) -> System.out.println("Player name : " + name + " / Type :" + type));
            referee.init(players);
            referee.conductGame();
            referee.announceWinner();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void getPlayers() {

        try {
            System.out.println("How many players we have(2-4) : ");
            numberOfPlayer = reader.nextInt();
            if (2 <= numberOfPlayer && numberOfPlayer <= 4) {
                System.out.println("C : Computer player /  H : Human player");
                String playerType = "C";
                String playerName = "player";
                int index = 0;

                for (index = 0; index < numberOfPlayer; index++) {
                    System.out.println("Player " + (index + 1) + " type(H/C) : ");
                    playerType = reader.next();
                    while(!(playerType.equals("H")) && !(playerType.equals("C"))) {
                        System.out.println("Invalid type!! Enter valid type : ");
                        playerType = reader.next();
                    }

                    System.out.println("Player " + (index + 1) + " name : ");
                    playerName = reader.next();
                    players.put(playerName, playerType);
                }
            } else {
                System.out.println("Invalid input !!!");
                getPlayers();
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input !!!");
            reader.hasNextInt(); // clears the buffer
        }

    }

}
