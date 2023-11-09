package game;

public class MoveCard extends Card {

    private int moves;

    public MoveCard(int moves, String description) {
        super(description);
        this.moves = moves;
    }

    public void applyEffect(Player player, Player[] players, Board board) {
        int currentLocation = player.getPiece().getLocation().getLocation();
        int nextLocation =  currentLocation + moves;
        player.getPiece()
    }

}
