package game;

import java.util.Scanner;

public class Game {

    private Player[] players;
    private Board board;
    private Cup cup;
    private Output output;
    private String[] pieces = new String[] { "Boat", "Car", "Dog", "Cat" };
    private int numberOfPlayers;
    private Scanner scanner = new java.util.Scanner(System.in);

    public void startGame() {
        output.displayRules();

        output.enterNumOfPlayer();

        while (numberOfPlayers < 2 || numberOfPlayers > 4) {
            scanner.nextLine();
        }

        players = new Player[numberOfPlayers];

        for (int i = 0; i < players.length; i++) {
            output.enterPlayerName(i + 1);
            String name = scanner.nextLine();
            output.enterPlayerAge();
            int age = output.nextInt();
            players[i] = new Player(name, age, pieces[i]);
        }
    }

}
