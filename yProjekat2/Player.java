package yProjekat2;


public class Player {
    private String name;
    private String type;
    private int x, y;
    private int width, height;
    private int health; // 0–100

    public Player(String name, String type, int x, int y, int width, int height, int health) {
        setName(name);
        this.type = type;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.health = Math.min(100, Math.max(0, health));
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "Unknown";
        } else {
            name = name.trim().replaceAll("\\s+", " ");
            String[] words = name.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String w : words) {
                if (w.length() > 0) {
                    sb.append(Character.toUpperCase(w.charAt(0)))
                      .append(w.substring(1).toLowerCase())
                      .append(" ");
                }
            }
            this.name = sb.toString().trim();
        }
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = Math.max(0, Math.min(100, health)); }

    @Override
    public String toString() {
        return "Player [" + name + "] (" + type + ") HP=" + health + " Pos=(" + x + "," + y + ")";
    }
}
