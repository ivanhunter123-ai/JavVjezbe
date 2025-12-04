package examplegame;

import java.util.Objects;

public class CircleCollider implements Collidable {
    private int centerX, centerY;
    private int radius;

    public CircleCollider(int centerX, int centerY, int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be > 0");
        }
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public int getCenterX() { return centerX; }
    public int getCenterY() { return centerY; }
    public int getRadius() { return radius; }

    public void setPosition(int cx, int cy) {
        this.centerX = cx;
        this.centerY = cy;
    }

    @Override
    public boolean intersects(Collidable other) {
        Objects.requireNonNull(other);
        if (other instanceof CircleCollider) {
            CircleCollider c = (CircleCollider) other;
            long dx = this.centerX - c.centerX;
            long dy = this.centerY - c.centerY;
            long rsum = this.radius + c.radius;
            return dx*dx + dy*dy <= rsum*rsum;
        } else if (other instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) other;
            
            int closestX = clamp(this.centerX, r.getX(), r.getX() + r.getWidth());
            int closestY = clamp(this.centerY, r.getY(), r.getY() + r.getHeight());
            long dx = this.centerX - closestX;
            long dy = this.centerY - closestY;
            return dx*dx + dy*dy <= (long)this.radius * this.radius;
        } else {
            return false;
        }
    }

    private int clamp(int val, int min, int max) {
        if (val < min) return min;
        if (val > max) return max;
        return val;
    }

    @Override
    public String toString() {
        return String.format("Circle[cx=%d,cy=%d,r=%d]", centerX, centerY, radius);
    }
}
