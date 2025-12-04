package examplegame;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private Player player;
    private final List<Enemy> enemies = new ArrayList<>();
    private final List<String> log = new ArrayList<>();

    public Game() {}

    public void setPlayer(Player player) {
        this.player = player;
        log.add("Player created: " + player.toString());
    }

    public Player getPlayer() { return player; }
    public List<Enemy> getEnemies() { return enemies; }
    public List<String> getLog() { return log; }

    public boolean checkCollision(Player p, Enemy e) {
        return p.intersects(e);
    }

    public void decreaseHealth(Player p, Enemy e) {
        int dmg = e.getEffectiveDamage();
        int old = p.getHealth();
        int ny = Math.max(0, old - dmg);
        p.setHealth(ny);
        log.add(String.format("Enemy '%s' dealt %d damage to player '%s'. Health %d -> %d",
                e.getType(), dmg, p.getName(), old, ny));
    }

    public void addEnemy(Enemy e) {
        enemies.add(e);
        log.add("Added enemy: " + e.toString());
    }

    public List<Enemy> findByType(String query) {
        if (query == null) return Collections.emptyList();
        String q = query.toLowerCase();
        return enemies.stream()
                .filter(en -> en.getType().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public List<Enemy> collidingWithPlayer() {
        if (player == null) return Collections.emptyList();
        return enemies.stream().filter(en -> checkCollision(player, en)).collect(Collectors.toList());
    }

    public void resolveCollisions() {
        if (player == null) return;
        for (Enemy e : new ArrayList<>(enemies)) {
            if (checkCollision(player, e)) {
                decreaseHealth(player, e);
              
                if (player.getHealth() <= 0) {
                    log.add("Player defeated by enemy: " + e.getType());
                }
            }
        }
    }

 
    public static List<Enemy> loadEnemiesFromCSV(String filePath) {
        List<Enemy> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineno = 0;
            while ((line = br.readLine()) != null) {
                lineno++;
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue; // skip
                String[] cols = line.split(",", -1);
                if (cols.length < 9) {
                    throw new IllegalArgumentException("Invalid record at line " + lineno + ": not enough fields");
                }
                String type = cols[0].trim();
                String clazz = cols[1].trim().toLowerCase();
                int x = parseIntOrThrow(cols[2], "x", lineno);
                int y = parseIntOrThrow(cols[3], "y", lineno);
                String shape = cols[4].trim().toLowerCase();
                String dim1s = cols[5].trim();
                String dim2s = cols[6].trim();
                int damage = parseIntOrThrow(cols[7], "damage", lineno);
                int health = parseIntOrThrow(cols[8], "health", lineno);

                Collidable collider;
                if ("rect".equals(shape)) {
                    int w = parseIntOrThrow(dim1s, "width", lineno);
                    int h = parseIntOrThrow(dim2s, "height", lineno);
                    collider = new RectangleCollider(x, y, w, h);
                } else if ("circle".equals(shape)) {
                    int r = parseIntOrThrow(dim1s, "radius", lineno);
                    collider = new CircleCollider(x, y, r);
                } else {
                    throw new IllegalArgumentException("Unknown shape at line " + lineno + ": " + shape);
                }

                Enemy e;
                if ("melee".equals(clazz)) {
                    e = new MeleeEnemy(type, damage, health, x, y, collider);
                } else if ("boss".equals(clazz)) {
                    e = new BossEnemy(type, damage, health, x, y, collider);
                } else {
                    throw new IllegalArgumentException("Unknown enemy class at line " + lineno + ": " + clazz);
                }

                list.add(e);
            }
        } catch (FileNotFoundException ex) {
            throw new IllegalArgumentException("CSV file not found: " + filePath, ex);
        } catch (IOException ex) {
            throw new IllegalArgumentException("I/O error while reading CSV: " + ex.getMessage(), ex);
        }
        return list;
    }

    private static int parseIntOrThrow(String s, String fieldName, int lineno) {
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception ex) {
            throw new IllegalArgumentException("Invalid integer for '" + fieldName + "' at line " + lineno + ": '" + s + "'");
        }
    }
}

