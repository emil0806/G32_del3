package game;

public class PropertyField extends Field {

    private int value;
    private String color;
    private owner Player;
    private boolean hasOwner;

    public PropertyField
            (String name, int location, String description, int value, String color) {
        super(name, location, description);
        this.value = value;
        this.color = color;
    }
//Define getters
    public int getValue() {return value;}

    public String getColor() {return color;}

    public owner getPlayer() {return Player;}

    public boolean getHasOwner() {return hasOwner;}
    //define setters
    public void setOwner(Player player) {this.owner = player;}
    public void setHasOwner(boolean bool) {this.hasOwner = bool;}
}
