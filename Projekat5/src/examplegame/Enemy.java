package examplegame;

public class Enemy extends GameObject implements Attacker {
    private String type;
    private int damage; 
    private int health; 

    public Enemy(String type, int damage, int health, int x, int y, Collidable collider) {
        super(x, y, collider);
        setType(type);
        setDamage(damage);
        setHealth(health);
    }

    public String getType() { return type; }
    public void setType(String type) {
        if (type == null) throw new IllegalArgumentException("Type cannot be null");
        String t = type.trim();
        if (t.isEmpty()) throw new IllegalArgumentException("Type cannot be empty");
        this.type = t;
    }

    public int getDamage() { return damage; }
    public void setDamage(int damage) {
        if (damage < 0 || damage > 100) throw new IllegalArgumentException("Damage must be 0..100");
        this.damage = damage;
    }

    public int getHealth() { return health; }
    public void setHealth(int health) {
        if (health < 0 || health > 100) throw new IllegalArgumentException("Health must be 0..100");
        this.health = health;
    }

    @Override
    public int getEffectiveDamage() {
        return damage;
    }

    @Override
    public String getDisplayName() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("Enemy{type='%s', dmg=%d, hp=%d, x=%d, y=%d, collider=%s}",
                type, damage, health, getX(), getY(), getCollider().toString());
    }
}
