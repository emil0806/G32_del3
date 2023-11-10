package game;

abstract class Field {
    public String name;
    public int location;
    public String description;

    public Field(String name, int location, String description) {
        this.name = name;
        this.location = location;
        this.description = description;
    }

    // Define getters
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getLocation() {
        return this.location;
    }

    public abstract void landedOnField(Player player, Player[] players, Board board); // Abstract method.

}
