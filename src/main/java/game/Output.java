package game;

public class Output {

    OutputBoard outputBoard = new OutputBoard();

    // Display game rules at the beginning of the game
    public void displayRules() {
        System.out.println("Welcome to Monopoly Junior!\n" +
                "Monopoly Junior is a two to four-player game where the objective is to bankrupt your opponents.\n" +
                "The game ends when a player cannot pay their debts, and the player with the most money at that time wins.\n"
                +
                "The board features 24 diverse fields with various effects on players.\n\n" +
                "There can be between 2 to 4 players. \n" +
                "The balance is given in Monopoly cash and varies depending on the number of players as follows:\n" +
                "2 players: 20 Monopoly cash each.\n" +
                "3 players: 18 Monopoly cash each.\n" +
                "4 players: 16 Monopoly cash each.\n" +
                "In this game, you need to enter your age. The youngest player starts.\n\n");

        System.out.println(
                "Monopoly Junior er et spil for 2-4 spillere, hvor målet er at have flest penge, når spillet er slut\n"
                        +
                        "Spillet er slut, når en spiller ikke kan betale, og vinderen er den med flest penge.\n"
                        +
                        "Brættet har 24 felter, som hver har en effekt på en spiller.\n\n" +
                        "Pengebeholdningen består af Monopoly penge\n" +
                        "2 spillere: 20 Monopoly penge hver.\n" +

                        "3 spillere: 18 Monopoly penge hver.\n" +
                        "4 spillere: 16 Monopoly penge hver.\n" +
                        "Den yngste spiller starter.\n\n");

        System.out.println("Press ENTER to start the game. / Tryk ENTER for at starte spillet");

    }

    // Prompt for the number of players
    public void enterNumberOfPlayers() {
        System.out.print("Please enter the number of players: ");
    }

    // Prompt for player names
    public void enterPlayerName(int playerNumber) {
        System.out.print("Please enter the name of player " + playerNumber + ": ");
    }

    // Prompt for player age to determine who starts
    public void enterPlayerAge(int playerNumber) {
        System.out.print("Please enter the age of player " + playerNumber + ": ");
    }

    public void playerTurn(String playerName) {
        System.out.println(playerName + ", press ENTER to start your turn");
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
    public void displayScoreBoard(Player[] players) {

        outputBoard.showBoard(players);
    }

    public void displayBalance(String playerName, int amount) {
        System.out.println(playerName + " has " + amount);
    }

    // Display Field name
    public void displayFieldText(Field fieldText) {
        System.out.println(fieldText.getDescription());
    }

    // Display property status message if the field has an owner
    public void displayHasOwner(PropertyField field) {
        System.out.println(field.getName() + " has an owner, and you need to pay rent " + field.getValue());
    }

    // Display property status message if the field doesn't have an owner
    public void displayHasNoOwner(PropertyField field) {
        System.out.println(field.getName() + " has no owner. You need to buy the field for " + field.getValue());
    }

    // Display Player has two properties
    public void displayHasTwoProperties(PropertyField field) {
        System.out.println(
                field.getName() + " owns two of the same colors " + field.getValue() + " You need to pay double rent.");
    }

    // Display equal score
    public void displayEqualScore(String playerName) {
        System.out.println(
                "The score is equal! Therefore, the winner will be identified based on the combined value of your properties and Monopoly Cash");
    }

    // Draw chancecard
    public void drawChanceCard(Card chanceCard) {
        System.out.println(chanceCard.getDescription());
    }

    // Request move to field
    public void displayMoveToField() {
        System.out.println(
                "You have a MoveByTypeCard. Please enter a location on the board you'd like to go between 0 - 23");
    }

    public void readyForGame() {
        System.out.println("\n READY, SET, GOOOOO! \n");
    }
}
