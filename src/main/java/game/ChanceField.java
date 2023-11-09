package game;

public class ChanceField extends Field {

    // define constructor, must receive a location
    public ChanceField(String name, int location, String description) {
        super(name, location, description);
    }

    @Override
    public void landedOnField(Player player, Player[] players, Board board) {
        board.getDeck();

        drawCard(player, players);
    }
}
