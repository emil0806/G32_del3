package game;

public class Board {

    private Field[] fields = new Field[24];
    private Deck deck = new Deck();

    public Board() {
        fields[0] = new RegularField("Start", 0, "You get 2 money");
        fields[1] = new PropertyField("Burgerbar", 1, "You landed on the burgerbar", 1, "Brown");
        fields[2] = new PropertyField("Pizzahouse", 2, "You landed on the pizzahouse", 1, "Brown");
        fields[3] = new ChanceField("Chance", 3, "You landed on the chance field");
        fields[4] = new PropertyField("Candyshop", 4, "You landed on the candyshop", 1, "Lightblue");
        fields[5] = new PropertyField("Icecream store", 5, "You landed on the icecream store", 1, "Lightblue");
        fields[6] = new JailField("Visit Jail", 5, "You landed on the visit jail field");
        fields[7] = new PropertyField("Museum", 7, "You landed on the museum", 2, "Pink");
        fields[8] = new PropertyField("Libary", 8, "You landed on the libery", 2, "Pink");
        fields[9] = new ChanceField("Chance", 9, "You landed on the chance field");
        fields[10] = new PropertyField("Skaterpark", 10, "You landed on the skaterpark", 2, "Orange");
        fields[11] = new PropertyField("Swimmingpool", 11, "You landed on the swimmingpool", 2, "Orange");
        fields[12] = new RegularField("Free parking", 12, "You get free parking");
        fields[13] = new PropertyField("Arcade", 13, "You landed on the arcade", 3, "Red");
        fields[14] = new PropertyField("Cinema", 14, "You landed on the cinema", 3, "Red");
        fields[15] = new ChanceField("Chance", 15, "You landed on the chance field");
        fields[16] = new PropertyField("Toy store", 16, "You landed on the toy store", 3, "Yellow");
        fields[17] = new PropertyField("Petshop", 17, "You landed on the petshop", 3, "Yellow");
        fields[18] = new GoToJailField("Jail", 18, "You need to go to jail", fields[6]);
        fields[19] = new PropertyField("Bowling alley", 19, "You landed on the bowling alley", 4, "Green");
        fields[20] = new PropertyField("ZOO", 20, "You landed on the ZOO", 4, "Green");
        fields[21] = new ChanceField("Chance", 21, "You landed on the chance field");
        fields[22] = new PropertyField("Waterpark", 22, "You landed on the waterpark", 5, "Blue");
        fields[23] = new PropertyField("Beach", 23, "You landed on the beach", 5, "Blue");

    }

    public Field getField(int location) {
        return fields[location];
    }

}
