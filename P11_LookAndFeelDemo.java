import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LookAndFeelDemo extends JFrame {
    private JTextArea textArea;

    public LookAndFeelDemo() {
        setTitle("Look and Feel and Edit Demo");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Create panel for edit buttons
        JPanel editButtonPanel = new JPanel();
        JButton cutButton = new JButton("Cut");
        JButton copyButton = new JButton("Copy");
        JButton pasteButton = new JButton("Paste");

        cutButton.addActionListener(e -> textArea.cut());
        copyButton.addActionListener(e -> textArea.copy());
        pasteButton.addActionListener(e -> textArea.paste());

        editButtonPanel.add(cutButton);
        editButtonPanel.add(copyButton);
        editButtonPanel.add(pasteButton);

        add(editButtonPanel, BorderLayout.NORTH);

        // Create panel for look and feel buttons
        JPanel lookAndFeelButtonPanel = new JPanel();
        JButton motifButton = new JButton("Motif");
        JButton windowsButton = new JButton("Windows");
        JButton metalButton = new JButton("Metal");

        motifButton.addActionListener(e -> setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"));
        windowsButton.addActionListener(e -> setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"));
        metalButton.addActionListener(e -> setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"));

        lookAndFeelButtonPanel.add(motifButton);
        lookAndFeelButtonPanel.add(windowsButton);
        lookAndFeelButtonPanel.add(metalButton);

        add(lookAndFeelButtonPanel, BorderLayout.SOUTH);
    }

    private void setLookAndFeel(String lookAndFeel) {
        try {
            UIManager.setLookAndFeel(lookAndFeel);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new LookAndFeelDemo().setVisible(true));
    }
}
