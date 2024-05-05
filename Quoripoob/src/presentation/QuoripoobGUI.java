package Quoripoob.src.presentation;

import Quoripoob.src.domain.Quoridor;
import Quoripoob.src.domain.QuoridorException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class QuoripoobGUI extends JFrame{

    // Constants Screen
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int WIDTH = (int) (3 * screenSize.getWidth() / 4);
    private static final int HEIGHT = (int) (3 * screenSize.getHeight() / 4);

    private Quoridor quoridor;

    // Panel Menu
    private JMenuItem itemNewGame;
    private JMenuItem itemLoadGame;
    private JMenuItem itemSaveGame;
    private JMenuItem itemExit;

    // Panel Game
    private JPanel panelGame;

    //buttons game
    private JButton buttonPlay;
    private JPanel player1;
    private JPanel player2;

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
        QuoripoobGUI parent = this;

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
                try {
                    GameConfig gameConfig = new GameConfig(parent);
                } catch (QuoridorException ex) {
                    throw new RuntimeException(ex);
                }
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

            public void mouseClicked(MouseEvent e) {
                CreditsGUI credits = new CreditsGUI();
                credits.setVisible(true);
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

    /*
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
    }*/



    /**
     * Main method
     * @param args Arguments

     */
    public static void main(String[] args) {
        QuoripoobGUI gui = new QuoripoobGUI();
        gui.setVisible(true);
    }

    private void refersh(){
        revalidate();
        repaint();
    }

    public void prepareElemtsGame() {
        this.quoridor = Quoridor.getQuoridor();
        getContentPane().removeAll();
        refersh();

        // Crear un panel principal con un BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel para el jugador 1
        player1 = new JPanel();
        player1.setBackground(Color.LIGHT_GRAY);
        player1.setBorder(BorderFactory.createTitledBorder("Player 1"));
        // Agrega los componentes necesarios para mostrar la información del jugador 1
        mainPanel.add(player1, BorderLayout.WEST);

        // Panel para la matriz del juego y el indicador de tiempo
        JPanel gamePanel = new JPanel(new BorderLayout());

        // Crear el indicador de tiempo
        JLabel timeLabel = new JLabel("Time: 00:00");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        timeLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gamePanel.add(timeLabel, BorderLayout.NORTH);

        // Crear la matriz del juego
        JPanel boardPanel = new JPanel(null); // Usar un layout nulo para posicionar los botones manualmente

        JButton[][] boardButtons = new JButton[17][17];

        // Agregar las fichas de los jugadores
        JPanel player1Piece = new JPanel();
        player1Piece.setBackground(Color.RED); // Cambiar el color según sea necesario
        player1Piece.setPreferredSize(new Dimension(30, 30));
        player1Piece.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        JPanel player2Piece = new JPanel();
        player2Piece.setBackground(Color.BLUE); // Cambiar el color según sea necesario
        player2Piece.setPreferredSize(new Dimension(30, 30));
        player2Piece.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 17; j++) {
                boardButtons[i][j] = new JButton();

                int x = 0;
                int y = 0;
                int width = 0;
                int height = 0;

                // Boton grande posicion 0,0
                if (i % 2 == 0 && j % 2 == 0) {
                    x = i / 2 * 70;
                    y = j / 2 * 70;
                    width = 60;
                    height = 60;
                    boardButtons[i][j].setBackground(new Color(61, 76, 149));
                    boardButtons[i][j].setBorder(BorderFactory.createEmptyBorder());

                    // Agregar las fichas de los jugadores en las posiciones iniciales
                    if (i == 0 && j == 0) {
                        //player1Piece.setBounds(x + 10, y + 10, 40, 40);
                        boardPanel.add(player1Piece);
                    } else if (i == 16 && j == 16) {
                        //player2Piece.setBounds(x + 10, y + 10, 40, 40);
                        boardPanel.add(player2Piece);
                    }
                } else if (i % 2 == 0 && j % 2 != 0) {
                    x = i / 2 * 70;
                    y = (j - 1) / 2 * 70 + 60;
                    width = 60;
                    height = 10;
                    boardButtons[i][j].setBackground(new Color(234, 12, 12));
                    boardButtons[i][j].setBorder(BorderFactory.createEmptyBorder());
                } else if (i % 2 != 0 && j % 2 == 0) { // Botón delgado en la posición 1,0
                    x = (i - 1) / 2 * 70 + 60;
                    y = j / 2 * 70;
                    width = 10;
                    height = 60;
                    boardButtons[i][j].setBackground(new Color(234, 12, 12));
                    boardButtons[i][j].setBorder(BorderFactory.createEmptyBorder());
                } else if (i % 2 != 0 && j % 2 != 0) { // Botón cuadrado sin bordes en la posición 1,1
                    x = (i - 1) / 2 * 70 + 60;
                    y = (j - 1) / 2 * 70 + 60;
                    width = 10;
                    height = 10;
                    boardButtons[i][j].setBackground(new Color(234, 12, 12));
                    boardButtons[i][j].setBorder(BorderFactory.createEmptyBorder());
                }

                boardButtons[i][j].setBounds(x, y, width, height);
                boardPanel.add(boardButtons[i][j]);
            }
        }
        boardButtons[8][0].add(player1Piece);
        boardButtons[8][16].add(player2Piece);

        gamePanel.add(boardPanel, BorderLayout.CENTER);
        mainPanel.add(gamePanel, BorderLayout.CENTER);

        // Panel para el jugador 2
        player2 = new JPanel();
        player2.setBackground(Color.LIGHT_GRAY);
        player2.setBorder(BorderFactory.createTitledBorder("Player 2"));
        // Agrega los componentes necesarios para mostrar la información del jugador 2
        mainPanel.add(player2, BorderLayout.EAST);

        prepareElemtsPlayers();

        // Agrega el panel principal al ContentPane
        add(mainPanel, BorderLayout.CENTER);
        refersh();
    }


    /**
     * Método para preparar los elementos del jugador 1
     */
    private void prepareElementsPlayer1() {
        player1.removeAll();
        refersh();

        // Agregar los componentes necesarios para mostrar la información del jugador 1
        JLabel labelPlayer1 = new JLabel("Player 1");
        player1.add(labelPlayer1);

        // Crear un panel para el JComboBox y la etiqueta
        JPanel bridgePanel = new JPanel();
        bridgePanel.setLayout(new BoxLayout(bridgePanel, BoxLayout.Y_AXIS));

        // Crear una etiqueta para el JComboBox
        JLabel bridgeLabel = new JLabel("Tipo de barrera:");
        bridgeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        bridgeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Crear el JComboBox con las opciones de puentes/barreras
        String[] options = {"Normal", "Temporal", "Larga", "Barreras aliadas"};
        JComboBox<String> bridgeComboBox = new JComboBox<>(options);

        // Personalizar el estilo del JComboBox
        bridgeComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        bridgeComboBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        bridgeComboBox.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Agregar la etiqueta y el JComboBox al panel
        bridgePanel.add(bridgeLabel);
        bridgePanel.add(Box.createVerticalStrut(5)); // Espacio entre la etiqueta y el JComboBox
        bridgePanel.add(bridgeComboBox);

        player1.add(bridgePanel);

        refersh();
    }

    /**
     * Método para preparar los elementos de los jugadores
     */
    private void prepareElementsPlayer2() {
        player2.removeAll();
        refersh();

        // Agregar los componentes necesarios para mostrar la información del jugador 2
        JLabel labelPlayer2 = new JLabel("Player 2");
        player2.add(labelPlayer2);

        // Crear un panel para el JComboBox y la etiqueta
        JPanel bridgePanel = new JPanel();
        bridgePanel.setLayout(new BoxLayout(bridgePanel, BoxLayout.Y_AXIS));

        // Crear una etiqueta para el JComboBox
        JLabel bridgeLabel = new JLabel("Tipo de barrera:");
        bridgeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        bridgeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Crear el JComboBox con las opciones de puentes/barreras
        String[] options = {"Normal", "Temporal", "Larga", "Barreras aliadas"};
        JComboBox<String> bridgeComboBox = new JComboBox<>(options);

        // Personalizar el estilo del JComboBox
        bridgeComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        bridgeComboBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        bridgeComboBox.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Agregar la etiqueta y el JComboBox al panel
        bridgePanel.add(bridgeLabel);
        bridgePanel.add(Box.createVerticalStrut(5)); // Espacio entre la etiqueta y el JComboBox
        bridgePanel.add(bridgeComboBox);



        //Mostrar barreras


        JLabel labelBridges = new JLabel("Barreras:");
        labelBridges.setFont(new Font("Arial", Font.BOLD, 14));
        labelBridges.setAlignmentX(Component.LEFT_ALIGNMENT);
        bridgePanel.add(labelBridges);

        // Crear un panel para las barreras
        JPanel bridgesPanel = new JPanel();
        bridgesPanel.setLayout(new BoxLayout(bridgesPanel, BoxLayout.Y_AXIS));

        // Crear las etiquetas para las barreras
        JLabel normalLabel = new JLabel("Normales: 10");
        normalLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        normalLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel temporalLabel = new JLabel("Temporales: 10");
        temporalLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        temporalLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel longLabel = new JLabel("Largas: 5");
        longLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        longLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel allyLabel = new JLabel("Aliadas: 5");
        allyLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        allyLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Agregar las etiquetas al panel
        bridgesPanel.add(normalLabel);
        bridgesPanel.add(temporalLabel);
        bridgesPanel.add(longLabel);
        bridgesPanel.add(allyLabel);

        // Agregar el panel de las barreras al panel principal
        bridgePanel.add(bridgesPanel);

        player2.add(bridgePanel);
        refersh();

    }

    private void prepareElemtsPlayers(){
        prepareElementsPlayer1();
        prepareElementsPlayer2();
    }
}
