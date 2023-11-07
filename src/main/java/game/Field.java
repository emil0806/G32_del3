package game;

import com.sun.tools.javac.comp.Resolve;

abstract class Field {
    public String name;
    public int location;
    public String description;

    public Field(String name, int location, String description) {
        this.name = name;
        this.location = location;
        this.description = description;
    }

    //Define getters
    public String getName() {return this.name;}
    public String getDescription() {return this.description;}
    public int getLocation() {return this.location; }

    public void landedOnField(Player player){
        //Abstract method empty.
    }


}
