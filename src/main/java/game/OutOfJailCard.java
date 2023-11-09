package game;

public class OutOfJailCard extends Card {

    public OutOfJailCard(String description) {
        super(description);
    }

    public void applyEffect(Player player, Player[] players) {
        storeCard(player);
    }

    public void storeCard(Player player) {
        player.setOutOfJailCard(true);
    }
}
