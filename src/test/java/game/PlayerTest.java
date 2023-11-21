package game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerTest {

    private Player player1 = new Player("William", 10, "ship", 3);
    private Player player2 = new Player("Mikkel", 12, "car", 3);
    private Player player3 = new Player("Julius", 20, "dog", 3);

    @Test
    public void playerName() {
        assertEquals(player1.getPlayerName(), "William");
        assertEquals(player2.getPlayerName(), "Mikkel");
        assertEquals(player3.getPlayerName(), "Julius");
    }

    @Test
    public void playerAge() {
        assertEquals(player1.getAge(), 10);
        assertEquals(player2.getAge(), 12);
        assertEquals(player3.getAge(), 20);
    }

    @Test
    public void playerType() {
        assertEquals(player1.getPiece().getType(), "ship");
        assertEquals(player2.getPiece().getType(), "car");
        assertEquals(player3.getPiece().getType(), "dog");
    }

    @Test
    public void startFields() {
        assertEquals(player1.getFieldsOwned().length, 0);
        assertEquals(player2.getFieldsOwned().length, 0);
        assertEquals(player3.getFieldsOwned().length, 0);
    }

    @Test
    public void notInJailFromStart() {
        assertEquals(player1.getInJail(), false);
        assertEquals(player2.getInJail(), false);
        assertEquals(player3.getInJail(), false);
    }

    @Test
    public void notLostFromStart() {
        assertEquals(player1.getHasLost(), false);
        assertEquals(player2.getHasLost(), false);
        assertEquals(player3.getHasLost(), false);
    }
}
