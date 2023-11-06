package game;

public class Piece {
    private String type;      // The type of the game piece 
    private Field location;   // The current location of the game piece on the board.

    // Constructor to initialize the type and location when creating a Piece object.
    public Piece(String type, Field location) {
        this.type = type;
        this.location = location;
    }

    // Getter for retrieving the type of the game piece.
    public String getType() {
        return type;
    }

    // Setter for updating the type of the game piece.
    public void setType(String type) {
        this.type = type;
    }

    // Getter for retrieving the current location of the game piece on the board.
    public Field getLocation() {
        return location;
    }

    // Setter for updating the location of the game piece on the board.
    public void setLocation(Field location) {
        this.location = location;
    }
}
