package game;

public class MoveToFieldCard extends Card {

    private int location;

    public MoveToFieldCard(String description, int location) {
        super(description);
        this.location = location;
    }

    public void applyEffect(Player player, Player[] players, Board board) {
        moveToField(player, board);
    }

    public void moveToField(Player player, Board board) {
        Field nextLocation = board.getField(this.location);
        player.getPiece().setLocation(nextLocation);
    }
}
