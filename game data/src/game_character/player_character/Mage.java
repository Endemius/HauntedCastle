package game_character.player_character;

import game_character.GameCharacter;

public class Mage extends PlayerCharacter{
    private int magic;
    public Mage(String name) {
        super(name, 35, 2);
        magic = 20;
    }
    public int getMagic() {
        return magic;
    }
    @Override
    public void attack(GameCharacter target) {
        if (target.getHealth() <= magic) {
            magic -= target.getHealth();
            target.decreaseHealth(target.getHealth());
        }
        if (target.getHealth() > magic) {
            target.decreaseHealth(magic);
            magic = 0;
        }
    }
    @Override
    public String attackAction() {
        return "casts magic on";
    }
}
