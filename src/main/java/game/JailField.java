package game;

public class JailField extends Field {

    public JailField(String name, int location, String description) {
        super(name, location, description);
    }

    @Override
    public void landedOnField(Player player, Player[] players, Board board) {
    }

    @Override
    public void checkLocation(Player player, Board board) {
        if (this.getLocation() < player.getPiece().getLocation().getLocation()) {
            player.depositMoney(2);
            player.getPiece().setLocation(board.getField(this.getLocation()));
        }
    }
}
