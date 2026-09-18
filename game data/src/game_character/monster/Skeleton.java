package game_character.monster;

public class Skeleton extends Monster {
    public Skeleton(String name) {
        super(name, 25, 10);
    }
    @Override
    public boolean isUndead() {
        return true;
    }
    @Override
    public String attackAction() {
        return "slashes";
    }
}
