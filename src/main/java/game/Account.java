package game;

public class Account {
    private int balance;

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
//Condition left open. UNsure what it is supposed to be
    public boolean withdraw(int amount) {
        if () {
            
            return true; 
        } else {
            return false; 
        }
    }
//Condition left open. UNsure what it is supposed to be
    public boolean deposit(int amount) {
        if () {
           
            return true;
        } else {
            return false; 
        }
    }
}
