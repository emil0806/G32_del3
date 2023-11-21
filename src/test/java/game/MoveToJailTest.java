package game;

import static junit.testcase

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerTest {
    private Player[] players = new Player[] { new Player("John", 23, "ship", 2), new Player("John John", 21, "car", 2)};
   
    
    
    private Board b = new Board();


    @Test
    Field f = b.getField(18); 
    f.landedOnField(players[0], players,b);
    f.moveToJail(player1, players[0]);
        assertEquals(player1.moveToJail(), "John");
        player1.setOutOfJailCard(true);
        playerSetinJail(false);
        
}