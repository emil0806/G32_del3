package game;

public class Player {
    private String name;
    private int age;
    private Account account;
    private Piece piece;
    private boolean inJail;
    private boolean outOfJailCard;
    private boolean moveByTypeCard;
    private Field[] fieldsOwned;

    public Player(String name, int age, String piece) {
        this.name = name;
        this.age = age;
        this.account = new Account();
        this.piece = new Piece(piece);
        this.inJail = false;
        this.outOfJailCard = false;
        this.moveByTypeCard = false;
        this.fieldsOwned = new Field[] {};
    }

    public String getPlayerName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public Account getAccount() {
        return this.account;
    }

    public void withdrawMoney(int amount) {
        this.account.withdraw(amount);
    }

    public void depositMoney(int amount) {
        this.account.deposit(amount);
    }

    public Piece getPiece() {
        return this.piece;
    }

    public boolean getInJail() {
        return this.inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public boolean getOutOfJailCard() {
        return this.outOfJailCard;
    }

    public void setOutOfJailCard(boolean outOfJailCard) {
        this.outOfJailCard = outOfJailCard;
    }

    public boolean getMoveByTypeCard() {
        return this.moveByTypeCard;
    }

    public void setMoveByTypeCard(boolean moveByTypeCard) {
        this.moveByTypeCard = moveByTypeCard;
    }

    public Field[] getFieldsOwned() {
        return this.fieldsOwned;
    }

    public void addFieldToOwned(Field field) {
        Field[] tempFieldsOwned = new Field[this.fieldsOwned.length + 1];
        for (int i = 0; i < this.fieldsOwned.length; i++) {
            tempFieldsOwned[i] = this.fieldsOwned[i];
        }
        tempFieldsOwned[this.fieldsOwned.length] = field;

        this.fieldsOwned = tempFieldsOwned;
    }
}
