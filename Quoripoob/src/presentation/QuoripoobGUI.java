package Quoripoob.src.presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class QuoripoobGUI extends JFrame{

    // Constants Screen
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int WIDTH = (int) (3 * screenSize.getWidth() / 4);
    private static final int HEIGHT = (int) (3 * screenSize.getHeight() / 4);

    // Panel Menu
    private JMenuItem itemNewGame;
    private JMenuItem itemLoadGame;
    private JMenuItem itemSaveGame;
    private JMenuItem itemExit;

    // Panel Game
    private JPanel panelGame;

    //buttons game
    private JButton buttonPlay;

    /**
     * Method to prepare the menu
     * @return JMenuBar
     */
    private JMenuBar preparateElementsMenu(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menuGame = new JMenu("File");
        itemNewGame = new JMenuItem("New Game");
        itemLoadGame = new JMenuItem("Load Game");
        itemSaveGame = new JMenuItem("Save Game");
        itemExit = new JMenuItem("Exit");
        menuGame.add(itemNewGame);
        menuGame.add(itemLoadGame);
        menuGame.add(itemSaveGame);
        menuGame.addSeparator();
        menuGame.add(itemExit);
        menuBar.add(menuGame);
        return menuBar;
    }

    /**
     * Method to prepare the elements of the screen
     */
    private void preparateElements() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setTitle("Quoripoob");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setJMenuBar(preparateElementsMenu());
        prepareElemetsStart();
    }

    /**
     * Method to prepare the actions of the menu
     */
    private void prepareMenuActions() {
        itemExit.addActionListener(e -> closeOption());
    }

    /**
     * Method to prepare the elements of the start screen
     */
    private void prepareElemetsStart() {
        JPanel panelStart = new JPanel(new GridLayout(6, 5, 10, 10)); // Establecer el GridLayout con espaciado
        panelStart.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Establecer un borde interno
        // Agregar etiquetas vacías en la primera fila
        for (int i = 0; i < 7; i++) {
            panelStart.add(new JLabel());
        }
        // Agregar el título
        JLabel labelTitle = new JLabel("Quoripoob");
        labelTitle.setFont(new Font("Arial", Font.BOLD, 30));
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitle.setText("<html><font color='black'>Quoripoob</font></html>");
        panelStart.add(labelTitle);
        // Agregar etiquetas vacías en la segunda fila
        for (int i = 0; i < 4; i++) {
            panelStart.add(new JLabel());
        }
        // Agregar la imagen
        ImageIcon image = new ImageIcon("Quoripoob/src/presentation/Img/Fondo.jpeg");
        JLabel labelImage = new JLabel(image) {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        panelStart.add(labelImage);
        // Agregar etiquetas vacías en la cuarta fila
        for (int i = 0; i < 4; i++) {
            panelStart.add(new JLabel());
        }
        // Agregar el botón "Play"
        buttonPlay = new JButton("Play");
        buttonPlay.setFont(new Font("Arial", Font.BOLD, 25));
        buttonPlay.setForeground(Color.WHITE);
        buttonPlay.setBackground(new Color(51, 153, 255));
        buttonPlay.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonPlay.setFocusPainted(false);
        buttonPlay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonPlay.setBackground(new Color(102, 178, 255));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                buttonPlay.setBackground(new Color(51, 153, 255));
            }

            public void mouseClicked(MouseEvent e) {
                //panelStart.setVisible(false);
                //prepareGamePanel();3
                GameConfig gameConfig = new GameConfig();
                gameConfig.setVisible(true);
            }
        });
        panelStart.add(buttonPlay);
        // Agregar etiquetas vacías en la última fila
        for (int i = 0; i < 4; i++) {
            panelStart.add(new JLabel());
        }
        //Boton Creditos
        JButton buttonCredits = new JButton("Credits");
        buttonCredits.setFont(new Font("Arial", Font.BOLD, 25));
        buttonCredits.setForeground(Color.WHITE);
        buttonCredits.setBackground(new Color(51, 153, 255));
        buttonCredits.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonCredits.setFocusPainted(false);
        buttonCredits.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonCredits.setBackground(new Color(102, 178, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonCredits.setBackground(new Color(51, 153, 255));
            }
        });
        panelStart.add(buttonCredits);
        for (int i = 0; i < 2; i++) {
            panelStart.add(new JLabel());
        }
        add(panelStart, BorderLayout.CENTER);
    }

    /**
     * Method to prepare the actions
     */
    private void preparateActions() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                closeOption();
            }
        });
        prepareMenuActions();
    }

    /**
     * Constructor
     */
    private QuoripoobGUI() {
        preparateElements();
        preparateActions();

    }

    /**
     * Method to close the application
     */
    private void closeOption(){
        int yesNo = JOptionPane.showOptionDialog(null, "Are you sure you want exit?", "Warning",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, "No");
        if (yesNo == JOptionPane.YES_OPTION) {
            setVisible(false);
            System.exit(0);
        }
    }


    private void prepareGamePanel() {
        panelGame = new JPanel();
        panelGame.setLayout(new GridLayout(8, 8));
        panelGame.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        for (int i = 0; i < 64; i++) {
            JButton button = new JButton();
            button.setBackground(Color.WHITE);
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panelGame.add(button);
        }
        //add botton to back
        JButton buttonBack = new JButton("Back");
        buttonBack.setFont(new Font("Arial", Font.BOLD, 25));
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setBackground(new Color(51, 153, 255));
        buttonBack.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonBack.setFocusPainted(false);
        buttonBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonBack.setBackground(new Color(102, 178, 255));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                buttonBack.setBackground(new Color(51, 153, 255));
            }

            public void mouseClicked(MouseEvent e) {
                panelGame.setVisible(false);
                prepareElemetsStart();
            }
        });
        panelGame.add(buttonBack);

        add(panelGame, BorderLayout.CENTER);
    }



    /**
     * Main method
     * @param args Arguments

     */
    public static void main(String[] args) {
        QuoripoobGUI gui = new QuoripoobGUI();
        gui.setVisible(true);
    }

}
