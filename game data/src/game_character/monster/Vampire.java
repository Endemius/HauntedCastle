package game_character.monster;

public class Vampire extends Monster {
    public Vampire(String name) {
        super(name, 100, 25);
    }
    @Override
    public boolean isUndead() {
        return true;
    }
    @Override
    public String attackAction() {
        return "bites";
    }
}
