package game;

public class JailField extends Field {

    public JailField(String name, int location, String description) {
        super(name, location, description);
    }

    @Override
    public void landedOnField(Player player, Player[] players, Board board) {
    }
}