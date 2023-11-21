package game;

public class MoveToFieldCard extends Card {

    private int location;

    public MoveToFieldCard(String description, int location) {
        super(description);
        this.location = location;
    }

    public void applyEffect(Player player, Player[] players, Board board) {
        moveToField(player, players, board);
    }

    public void moveToField(Player player, Player[] players, Board board) {
        Field nextLocation = board.getField(this.location);
        nextLocation.landedOnField(player, players, board);
    }
}
