package game_character;

import game.GameEntity;

public abstract class GameCharacter implements GameEntity {
    private String name;
    private int maxHealth;
    private int health;
    private int strength;

    public GameCharacter(String name, int maxHealth, int strength) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getHealth() {
        return health;
    }
    public int getStrength() {
        return strength;
    }

    public boolean isVanquished() {
        return health == 0;
    }
    public void decreaseHealth(int amount) {
        health -= amount;
        if(health < 0) {
            health = 0;
        }
    }
    public void increaseHealth(int amount) {
        health += amount;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }
    public void attack(GameCharacter target) {
        target.decreaseHealth(this.strength);
    }
    public String attackAction() {
        return "punches";
    }
    public abstract boolean isUndead();
    public void drinkHealthPotion() {
        if (!isUndead()) {
            increaseHealth(20);
        } else {
            decreaseHealth(20);
        }
    }
}
