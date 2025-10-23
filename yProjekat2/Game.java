package yProjekat2;

import java.util.ArrayList;

public class Game {
    private Player player;
    private ArrayList<Enemy> enemies;
    private ArrayList<String> eventLog;

    public Game(Player player) {
        this.player = player;
        this.enemies = new ArrayList<>();
        this.eventLog = new ArrayList<>();
    }

    public boolean checkCollision(Player p, Enemy e) {
        return p.getX() < e.getX() + e.getWidth() &&
               p.getX() + p.getWidth() > e.getX() &&
               p.getY() < e.getY() + e.getHeight() &&
               p.getY() + p.getHeight() > e.getY();
    }

    public void decreaseHealth(Player p, Enemy e) {
        int oldHP = p.getHealth();
        int newHP = oldHP - e.getDamage();
        if (newHP < 0) newHP = 0;
        p.setHealth(newHP);
        String msg = "HIT: " + p.getName() + " by " + e.getType() +
                     " for " + e.getDamage() + " → HP " + oldHP + " -> " + newHP;
        eventLog.add(msg);
    }

    public void addEnemy(Enemy e) {
        enemies.add(e);
        eventLog.add("ADDED: " + e.toString());
    }

    public ArrayList<Enemy> findByType(String query) {
        ArrayList<Enemy> found = new ArrayList<>();
        for (Enemy e : enemies) {
            if (e.getType().toLowerCase().contains(query.toLowerCase().trim())) {
                found.add(e);
            }
        }
        return found;
    }

    public ArrayList<Enemy> collidingWithPlayer() {
        ArrayList<Enemy> hits = new ArrayList<>();
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) hits.add(e);
        }
        return hits;
    }

    public void resolveCollisions() {
        for (Enemy e : collidingWithPlayer()) {
            decreaseHealth(player, e);
        }
    }

    public void printEventLog() {
        System.out.println("\n=== EVENT LOG ===");
        for (String s : eventLog) System.out.println(s);
    }

    public static void main(String[] args) {

    	Player p1 = new Player("   player   one ", null, 10, 5, 32, 32, 85);


    	Game game = new Game(p1);


    	Enemy e1 = new Enemy("Orc", 12, 6, 16, 16, 20);
        game.addEnemy(e1);


        String enemyString = "Goblin: 12,5,16x16;20";
        String[] parts = enemyString.split(":");
        String type = parts[0].trim();
        String[] rest = parts[1].trim().split("[,x;]");
        int ex = Integer.parseInt(rest[0]);
        int ey = Integer.parseInt(rest[1]);
        int ew = Integer.parseInt(rest[2]);
        int eh = Integer.parseInt(rest[3]);
        int dmg = Integer.parseInt(rest[4]);
        Enemy e2 = new Enemy(type, ex, ey, ew, eh, dmg);
        game.addEnemy(e2);


        System.out.println("=== SVI NEPRIJATELJI ===");
        for (Enemy e : game.enemies) System.out.println(e);


        System.out.println("\n=== PRETRAGA: 'gob' ===");
        for (Enemy e : game.findByType("gob")) System.out.println(e);


        System.out.println("\n=== STANJE IGRACA PRIJE KOLIZIJE ===");
        System.out.println(p1);


        game.resolveCollisions();


        System.out.println("\n=== STANJE IGRACA POSLIJE KOLIZIJE ===");
        System.out.println(p1);

        // Ispis event loga
        game.printEventLog();
    }
}