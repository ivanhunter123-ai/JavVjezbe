package examplegame;

public class Player extends GameObject {
    private String name;
    private int health; 

    public Player(String name, int health, int x, int y, Collidable collider) {
        super(x, y, collider);
        setName(name);
        setHealth(health);
    }

    public String getName() { return name; }

    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("Name cannot be null");
        String trimmed = name.trim();
        if (trimmed.isEmpty()) throw new IllegalArgumentException("Name cannot be empty");
        
        this.name = Character.toUpperCase(trimmed.charAt(0)) + trimmed.substring(1);
    }

    public int getHealth() { return health; }

    public void setHealth(int health) {
        if (health < 0 || health > 100) {
            throw new IllegalArgumentException("Player health must be between 0 and 100");
        }
        this.health = health;
    }

    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Player{name='%s', health=%d, x=%d, y=%d, collider=%s}",
                name, getHealth(), getX(), getY(), getCollider().toString());
    }
}
