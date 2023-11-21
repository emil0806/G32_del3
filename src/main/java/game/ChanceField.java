package game;

public class ChanceField extends Field {

    // define constructor, must receive a location
    public ChanceField(String name, int location, String description) {
        super(name, location, description);
    }

    @Override
    public void landedOnField(Player player, Player[] players, Board board) {
        checkLocation(player, board);
        board.getDeck().drawCard(player, players, board);
    }

    @Override
    public void checkLocation(Player player, Board board) {
        if (this.getLocation() < player.getPiece().getLocation().getLocation()) {
            player.depositMoney(2);
        }
        player.getPiece().setLocation(board.getField(this.getLocation()));
    }

}
