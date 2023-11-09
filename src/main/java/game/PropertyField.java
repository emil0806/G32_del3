package game;

public class PropertyField extends Field {

    private int value;
    private String color;
    private Player owner;
    private boolean hasOwner;

    public PropertyField(String name, int location, String description, int value, String color) {
        super(name, location, description);
        this.value = value;
        this.color = color;
        this.hasOwner = false;
    }

    // Define getters
    public int getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    public Player getOwner() {
        return this.owner;
    }

    public boolean getHasOwner() {
        return hasOwner;
    }

    // define setters
    public void setOwner(Player player) {
        this.owner = player;
    }

    public void setHasOwner(boolean bool) {
        this.hasOwner = bool;
    }

    @Override
    public void landedOnField(Player player, Player[] players, Board board) {
        // if no one owns the field, run this:
        if (!this.hasOwner) {
            // if the player can afford the field, run this:
            if (player.getAccount().getBalance() >= this.value) {
                this.owner = player;
                player.addFieldToOwned(this);
            }
            // If player cannot afford the piece, set loss state
            if (player.getAccount().getBalance() < this.value) {
                player.setHasLost(true);
            }
            // throws an error if balance and/or value cannot be evaluated
            else {
                System.out.println("Error! Invalid balance or value");
            }
        }
        // if someone owns the field, run this code:
        else {
            // calls pairOwned() to check if the owner has both fields
            if (!pairOwned()) {
                // Subtracts this.value from the visitors account and pays the owner's account
                player.getAccount().withdraw(this.value);
                this.getOwner().getAccount().deposit(this.value);
            }
            // If owner has a pair, payment becomes twice the value.
            if (pairOwned()) {
                int payment = this.value * 2;
                player.getAccount().withdraw(payment);
                this.getOwner().getAccount().deposit(payment);
            }
        }

    }

    private boolean pairOwned() {
        int colorFieldsOwned = 0;
        // declares variable for readability
        PropertyField[] owned = (PropertyField[]) this.owner.getFieldsOwned();
        // if statement to prevent out of bounds exceptions
        if (owned.length > 0) {
            for (int i = 0; i < (owned.length - 1); i++) {
                // counts how many fields of the same color are owned by the owner
                if (this.getColor().equals(owned[i].getColor())) {
                    colorFieldsOwned++;
                }
            }
            // returns true if player has a pair
            return (colorFieldsOwned == 2);
        }
        return false;

    }
}
