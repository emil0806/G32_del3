package game;

import java.util.Scanner;

public class Game {

    private Player[] players;
    private Board board = new Board();
    private Cup cup = new Cup();
    private Output output;
    private String[] pieces = new String[] { "Boat", "Car", "Dog", "Cat" };
    private int numberOfPlayers;
    private boolean hasLoser = false;
    private Scanner scanner = new java.util.Scanner(System.in);

    public void startGame() {
        output.displayRules();

        while (numberOfPlayers < 2 || numberOfPlayers > 4) {
            output.enterNumberOfPlayers();
            scanner.nextLine();
        }

        players = new Player[numberOfPlayers];

        for (int i = 0; i < players.length; i++) {
            output.enterPlayerName(i + 1);
            String name = scanner.nextLine();
            output.enterPlayerAge(i + 1);
            int age = scanner.nextInt();
            players[i] = new Player(name, age, pieces[i], numberOfPlayers);
            output.showPieceType(pieces[i]);
            players[i].getPiece().setLocation(board.getField(0));
        }

        players = sortPlayersByAge(players);

        playGame(players);

    }

    public void playGame(Player[] players) {
        // Control game start and end
        int turnCount = 0;

        while (!(hasLoser)) {
            playerTurn(players[turnCount], cup);

            if (turnCount == players.length) {
                turnCount = 0;
            } else {
                turnCount += 1;
            }
        }

        if (hasLoser) {
            Player gameWinner;
            if (players[0].getHasLost()) {
                gameWinner = players[1];
            } else {
                gameWinner = players[0];
            }
            for (int i = 0; i < players.length; i++) {
                if (!(players[i].getHasLost())) {
                    if (players[i].getAccount().getBalance() < players[i + 1].getAccount().getBalance()) {
                        gameWinner = players[i + 1];
                    }
                }
            }
            output.displayWinner(gameWinner.getPlayerName());
        }

    }

    public void playerTurn(Player player, Cup cup) {
        if (player.getInJail()) {
            if (player.getOutOfJailCard()) {
                player.setOutOfJailCard(false);
            } else {
                player.withdrawMoney(1);
            }
        }
        if (player.getMoveByTypeCard()) {
            output.requestMoveToField();
            int moveToField = scanner.nextInt();
            Field nextLocation = board.getField(moveToField);
            movePlayer(player, nextLocation);
        } else {
            cup.setRollSum();
            output.displaySumOfDice(cup.getRollSum());
            movePlayer(player, board.getField(cup.getRollSum()));
        }

        if (player.getHasLost()) {
            this.hasLoser = true;
        }
    }

    public void movePlayer(Player player, Field nextLocation) {

        if (nextLocation.getLocation() == 0) {
            output.displayFieldText(nextLocation);
            player.getPiece().setLocation(nextLocation);
            nextLocation.landedOnField(player);
        } else if (nextLocation.getLocation() < player.getPiece().getLocation().getLocation()) {
            output.displayFieldText(board.getField(0));
            player.depositMoney(2);
            output.displayFieldText(nextLocation);
            player.getPiece().setLocation(nextLocation);
            nextLocation.landedOnField(player);
        } else {
            output.displayFieldText(nextLocation);
            player.getPiece().setLocation(nextLocation);
            nextLocation.landedOnField(player);
        }
    }

    public Player[] sortPlayersByAge(Player[] playerList) {

        Player tempPlayer;

        for (int i = 0; i < playerList.length; i++) {
            for (int j = i + 1; j < playerList.length; j++) {
                if (players[i].getAge() > playerList[j].getAge()) {
                    tempPlayer = playerList[i];
                    playerList[i] = playerList[j];
                    playerList[j] = tempPlayer;
                }
            }
        }
        return playerList;
    }
}