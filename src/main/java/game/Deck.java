package game;

import java.util.Random;

public class Deck {

    private Card[] cards = new Card[20];

    public Deck() {
        cards[0] = new MoveByTypeCard(
                "Give this card to the car. \n The car can move anywhere it wants in their next turn.", "car");
        cards[1] = new MoveToFieldCard("Move to Start.", 0);
        cards[2] = new MoveCard("Move 5 forward", 5);
        cards[3] = new MoveToColorCard("Move to an orange field, you choose.", new int[] { 10, 11 });
        cards[4] = new MoveCard("Move 1 forward", 1);
        cards[5] = new MoveByTypeCard(
                "Give this card to the ship. \n The ship can move anywhere it wants in their next turn.", "ship");
        cards[6] = new MoneyCard("You ate too much candy, pay 2$ to the bank", 2, true);
        cards[7] = new MoveToColorCard("Move to an orange or green field, you choose.", new int[] { 10, 11, 19, 20 });
        cards[8] = new MoveToColorCard("Move to a lightblue field, you choose.", new int[] { 4, 5 });
        cards[9] = new OutOfJailCard("You can get out of jail for free. This card is stored for next time.");
        cards[10] = new MoveToFieldCard("Move to the beach", 23);
        cards[11] = new MoveByTypeCard(
                "Give this card to the cat. \n The cat can move anywhere it wants in their next turn.", "cat");
        cards[12] = new MoveByTypeCard(
                "Give this card to the dog. \n The dog can move anywhere it wants in their next turn.", "dog");
        cards[13] = new MoneyCard("It is your birthday, you get 1$ from everybody", 1, false);
        cards[14] = new MoveToColorCard("Move to a pink or blue field, you choose.", new int[] { 7, 8, 22, 23 });
        cards[15] = new MoneyCard("You made all your homework, you get 2$ from the bank", 2, true);
        cards[16] = new MoveToColorCard("Move to a red field, you choose.", new int[] { 13, 14 });
        cards[17] = new MoveToFieldCard("Move to the skaterpark", 10);
        cards[18] = new MoveToColorCard("Move to a lightblue or red field, you choose.", new int[] { 4, 5, 13, 14 });
        cards[19] = new MoveToColorCard("Move to a brown or yellow field, you choose.", new int[] { 1, 2, 16, 17 });

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

    public void drawCard(Player player, Player[] players, Board board) {
        this.cards[0].applyEffect(player, players, board);
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

    public Card[] getCards() {
        return this.cards;
    }

}
