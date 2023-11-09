package game;

public class MoneyCard extends Card {

    private int amount;
    private boolean fromBank;

    public MoneyCard(String description, int amount, boolean fromBank) {
        super(description);
        this.amount = amount;
        this.fromBank = fromBank;
    }

    public void applyEffect(Player player, Player[] players) {
        if (this.fromBank) {
            if (this.amount > 0) {
                player.getAccount().deposit(this.amount);
            } else {
                player.getAccount().withdraw(this.amount);
            }
        } else {
            player.getAccount().withdraw(this.amount * (players.length - 1));
            for (int i = 0; i < players.length; i++) {
                if (!(players[i].getPlayerName().equals(player.getPlayerName()))) {
                    players[i].getAccount().deposit(this.amount);
                }
            }
        }
    }

}
