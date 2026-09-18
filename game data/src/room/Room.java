package room;
import game.GameEntity;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private ArrayList<Room> accessibleRooms;
    private List<GameEntity> objects;

    public Room(String name) {
        this.name = name;
        accessibleRooms = new ArrayList<>();
        objects = new ArrayList<>();
    }

    public ArrayList<String> getAccessibleRoomNames() {
        ArrayList<String> nameList = new ArrayList<>();
        for (Room rm : accessibleRooms) {
            nameList.add(rm.getName());
        }
        return nameList;
    }

    public String getName() {
        return name;
    }

    public void addAccessibleRoom(Room room) {
        if (!accessibleRooms.contains(room)) {
            accessibleRooms.add(room);
        }
    }

    public Room getAccessibleRoom(String roomName) throws Exception {
        for (Room rm : accessibleRooms) {
            if( rm.getName().equals(roomName)) {
                return rm;
            }
        }
        throw new Exception("Such room does not exist");
    }

    public static void connectRooms(Room room1, Room room2) {
        room1.addAccessibleRoom(room2);
        room2.addAccessibleRoom(room1);
    }
    public void placeInRoom(GameEntity entity) {
        objects.add(entity);
    }
    public GameEntity findInRoom(String name) {
        for(GameEntity entity : objects) {
           if (entity.getName().equals(name)) {
               return entity;
           }
        }
        return null;
    }
    public ArrayList<String> getGameEntityNames() {
        ArrayList<String> names = new ArrayList<>();
        for(GameEntity entity : objects) {
            names.add(entity.getName());
        }
        return names;
    }

}
