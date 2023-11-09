package game;

import java.util.Random;

public class Deck {

    private Card[] cards = new Card[20];

    public Deck() {
        cards[0] = new Card();
        cards[1] = new Card();
        cards[2] = new Card();
        cards[3] = new Card();
        cards[4] = new Card();
        cards[5] = new Card();
        cards[6] = new Card();
        cards[7] = new Card();
        cards[8] = new Card();
        cards[9] = new Card();
        cards[10] = new Card();
        cards[11] = new Card();
        cards[12] = new Card();
        cards[13] = new Card();
        cards[14] = new Card();
        cards[15] = new Card();
        cards[16] = new Card();
        cards[17] = new Card();
        cards[18] = new Card();
        cards[19] = new Card();

    }

    public Card[] getCards() {
        return this.cards;
    }

    public void shuffleDeck() {
        Random rand = new Random();

        for (int i = 0; i < this.cards.length; i++) {
            int randomIndexToSwap = rand.nextInt(this.cards.length);
            Card temp = this.cards[randomIndexToSwap];
            this.cards[randomIndexToSwap] = this.cards[i];
            this.cards[i] = temp;
        }
    }

    public void drawCard(Player player) {
        this.cards[0].applyEffect(player);
        putCardInBottom();
    }

    public void putCardInBottom() {
        Card[] tempCards = this.cards;

        Card firstCard = this.cards[0];
        for (int i = 0; i < this.cards.length - 1; i++) {
            tempCards[i] = this.cards[i + 1];
        }

        tempCards[this.cards.length - 1] = firstCard;

        this.cards = tempCards;
    }

}
