package examplegame;

public abstract class GameObject {
    private int x;
    private int y;
    private Collidable collider;

    public GameObject(int x, int y, Collidable collider) {
        if (collider == null) throw new IllegalArgumentException("Collider cannot be null");
        this.x = x;
        this.y = y;
        this.collider = collider;
        
        syncColliderPosition();
    }

    private void syncColliderPosition() {
        if (collider instanceof RectangleCollider) {
            ((RectangleCollider) collider).setPosition(x, y);
        } else if (collider instanceof CircleCollider) {
            ((CircleCollider) collider).setPosition(x, y);
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void setX(int x) {
        this.x = x;
        syncColliderPosition();
    }
    public void setY(int y) {
        this.y = y;
        syncColliderPosition();
    }
    public Collidable getCollider() { return collider; }

    public void setCollider(Collidable collider) {
        if (collider == null) throw new IllegalArgumentException("Collider cannot be null");
        this.collider = collider;
        syncColliderPosition();
    }

    public boolean intersects(GameObject other) {
        return this.collider.intersects(other.getCollider());
    }

    public abstract String getDisplayName();

    @Override
    public String toString() {
        return String.format("%s at (%d,%d) collider=%s", getDisplayName(), x, y, collider.toString());
    }
}