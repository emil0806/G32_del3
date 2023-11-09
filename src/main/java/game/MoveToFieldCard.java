package game;

public class MoveToFieldCard extends Card {

    private Field field;

    public MoveToFieldCard(String description, Field field) {
        super(description);
        this.field = field;
    }

    public void applyEffect(Player player, Player[] players, Board board) {
        moveToField(player);
    }

    public void moveToField(Player player) {
        player.getPiece().setLocation(this.field);
    }
}
