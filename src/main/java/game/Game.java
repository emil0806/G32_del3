package game;

import java.util.Scanner;

public class Game {

    private Player[] players;
    private Board board = new Board();
    private Cup cup = new Cup();
    private Output output = new Output();
    private String[] pieces = new String[] { "Boat", "Car", "Dog", "Cat" };
    private int numberOfPlayers;
    private boolean hasLoser = false;
    private Scanner scanner = new java.util.Scanner(System.in);

    public void startGame() {
        output.displayRules();
        scanner.nextLine();

        while (numberOfPlayers < 2 || numberOfPlayers > 4) {
            output.enterNumberOfPlayers();
            numberOfPlayers = scanner.nextInt();
        }

        players = new Player[numberOfPlayers];

        for (int i = 0; i < players.length; i++) {
            output.enterPlayerName(i + 1);
            String name = scanner.next();
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
            output.displayScoreBoard(players);
            output.playerTurn(players[turnCount].getPlayerName());
            scanner.nextLine();
            playerTurn(players[turnCount], cup);

            if (turnCount == players.length - 1) {
                turnCount = 0;
            } else {
                turnCount += 1;
            }
        }

        if (hasLoser) {
            Player[] finalScoreList = checkWinner(players);

            output.displayScoreBoard(finalScoreList);
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
        if (!(player.getHasLost())) {
            if (player.getMoveByTypeCard()) {
                output.displayMoveToField();
                int moveToField = scanner.nextInt();
                Field nextLocation = board.getField(moveToField);
                movePlayer(player, nextLocation);
            } else {
                cup.setRollSum();
                output.displaySumOfDice(cup.getRollSum());
                int moveToField;
                if ((player.getPiece().getLocation().getLocation() + cup.getRollSum()) < 24) {
                    moveToField = player.getPiece().getLocation().getLocation() + cup.getRollSum();
                } else {
                    moveToField = (player.getPiece().getLocation().getLocation() - 24) + cup.getRollSum();
                }

                Field nextLocation = board.getField(moveToField);
                movePlayer(player, nextLocation);
            }
        } else {
            this.hasLoser = true;
        }
    }

    public void movePlayer(Player player, Field nextLocation) {

        if (nextLocation.getLocation() == 0) {
            output.displayFieldText(nextLocation);
            player.getPiece().setLocation(nextLocation);
            nextLocation.landedOnField(player, players, board);
        } else if (nextLocation.getLocation() < player.getPiece().getLocation().getLocation()) {
            output.displayFieldText(board.getField(0));
            player.depositMoney(2);
            output.displayFieldText(nextLocation);
            player.getPiece().setLocation(nextLocation);
            if (nextLocation instanceof ChanceField) {
                output.drawChanceCard(board.getDeck().getCards()[0]);
            }
            nextLocation.landedOnField(player, players, board);

        } else {
            output.displayFieldText(nextLocation);
            player.getPiece().setLocation(nextLocation);
            if (nextLocation instanceof ChanceField) {
                output.drawChanceCard(board.getDeck().getCards()[0]);
            }
            nextLocation.landedOnField(player, players, board);

        }
    }

    public Player[] sortPlayersByAge(Player[] playerList) {

        Player tempPlayer;

        for (int i = 0; i < playerList.length; i++) {
            for (int j = i + 1; j < playerList.length; j++) {
                if (playerList[i].getAge() > playerList[j].getAge()) {
                    tempPlayer = playerList[i];
                    playerList[i] = playerList[j];
                    playerList[j] = tempPlayer;
                }
            }
        }
        return playerList;
    }

    public Player[] checkWinner(Player[] playerList) {

        Player tempPlayer;

        for (int i = 0; i < playerList.length; i++) {
            if (playerList[i].getHasLost()) {
                tempPlayer = playerList[playerList.length - 1];
                playerList[playerList.length - 1] = playerList[i];
                playerList[i] = tempPlayer;
            }
        }
        for (int i = 0; i < playerList.length - 1; i++) {
            for (int j = i + 1; j < playerList.length - 1; j++) {
                if (playerList[i].getAccount().getBalance() == playerList[j].getAccount().getBalance()) {

                    PropertyField[] tempFields1 = playerList[i].getFieldsOwned();
                    int valuePlayer1 = 0;
                    PropertyField[] tempFields2 = playerList[j].getFieldsOwned();
                    int valuePlayer2 = 0;

                    for (int k = 0; k < tempFields1.length; k++) {
                        valuePlayer1 += tempFields1[k].getValue();
                    }
                    for (int h = 0; h < tempFields2.length; h++) {
                        valuePlayer2 += tempFields2[h].getValue();
                    }

                    if (valuePlayer1 < valuePlayer2) {
                        tempPlayer = playerList[i];
                        playerList[i] = playerList[j];
                        playerList[j] = tempPlayer;
                    }

                } else if (players[i].getAccount().getBalance() < playerList[j].getAccount().getBalance()) {
                    tempPlayer = playerList[i];
                    playerList[i] = playerList[j];
                    playerList[j] = tempPlayer;
                }
            }
        }
        return playerList;
    }
}
