package game;

public class MoveByTypeCard extends Card {

    private String type;

    public MoveByTypeCard(String type, String description) {
        super(description);
        this.type = type;
    }

    public void applyEffect(Player player, Player[] players, Board board) {
        storeCard(players);
    }

    public void storeCard(Player[] players) {
        for (int i = 0; i < players.length; i++) {
            if (players[i].getPiece().getType().equals(type)) {
                players[i].setMoveByTypeCard(true);
            }
        }
    }
}
