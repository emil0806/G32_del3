package game;

public class Output {

    // Display game rules at the beginning of the game
    public void displayRules() {
        String[] rules = {
            "Welcome to Monopoly Junior!",
            "Monopoly Junior is a two to four-player game where the objective is to bankrupt your opponents.",
            "The game ends when a player cannot pay their debts, and the player with the most money at that time wins.",
            "The board features 24 diverse fields with various effects on players.",
            "",
            "The balance is given in Monopoly cash and varies depending on the number of players as follows:",
            "2 players: 20 Monopoly cash each.",
            "3 players: 18 Monopoly cash each.",
            "4 players: 16 Monopoly cash each.",
            "",
            "Press ENTER to start the game."
        };
        printLines(rules); // Calls the helper method to print the game rules.
    }

    // Helper method to print an array of lines
    private void printLines(String[] lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }

    // Prompt for the number of players
    public void enterNumberOfPlayers() {
        System.out.println("Please enter the number of players:");
    }

    // Prompt for player names
    public void enterPlayerName(int playerNumber) {
        System.out.println("Please enter the name of player " + playerNumber + ":");
    }

    // Prompt for player age to determine who starts
    public void enterPlayerAge(int playerNumber) {
        System.out.println("Please enter the age of player " + playerNumber + ":");
    }

    // Prompts a player to roll the dice
    public void playerRollDice(String playerName) {
        System.out.println(playerName + ", press ENTER to roll the dice");
    }

    // Display the sum of the dice
    public void displaySumOfDice(int sum) {
        System.out.println("The sum of the dice: " + sum);
    }

    // Display the winner of the game
    public void displayWinner(String playerName) {
        System.out.println("The winner is: " + playerName);
    }

    // Display loser message
    public void displayLooserMessage(String playerName) {
        System.out.println(playerName + " has lost, and the game has ended");
    }

    // Designate a piece type to a player
    public void showPieceType(String pieceType) {
        System.out.println("You are the " + pieceType);
    }

    // Display balance
    public void displayBalance(String playerName, int amount) {
        System.out.println(playerName + " has " + amount);
    }

    // Display Field name
    public void displayFieldText(String fieldText) {
        System.out.println(fieldText);
    }

    // Display property status message if the field has an owner
    public void displayHasOwner(PropertyField field) {
        System.out.println(field.getName() + " has an owner, and you need to pay " + field.getValue());
    }

    // Display property status message if the field doesn't have an owner
    public void displayHasNoOwner(PropertyField field) {
        System.out.println(field.getName() + " has no owner. You need to buy the field for " + field.getValue());
    }
}
