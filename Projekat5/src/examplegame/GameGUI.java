package examplegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class GameGUI extends JFrame {
    private final JTextField nameField = new JTextField(15);
    private final JTextField healthField = new JTextField(3);
    private final JTextField xField = new JTextField(4);
    private final JTextField yField = new JTextField(4);
    private final JRadioButton rectRadio = new JRadioButton("Rectangle (32x32)");
    private final JRadioButton circleRadio = new JRadioButton("Circle (r=16)");
    private final JTextArea outputArea = new JTextArea(20, 50);
    private final JButton runButton = new JButton("Pokreni igru");

    public GameGUI() {
        super("Simple Game - GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createLayout();
        pack();
        setLocationRelativeTo(null);
        runButton.addActionListener(e -> onRun());
    }

    private void createLayout() {
        JPanel input = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4,4,4,4);
        c.gridx = 0; c.gridy = 0; input.add(new JLabel("Name:"), c);
        c.gridx = 1; input.add(nameField, c);

        c.gridx = 0; c.gridy++; input.add(new JLabel("Health (0-100):"), c);
        c.gridx = 1; input.add(healthField, c);

        c.gridx = 0; c.gridy++; input.add(new JLabel("X:"), c);
        c.gridx = 1; input.add(xField, c);

        c.gridx = 0; c.gridy++; input.add(new JLabel("Y:"), c);
        c.gridx = 1; input.add(yField, c);

        ButtonGroup group = new ButtonGroup();
        group.add(rectRadio); group.add(circleRadio);
        rectRadio.setSelected(true);

        c.gridx = 0; c.gridy++; input.add(rectRadio, c);
        c.gridx = 1; input.add(circleRadio, c);

        c.gridx = 0; c.gridy++; c.gridwidth = 2; input.add(runButton, c);

        outputArea.setEditable(false);
        outputArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        setLayout(new BorderLayout());
        add(input, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    private void onRun() {
        // Clear output
        outputArea.setText("");
        try {
            String name = nameField.getText();
            int health = Integer.parseInt(healthField.getText().trim());
            int x = Integer.parseInt(xField.getText().trim());
            int y = Integer.parseInt(yField.getText().trim());

            Collidable collider;
            if (rectRadio.isSelected()) {
                collider = new RectangleCollider(x, y, 32, 32);
            } else {
                collider = new CircleCollider(x, y, 16);
            }

            Player p = new Player(name, health, x, y, collider);
            Game game = new Game();
            game.setPlayer(p);

            // Attempt to load enemies.csv from working dir
            String csvPath = "enemies.csv";
            List<Enemy> enemies;
            try {
                enemies = Game.loadEnemiesFromCSV(csvPath);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this,
                        "Failed to load enemies.csv: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                outputArea.append("ERROR loading CSV: " + ex.getMessage() + "\n");
                return;
            }

            for (Enemy e : enemies) game.addEnemy(e);

            // Resolve collisions and display
            game.resolveCollisions();

            // Display results
            outputArea.append("=== PLAYER STATUS ===\n");
            outputArea.append(game.getPlayer().toString() + "\n\n");

            outputArea.append("=== ALL ENEMIES ===\n");
            for (Enemy e : game.getEnemies()) {
                outputArea.append(e.toString() + "\n");
            }
            outputArea.append("\n");

            outputArea.append("=== COLLIDING WITH PLAYER ===\n");
            List<Enemy> colliding = game.collidingWithPlayer();
            if (colliding.isEmpty()) {
                outputArea.append("None\n");
            } else {
                for (Enemy e : colliding) outputArea.append(e.toString() + "\n");
            }
            outputArea.append("\n");

            outputArea.append("=== EVENT LOG ===\n");
            for (String l : game.getLog()) outputArea.append(l + "\n");

            // Messages if player defeated or all enemies resolved
            if (game.getPlayer().getHealth() <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Player defeated!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Round finished. Player health: " + game.getPlayer().getHealth(),
                        "Result", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid integers for health/x/y.", "Input error", JOptionPane.WARNING_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input: " + ex.getMessage(), "Input error", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Unexpected error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameGUI g = new GameGUI();
            g.setVisible(true);
        });
    }
}

