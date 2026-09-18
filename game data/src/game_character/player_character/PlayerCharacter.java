package game_character.player_character;

import game_character.GameCharacter;

public abstract class PlayerCharacter extends GameCharacter {
    public PlayerCharacter(String name, int maxHealth, int strength) {
        super(name, maxHealth, strength);
    }
    @Override
    public boolean isUndead() {
        return false;
    }
}
