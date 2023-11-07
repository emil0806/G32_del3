package game;

public class ChanceField extends Field {
    @Override public void landedOnField(Player player) {
    drawCard(player);
    }
//define constructor, must receive a location
    public ChanceField(int location)
    {super("ChanceField",location, "Chance field");}
}
