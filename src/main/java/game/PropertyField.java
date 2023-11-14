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
                this.hasOwner = true;
                player.addFieldToOwned(this);
                player.withdrawMoney(this.value);
            }
        } else if (!(this.owner.getPlayerName().equals(player.getPlayerName()))) {
            // calls pairOwned() to check if the owner has both fields
            if (!pairOwned()) {
                // Subtracts this.value from the visitors account and pays the owner's account
                player.withdrawMoney(this.value);
                this.getOwner().depositMoney(this.value);
            }
            // If owner has a pair, payment becomes twice the value.
            if (pairOwned()) {
                player.withdrawMoney(this.value * 2);
                this.getOwner().depositMoney(this.value * 2);
            }
        }

    }

    private boolean pairOwned() {
        // declares variable for readability
        PropertyField[] owned = this.owner.getFieldsOwned();
        // if statement to prevent out of bounds exceptions
        for (int i = 0; i < owned.length; i++) {
            // counts how many fields of the same color are owned by the owner
            if (!(this.name.equals(owned[i].getName()))) {
                if (this.color.equals(owned[i].getColor())) {
                    return true;
                }
            }

        }
        return false;

    }
}
