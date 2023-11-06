package game;

public class MoneyCard extends Card {

    private int amount;
    private boolean fromBank;

    public MoneyCard(String description, int amount, boolean fromBank) {
        super(description);
        this.amount = amount;
        this.fromBank = fromBank;
    }

}
