package game;

public class MoveByTypeCard extends Card {

    private String type;

    public MoveByTypeCard(String type, String description) {
        super(description);
        this.type = type;
    }

    public void applyEffect(Player player) {
        storeCard(player);
    }

    public void storeCard(Player player) {
        player.setMoveByTypeCard(true);
    }
}
