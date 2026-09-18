package item;

import game.GameEntity;

public class Item implements GameEntity {
    private String name;
    public Item(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
