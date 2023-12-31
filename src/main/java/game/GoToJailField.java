package game;

public class GoToJailField extends JailField {
    private final Field jailLocation;

    public GoToJailField(String name, int location, String description, Field jailLocation) {
        super(name, location, description);
        this.jailLocation = jailLocation;
    }

    @Override
    public void landedOnField(Player player, Player[] players, Board board) {
        moveToJail(player);
    }

    private void moveToJail(Player player) {
        // TODO test me
        player.getPiece().setLocation(jailLocation);
        player.setInJail(true);
    }
}
