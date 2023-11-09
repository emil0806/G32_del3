package game;

import java.util.Scanner;

public class MoveToColorCard extends Card {

    private int[] locations;

    public MoveToColorCard(String description, int[] locations) {
        super(description);
        this.locations = locations;
    }

    public void applyEffect(Player player, Player[] players, Board board) {
        moveToField(player, board);
    }

    public void moveToField(Player player, Board board) {
        Scanner s = new java.util.Scanner(System.in);
        boolean correctInput = false;
        int location = 0;
        while (!correctInput) {
            location = s.nextInt();
            for (int i = 0; i < this.locations.length; i++) {
                if (location == locations[i]) {
                    correctInput = true;
                    break;
                }
            }
        }

        int nextLocation = location + player.getPiece().getLocation().getLocation();
        Field nextField = board.getField(location + nextLocation);
        player.getPiece().setLocation(nextField);
        s.close();
    }
}
