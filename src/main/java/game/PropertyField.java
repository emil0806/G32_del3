package game;

public class PropertyField extends Field {

    private int value;
    private String color;
    private Player owner;
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

    public Player getOwner() {return this.owner;}

    public boolean getHasOwner() {return hasOwner;}
    //define setters
    public void setOwner(Player player) {this.owner = player;}
    public void setHasOwner(boolean bool) {this.hasOwner = bool;}

    @Override
    public void landedOnField(Player player) {
        //if no one owns the field, run this:
    if (!this.hasOwner){
        //if the player can afford the field, run this:
        if (player.getAccount().getBalance() >= this.value){
            this.owner=player;
            player.addFieldToOwned(this);
        }
        //If player cannot afford the piece, set loss state
        if (player.getAccount().getBalance() < this.value) {player.setHasLost(true);}
        //throws an error if balance and/or value cannot be evaluated
        else{System.out.println("Error! Invalid balance or value");}
    }
    //if someone owns the field, run this code:
        else{
            int colorFieldsOwned=0;
            for (int i = 0; i < (this.owner.getFieldsOwned().length-1); i++){
                //TODO FINISH THIS
            }
            player.getAccount().withdrawMoney(this.value)

    }
    }
}
