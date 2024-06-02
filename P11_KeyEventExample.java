import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class KeyEventExample extends JFrame {

    private JPanel drawPanel;
    private int squareSize = 50;
    private Color squareColor = Color.BLUE;

    public KeyEventExample() {
        drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(squareColor);
                int x = (getWidth() - squareSize) / 2;
                int y = (getHeight() - squareSize) / 2;
                g.fillRect(x, y, squareSize, squareSize);
            }
        };

        drawPanel.setFocusable(true);
        drawPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    squareSize += 10;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    squareSize = Math.max(10, squareSize - 10);
                } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    squareColor = new Color(new Random().nextInt(0xFFFFFF));
                }
                drawPanel.repaint();
            }
        });

        add(drawPanel);
        setTitle("Key Event Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new KeyEventExample().setVisible(true));
    }
}
