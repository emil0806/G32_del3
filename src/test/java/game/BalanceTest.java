package game;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BalanceTest {
    private Player player1 = new Player("Player 1", 10, "ship", 3);
    private Player player2 = new Player("Player 2", 12, "car", 3);
    private Player player3 = new Player("Player 3", 20, "dog", 3);

    @Test
    public void startBalance() {
        assertEquals(player1.getAccount().getBalance(), 18);
        assertEquals(player2.getAccount().getBalance(), 18);
        assertEquals(player3.getAccount().getBalance(), 18);
    }

    @Test
    public void depositMoney() {
        player1.depositMoney(2);
        player2.depositMoney(1);
        player3.depositMoney(0);

        assertEquals(player1.getAccount().getBalance(), 20);
        assertEquals(player2.getAccount().getBalance(), 19);
        assertEquals(player3.getAccount().getBalance(), 18);
    }

    @Test
    public void withdrawMoney() {
        player1.withdrawMoney(2);
        player2.withdrawMoney(0);
        player3.withdrawMoney(10);

        assertEquals(player1.getAccount().getBalance(), 16);
        assertEquals(player2.getAccount().getBalance(), 18);
        assertEquals(player3.getAccount().getBalance(), 8);
    }

    @Test
    public void negativeBalance() {
        player1.withdrawMoney(20);
        player2.withdrawMoney(18);
        player3.withdrawMoney(100);

        assertEquals(player1.getAccount().getBalance(), 0);
        assertEquals(player2.getAccount().getBalance(), 0);
        assertEquals(player3.getAccount().getBalance(), 0);

        player1.depositMoney(2);
        player2.depositMoney(1);
        player3.depositMoney(0);

        assertEquals(player1.getAccount().getBalance(), 2);
        assertEquals(player2.getAccount().getBalance(), 1);
        assertEquals(player3.getAccount().getBalance(), 0);

        player1.withdrawMoney(1);
        player2.withdrawMoney(1);
        player3.withdrawMoney(1000);

        assertEquals(player1.getAccount().getBalance(), 1);
        assertEquals(player2.getAccount().getBalance(), 0);
        assertEquals(player3.getAccount().getBalance(), 0);
    }
}
