package game;

public class MoveCard extends Card {

    private int moves;

    public MoveCard(int moves, String description) {
        super(description);
        this.moves = moves;
    }

}
