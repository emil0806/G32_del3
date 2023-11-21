package game;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PlayerToStart {
    private Game game = new Game();
    private Player[] players = new Player[] { new Player("Mikkel", 23, "ship", 4), new Player("William", 21, "car", 4),
            new Player("Julius", 25, "dog", 4), new Player("Emil", 24, "cat", 4) };

    @Test
    public void youngestPlayerToStart() {
        Player[] sortedPlayers = game.sortPlayersByAge(players);

        assertEquals(sortedPlayers[0].getPlayerName(), "William");
        assertEquals(sortedPlayers[0].getAge(), 21);
        assertEquals(sortedPlayers[0].getPiece().getType(), "car");

        assertEquals(sortedPlayers[1].getPlayerName(), "Mikkel");
        assertEquals(sortedPlayers[1].getAge(), 23);
        assertEquals(sortedPlayers[1].getPiece().getType(), "ship");

        assertEquals(sortedPlayers[2].getPlayerName(), "Emil");
        assertEquals(sortedPlayers[2].getAge(), 24);
        assertEquals(sortedPlayers[2].getPiece().getType(), "cat");

        assertEquals(sortedPlayers[3].getPlayerName(), "Julius");
        assertEquals(sortedPlayers[3].getAge(), 25);
        assertEquals(sortedPlayers[3].getPiece().getType(), "dog");
    }
}
