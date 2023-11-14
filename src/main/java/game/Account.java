package game;

public class Account {
    private int balance;

    // account constructor

    public Account(int numPlayers) {
        if (numPlayers == 2) {
            balance = 20;
        } else if (numPlayers == 3) {
            balance = 18;
        } else if (numPlayers == 4) {
            balance = 16;
        } else {
            balance = 20;
        }
    }

    public void setBalance(int amount) {
        balance = amount;
    }

    public int getBalance() {
        return balance;
    }

    public boolean withdraw(int amount) {
        if ((this.balance - amount) < 0) {
            this.balance = 0;
            return false;
        } else {
            this.balance -= amount;
            return true;
        }
    }

    public void deposit(int amount) {
        (this.balance) += amount;
    }

}
