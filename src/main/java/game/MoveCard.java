package game;

public class MoveCard extends Card {

    private int moves;

    public MoveCard(String description, int moves) {
        super(description);
        this.moves = moves;
    }

    public void applyEffect(Player player, Player[] players, Board board) {
        int currentLocation = player.getPiece().getLocation().getLocation();
        int nextLocation = currentLocation + moves;
        Field nextField = board.getField(nextLocation);
        player.getPiece().setLocation(nextField);
        player.getPiece().getLocation().landedOnField(player, players, board);
    }

}
