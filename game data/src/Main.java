import game.GameData;
import game.GameEntity;
import game.GameLoader;
import game_character.GameCharacter;
import item.Item;
import room.Room;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void reportRoom(Room room) {
        System.out.println("\n== " + room.getName() + " ==");
        System.out.println("Accessible rooms: " + room.getAccessibleRoomNames());
        System.out.println("Contents:");

        for (String name : room.getGameEntityNames()) {
            GameEntity entity = room.findInRoom(name);
            if (entity != null) {
                System.out.println("  - " + entity.getName()
                        + " (" + entity.getClass().getSimpleName() + ")");
            }
        }
    }

    public static void attack(GameCharacter attacker, GameCharacter target) {
        System.out.println(attacker.getName() + " " + attacker.attackAction()
                + " " + target.getName() + ".");
        attacker.attack(target);
        System.out.println(target.getName() + " now has "
                + target.getHealth() + " health.");
    }

    public static void main(String[] args) throws IOException {

        File file = new File("hauntedcastle.txt");
        GameData gameData = GameLoader.loadGameData(file);

        System.out.println("*** The Haunted Castle ***");

        for (String roomName : gameData.getRoomNames()) {
            Room room = gameData.getRoom(roomName);
            reportRoom(room);
        }

        Room entrance = gameData.getRoom("entrance hall");

        System.out.println("\n*** Interface Check ***");
        GameEntity first = entrance.findInRoom("Sir Roderick");
        GameEntity second = entrance.findInRoom("iron key");

        System.out.println(first.getName() + " is stored as a GameEntity,"
                + " but is really a " + first.getClass().getSimpleName() + ".");
        System.out.println(second.getName() + " is also stored as a GameEntity,"
                + " but is really an " + second.getClass().getSimpleName() + ".");

        System.out.println("\n*** A Small Encounter ***");
        GameCharacter roderick = gameData.getCharacter("Sir Roderick");
        GameCharacter orlok = gameData.getCharacter("Count Orlok");

        attack(roderick, orlok);
        attack(orlok, roderick);

        System.out.println("\n*** An Item Lookup ***");
        Item dagger = gameData.getItem("silver dagger");
        System.out.println("Found item: " + dagger.getName());

        System.out.println("\nDone.");
    }
}
