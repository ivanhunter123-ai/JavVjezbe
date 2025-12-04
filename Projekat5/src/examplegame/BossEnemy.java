package examplegame;

public class BossEnemy extends Enemy {
    public BossEnemy(String type, int damage, int health, int x, int y, Collidable collider) {
        super(type, damage, health, x, y, collider);
    }

    @Override
    public int getEffectiveDamage() {
        
        int doubled = super.getDamage() * 2;
        return Math.min(doubled, 100);
    }

    @Override
    public String toString() {
        return "BOSS " + super.toString();
    }
}
