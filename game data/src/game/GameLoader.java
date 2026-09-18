package game;

import game_character.monster.Skeleton;
import game_character.monster.Slime;
import game_character.monster.Vampire;
import game_character.player_character.Fighter;
import game_character.player_character.Mage;
import item.Item;
import room.Room;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameLoader {
    public static GameData loadGameData(File file) throws IOException {
        GameData data = new GameData();
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) {
                continue;
            }
            Scanner lineScanner = new Scanner(line);
            ArrayList<String> tokens = new ArrayList<>();
            while(lineScanner.hasNext()) {
                tokens.add(lineScanner.next());
            }
            lineScanner.close();
            switch(tokens.get(0)) {
                case "ROOM": {
                    checkLineValidity(tokens.size(),2, scanner);
                    String name = underscoreToSpace(tokens.get(1));
                    data.addRoom(new Room(name));
                    break;
                }
                case "CONNECT": {
                    checkLineValidity(tokens.size(), 3, scanner);
                    Room.connectRooms(lookUpRoom(data, tokens.get(1), scanner), lookUpRoom(data,tokens.get(2), scanner));
                    break;
                }
                case "LEADS_TO": {
                    checkLineValidity(tokens.size(), 3, scanner);
                    lookUpRoom(data,tokens.get(1), scanner).addAccessibleRoom(lookUpRoom(data,tokens.get(2),scanner));
                    break;
                }
                case "FIGHTER": {
                    checkLineValidity(tokens.size(), 3, scanner);
                    String name = underscoreToSpace(tokens.get(1));
                    Fighter f = new Fighter(name);
                    data.addCharacter(f);
                    lookUpRoom(data,tokens.get(2), scanner).placeInRoom(f);
                    break;
                }
                case "MAGE": {
                    checkLineValidity(tokens.size(), 3, scanner);
                    String name = underscoreToSpace(tokens.get(1));
                    Mage m = new Mage(name);
                    data.addCharacter(m);
                    lookUpRoom(data,tokens.get(2), scanner).placeInRoom(m);
                    break;
                }
                case "VAMPIRE": {
                    checkLineValidity(tokens.size(), 3, scanner);
                    String name = underscoreToSpace(tokens.get(1));
                    Vampire v = new Vampire(name);
                    data.addCharacter(v);
                    lookUpRoom(data,tokens.get(2), scanner).placeInRoom(v);
                    break;
                }
                case "SKELETON": {
                    checkLineValidity(tokens.size(), 3, scanner);
                    String name = underscoreToSpace(tokens.get(1));
                    Skeleton sk = new Skeleton(name);
                    data.addCharacter(sk);
                    lookUpRoom(data,tokens.get(2), scanner).placeInRoom(sk);
                    break;
                }
                case "SLIME": {
                    checkLineValidity(tokens.size(), 3, scanner);
                    String name = underscoreToSpace(tokens.get(1));
                    Slime sl = new Slime(name);
                    data.addCharacter(sl);
                    lookUpRoom(data,tokens.get(2), scanner).placeInRoom(sl);
                    break;
                }
                case "ITEM": {
                    checkLineValidity(tokens.size(), 3, scanner);
                    String name = underscoreToSpace(tokens.get(1));
                    Item item = new Item(name);
                    data.addItem(item);
                    lookUpRoom(data,tokens.get(2), scanner).placeInRoom(item);
                    break;
                }
                default:
                    scanner.close();
                    throw new IOException("Unknown command");
            }
        }
        scanner.close();
        return data;
    }
    private static void checkLineValidity(int size, int required,Scanner scanner) throws IOException{
        if( size != required) {
            scanner.close();
            throw new IOException("The line does not fit the required format");
        }
    }
    private static String underscoreToSpace(String str) {
        return str.replace('_', ' ');
    }
    private static Room lookUpRoom(GameData data, String token, Scanner scanner) throws IOException {
        String roomName = underscoreToSpace(token);
        Room room = data.getRoom(roomName);
        if (room == null) {
            scanner.close();
            throw new IOException("Room DNE");
        }
        return room;
    }
}
