package game;

class OutputBoard {
    private String[][][] board = new String[7][7][6];
    private boolean gameHasLoser = false;

    public OutputBoard() {
        board[0][0][1] = "    START    ";
        board[0][0][2] = "   YOU GET   ";
        board[0][0][3] = "      2$     ";
        board[0][0][5] = "      0      ";
        board[0][1][2] = "  \033[90mBURGERBAR\033[0m  ";
        board[0][1][3] = "      \033[90m1$\033[0m     ";
        board[0][1][5] = "      1      ";
        board[0][2][2] = "  \033[90mPIZZAHOUSE\033[0m ";
        board[0][2][3] = "      \033[90m1$\033[0m     ";
        board[0][2][5] = "      2      ";
        board[0][3][2] = "    CHANCE   ";
        board[0][3][5] = "      3      ";
        board[0][4][2] = "  \033[36mCANDYSHOP\033[0m  ";
        board[0][4][3] = "      \033[36m1$\033[0m     ";
        board[0][4][5] = "      4      ";
        board[0][5][2] = "   \033[36mICECREAM\033[0m  ";
        board[0][5][3] = "      \033[36m1$\033[0m     ";
        board[0][5][5] = "      5      ";
        board[0][6][2] = "    VISIT    ";
        board[0][6][3] = "    PRISON   ";
        board[0][6][5] = "      6      ";
        board[1][6][2] = "    \033[95mMUSEUM\033[0m   ";
        board[1][6][3] = "      \033[95m2$\033[0m     ";
        board[1][6][5] = "      7      ";
        board[2][6][2] = "   \033[95mLIBRARY\033[0m   ";
        board[2][6][3] = "      \033[95m2$\033[0m     ";
        board[2][6][5] = "      8      ";
        board[3][6][2] = "    CHANCE   ";
        board[3][6][5] = "      9      ";
        board[4][6][2] = " \033[33mSKATERPARK\033[0m  ";
        board[4][6][3] = "      \033[33m2$\033[0m     ";
        board[4][6][5] = "      10     ";
        board[5][6][2] = " \033[33mSWIMMINGPOOL\033[0m";
        board[5][6][3] = "      \033[33m2$\033[0m     ";
        board[5][6][5] = "      11     ";
        board[6][6][2] = "    FREE     ";
        board[6][6][3] = "   PARKING   ";
        board[6][6][5] = "      12     ";
        board[6][5][2] = "    \033[31mARCADE\033[0m   ";
        board[6][5][3] = "      \033[31m3$\033[0m     ";
        board[6][5][5] = "      13     ";
        board[6][4][2] = "    \033[31mCINEMA\033[0m   ";
        board[6][4][3] = "      \033[31m3$\033[0m     ";
        board[6][4][5] = "      14     ";
        board[6][3][2] = "    CHANCE   ";
        board[6][3][5] = "      15     ";
        board[6][2][2] = "  \033[93mTOY STORE\033[0m  ";
        board[6][2][3] = "      \033[93m3$\033[0m     ";
        board[6][2][5] = "      16     ";
        board[6][1][2] = "   \033[93mPETSHOP\033[0m   ";
        board[6][1][3] = "      \033[93m3$\033[0m     ";
        board[6][1][5] = "      17     ";
        board[6][0][2] = "    GO TO    ";
        board[6][0][3] = "     JAIL    ";
        board[6][0][5] = "      18     ";
        board[5][0][2] = "\033[32mBOWLING ALLEY\033[0m";
        board[5][0][3] = "      \033[32m4$\033[0m     ";
        board[5][0][5] = "      19     ";
        board[4][0][2] = "     \033[32mZOO\033[0m     ";
        board[4][0][3] = "      \033[32m4$\033[0m     ";
        board[4][0][5] = "      20     ";
        board[3][0][2] = "    CHANCE   ";
        board[3][0][5] = "      21     ";
        board[2][0][2] = "  \033[94mWATERPARK\033[0m  ";
        board[2][0][3] = "      \033[94m5$\033[0m     ";
        board[2][0][5] = "      22     ";
        board[1][0][2] = "    \033[94mBEACH\033[0m    ";
        board[1][0][3] = "      \033[94m5$\033[0m     ";
        board[1][0][5] = "      23     ";
    }

    public void showBoard(Player[] players) {

        String[] playerTypes = new String[players.length];

        for (int i = 0; i < players.length; i++) {
            switch (players[i].getPiece().getType()) {
                case "ship":
                    playerTypes[i] = "🚢";
                    break;
                case "car":
                    playerTypes[i] = "🚗";
                    break;
                case "dog":
                    playerTypes[i] = "🐶";
                    break;
                case "cat":
                    playerTypes[i] = "🐱";
                    break;
            }
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j][0] = "             ";
            }
        }

        for (int i = 0; i < players.length; i++) {
            board[0][0][0] = "             ";
            int location = players[i].getPiece().getLocation().getLocation();
            if (location >= 0 && location <= 6) {
                this.board[0][location][0] = "      " + playerTypes[i] + "     ";
            } else if (location > 6 && location <= 11) {
                this.board[location - 6][6][0] = "      " + playerTypes[i] + "     ";
            } else if (location >= 12 && location <= 18) {
                this.board[6][18 % location][0] = "      " + playerTypes[i] + "     ";
            } else if (location >= 19 && location <= 23) {
                this.board[24 % location][0][0] = "      " + playerTypes[i] + "     ";
            }
        }

        String fullLine = "---------------------------------------------------------------------------------------------------";
        String underLine = "---------------                                                                     ---------------";
        for (int i = 0; i < 7; i++) {
            if (i < 2 || i > 5) {
                System.out.println(fullLine);
            } else {
                System.out.println(underLine);
            }

            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 7; k++) {
                    if ((i > 0 && i < 6) && (k > 1 && k < 6)) {
                        System.out.print("              ");
                        continue;
                    } else if (board[i][k][j] == null) {
                        board[i][k][j] = "             ";
                    }

                    String s = board[i][k][j];
                    // if (length(s)=0 ){s=" ";};
                    System.out.print("|" + s);
                }
                System.out.println("|");
            }
        }
        System.out.println(fullLine);

        for (int i = 0; i < players.length; i++) {
            if (players[i].getHasLost()) {
                this.gameHasLoser = true;
            }
        }

        if (gameHasLoser) {
            System.out.println("The game is over. Here is the final scoreboard:");
        }

        for (int i = 0; i < players.length; i++) {
            System.out.print(players[i].getPlayerName() + ", " + playerTypes[i] + " : "
                    + players[i].getPiece().getLocation().getLocation()
                    + " , " + players[i].getAccount().getBalance() + "$ , ");
            for (int j = 0; j < players[i].getFieldsOwned().length; j++) {
                System.out.print(players[i].getFieldsOwned()[j].getName() + ", ");
            }
            System.out.println("");
        }
    }

}
