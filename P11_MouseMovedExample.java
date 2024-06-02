import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseMovedExample extends JFrame {

    private DrawPanel drawPanel;

    // Custom JPanel class with updateCircle method
    private static class DrawPanel extends JPanel {
        private int x = -10, y = -10;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillOval(x - 5, y - 5, 10, 10);
        }

        public void updateCircle(int x, int y) {
            this.x = x;
            this.y = y;
            repaint();
        }
    }

    public MouseMovedExample() {
        drawPanel = new DrawPanel();

        drawPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                drawPanel.updateCircle(e.getX(), e.getY());
            }
        });

        add(drawPanel);
        setTitle("Mouse Moved Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MouseMovedExample().setVisible(true));
    }
}
