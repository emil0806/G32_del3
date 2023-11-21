package game;

public class RegularField extends Field {

    public RegularField(String name, int location, String description) {
        super(name, location, description);
    }

    public void landedOnField(Player player, Player[] players, Board board) {
        checkLocation(player, board);
    }

    public void checkLocation(Player player, Board board) {
        if (this.getLocation() < player.getPiece().getLocation().getLocation()) {
            player.depositMoney(2);
            player.getPiece().setLocation(board.getField(this.getLocation()));
        }
    }
}
