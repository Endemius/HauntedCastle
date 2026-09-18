package game_character.monster;

import game_character.GameCharacter;

public class Slime extends Monster {
    public Slime(String name) {
        super(name, 70, 5);
    }

    @Override
    public boolean isUndead() {
        return false;
    }
    @Override
    public String attackAction() {
        return "slimes";
    }
    @Override
    public void attack(GameCharacter target) {
        target.decreaseHealth(this.getHealth());
    }
}
