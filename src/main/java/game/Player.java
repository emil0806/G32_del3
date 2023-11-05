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

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        this.account = new Account();
        this.piece = new Piece();
        this.inJail = false;
        this.outOfJailCard = false;
        this.moveByTypeCard = false;
        this.fieldsOwned = new Field[] {};
    }
}
