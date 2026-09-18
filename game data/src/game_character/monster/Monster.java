package game_character.monster;

import game_character.GameCharacter;

public abstract class Monster extends GameCharacter {
    public Monster(String name, int maxHealth, int strength) {
        super(name, maxHealth, strength);
    }
}
