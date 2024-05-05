package Quoripoob.src.presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Component;
import java.awt.Toolkit;

public class CreditsGUI extends JFrame {

    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int WIDTH = (int) (3 * screenSize.getWidth() / 5);
    private static final int HEIGHT = (int) (3 * screenSize.getHeight() / 5);

    private void prepareElements() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setTitle("Quoripoob Credits");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void addComponents() {
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("CREDITS", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        contentPanel.add(title, BorderLayout.NORTH);

        JTextArea text = new JTextArea();
        text.setText("This game was developed by:\n\n" +
                "Diego Alexander Cardenas Beltran\n\n" +
                "Sebastian Cardona Parr\n\n" +
                "This project has been carried out as a final project for the object-oriented programming (POOB) subject.\n\n" +
                "For the Universidad Escuela Colombiana de Ingenieria Julio Garavito\n\n"
        );
        text.setFont(new Font("Arial", Font.PLAIN, 20));
        text.setEditable(false);
        text.setOpaque(false);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(text, BorderLayout.CENTER);
        add(contentPanel, BorderLayout.CENTER);
    }

    public CreditsGUI() {
        prepareElements();
        addComponents();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CreditsGUI());
    }
}