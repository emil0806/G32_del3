package game;

public class GoToJailField extends JailField{
    private Field jailLocation;
    public GoToJailField(String name, int location, String description,Field jailLocation) {
        super(name, location, description);}

  @override  public void landedOnField(Player player){moveToJail(player);}
    private void moveToJail(Player player){
        player.Piece.move.setLocation(jailLocation);
        player.setInJail(true);}
}
