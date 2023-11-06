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
    public String getName() {return name;}
    public String getDescription() {return description;}
    public int getLocation() {return location; }

}
