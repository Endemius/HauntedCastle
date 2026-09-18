package game;

import game_character.GameCharacter;
import item.Item;
import room.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameData {
    private Map<String, Room> rooms;
    private Map<String, GameCharacter> characters;
    private Map<String, Item> items;

    public GameData() {
        rooms = new HashMap<>();
        characters = new HashMap<>();
        items = new HashMap<>();
    }
    public void addRoom(Room room) {
        rooms.put(room.getName(), room);
    }
    public Room getRoom(String name) {
        return rooms.get(name);
    }
    public List<String> getRoomNames() {
        List<String> roomNames = new ArrayList<>();
        for(String name : rooms.keySet()) {
            roomNames.add(name);
        }
        return roomNames;
    }
    public void addCharacter(GameCharacter character) {
        characters.put(character.getName(), character);
    }
    public GameCharacter getCharacter(String name) {
        return characters.get(name);
    }
    public List<String> getCharacterNames(){
        List<String> characterNames = new ArrayList<>();
        for(String name : characters.keySet()) {
            characterNames.add(name);
        }
        return characterNames;
    }
    public void addItem(Item item) {
        items.put(item.getName(), item);
    }
    public Item getItem(String name) {
        return items.get(name);
    }
    public List<String> getItemNames() {
        List<String> itemNames = new ArrayList<>();
        for(String name : items.keySet()) {
            itemNames.add(name);
        }
        return itemNames;
    }
}
