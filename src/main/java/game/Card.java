package game;

abstract class Card {
    private String description;

    public Card(String description) {
        this.description = description;
    }

    public abstract void applyEffect(Player player);

}
