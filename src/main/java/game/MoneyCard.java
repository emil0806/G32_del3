package game;

public class MoneyCard extends Card {

    private int amount;
    private boolean fromBank;

    public MoneyCard(String description, int amount, boolean fromBank) {
        super(description);
        this.amount = amount;
        this.fromBank = fromBank;
    }

    public void applyEffect(Player player, Player[] players, Board board) {
        if (this.fromBank) {
            if (this.amount > 0) {
                player.depositMoney(this.amount);
            } else {
                player.withdrawMoney(Math.abs(this.amount));
            }
        } else {
            player.depositMoney(this.amount * (players.length - 1));
            for (int i = 0; i < players.length; i++) {
                if (!(players[i].getPlayerName().equals(player.getPlayerName()))) {
                    players[i].withdrawMoney(this.amount);
                }
            }
        }
    }

}
