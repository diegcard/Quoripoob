package Quoripoob.src.presentation;

import Quoripoob.src.domain.*;
import Quoripoob.src.domain.QuoridorException;

import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GameConfig extends JFrame {
    // Constants Screen
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int WIDTH = (int) (3 * screenSize.getWidth() / 5);
    private static final int HEIGHT = (int) (3 * screenSize.getHeight() / 5);

    private QuoripoobGUI quoripoobGUI;

    //private Quoridor quoridor;

    private JTextField gameSizeField;


    private JComboBox<String> gameMode;
    private JTextField limitContraleoj;
    private JTextField limitCronometrado;

    private JTextField player1Name;
    private JTextField player2Name;
    private Color player1Color;
    private Color player2Color;
    private JComboBox<String> gamePlayers;
    private JComboBox<String> machine1;
    private JComboBox<String> machine2;
    private JButton player1ColorButton;
    private JButton player2ColorButton;
    private JButton buttonStartGame;


    /**
     * Method to prepare the elements of the screen
     */
    private void preparateElement() {
        /*try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }*/
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (InstantiationException | IllegalAccessException
                 | UnsupportedLookAndFeelException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        setTitle("Quoripoob ANGIE CUTE");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        this.add(preparateElementsStartConfig());
        prepareActionsGae();
    }

    /**
     * Method to prepare the elements of the screen
     */
    private JPanel preparateElementsStartConfig() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        panel.add(preparateElementsStartConfigGameSize());
        panel.add(preparateElemetsStarConfigGameMode());
        panel.add(preparateElementsStartConfigPlayer());
        panel.add(preparateElemtsStartCreateGame());

        return panel;
    }

    /**
     * Method to prepare the elements of the screen
     */
    private JPanel preparateElementsStartConfigGameSize(){
        JPanel panel = new JPanel();
        panel.setBorder(new CompoundBorder(new EmptyBorder(0,0,0,0), new TitledBorder("Game Size")));
        panel.setLayout(new GridLayout(1,2, WIDTH/16,0));
        panel.add(new JLabel("Game Size: "));
        gameSizeField = new JTextField("9");
        panel.add(gameSizeField);
        return panel;
    }

    /**
     * Method to prepare the elements of the screen
     */
    private JPanel preparateElemetsStarConfigGameMode(){
        JPanel panel = new JPanel();
        panel.setBorder(new CompoundBorder(new EmptyBorder(0,0,0,0), new TitledBorder("Game Mode")));
        panel.setLayout(new GridLayout(1,2, WIDTH/16,0));
        panel.add(new JLabel("Game Mode: "));
        gameMode = new JComboBox<>();
        gameMode.addItem("Normal");
        gameMode.addItem("Contrarreloj");
        gameMode.addItem("Cronometrado");

        limitContraleoj = new JTextField("Limit contrarreloj");
        limitContraleoj.setEditable(false);
        limitContraleoj.setEnabled(false);
        limitCronometrado = new JTextField("Limit cronometrado");
        limitCronometrado.setEditable(false);
        limitCronometrado.setEnabled(false);
        panel.add(gameMode);
        panel.add(limitContraleoj);
        panel.add(limitCronometrado);
        return panel;
    }

    /**
     * Method to prepare the elements of the screen
     */
    private JPanel preparateElementsStartConfigPlayer(){
        JPanel panel = new JPanel();
        panel.setBorder(new CompoundBorder(new EmptyBorder(0,0,0,0), new TitledBorder("Players")));
        panel.setLayout(new GridLayout(0,3, WIDTH/16,0));
        panel.add(new JLabel("Player: "));

        player1Color = new Color(255, 0, 0);
        player1ColorButton = new JButton("Color");

        player2Color = new Color(0, 0, 255);
        player2ColorButton = new JButton("Color");

        panel.add(player1ColorButton);
        panel.add(player2ColorButton);
        gamePlayers = new JComboBox<>();

        gamePlayers.addItem("Player vs Player");
        gamePlayers.addItem("Player vs Machine");
        gamePlayers.addItem("Machine vs Machine");

        player1Name = new JTextField("Player 1");
        player2Name = new JTextField("Player 2");

        panel.add(gamePlayers);
        panel.add(player1Name);
        panel.add(player2Name);
        panel.add(new JLabel());

        machine1 = new JComboBox<>();
        machine1.addItem("Principiante");
        machine1.addItem("Intermedio");
        machine1.addItem("Avanzado");
        machine2 = new JComboBox<>();
        machine2.addItem("Principiante");
        machine2.addItem("Intermedio");
        machine2.addItem("Avanzado");

        machine1.setEnabled(false);
        machine2.setEnabled(false);

        panel.add(machine1);
        panel.add(machine2);


        return panel;
    }

    /**
     * Method to prepare the elements of the screen
     */
    private JPanel preparateElemtsStartCreateGame(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,3));
        panel.add(new JLabel());
        buttonStartGame = new JButton("Create Game");
        buttonStartGame.setFont(new Font("Arial", Font.BOLD, 25));
        buttonStartGame.setForeground(Color.BLACK);
        buttonStartGame.setBackground(new Color(51, 153, 255));
        buttonStartGame.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonStartGame.setFocusPainted(false);
        panel.add(buttonStartGame);
        panel.add(new JLabel());
        return panel;
    }

    /**
     * Method to prepare the actions
     */
    private void prepareActionsStarConfigPlayer(){
        gamePlayers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> combo = (JComboBox<String>) e.getSource();
                String selected = (String) combo.getSelectedItem();
                if (selected.equals("Player vs Player")) {
                    player1Name.setEditable(true);
                    player1Name.setEnabled(true);
                    player2Name.setEditable(true);
                    player2Name.setEnabled(true);
                    machine1.setEnabled(false);
                    machine2.setEnabled(false);
                } else if (selected.equals("Player vs Machine")) {
                    player1Name.setEditable(true);
                    player1Name.setEnabled(true);
                    player2Name.setEditable(false);
                    player2Name.setEnabled(false);
                    machine1.setEnabled(false);
                    machine2.setEnabled(true);
                } else if (selected.equals("Machine vs Machine")) {
                    player1Name.setEditable(false);
                    player1Name.setEnabled(false);
                    player2Name.setEditable(false);
                    player2Name.setEnabled(false);
                    machine1.setEnabled(true);
                    machine2.setEnabled(true);
                }
            }
        });

        player1ColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(null, "Choose a color", player1Color);
                if (color != null) {
                    player1Color = color;
                    player1ColorButton.setBackground(player1Color);
                }
            }
        });

        player2ColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(null, "Choose a color", player2Color);
                if (color != null) {
                    player2Color = color;
                    player2ColorButton.setBackground(player2Color);
                }
            }
        });
    }

    /**
     * Method to prepare the actions
     */
    private void prepareActionsStarConfigGameMode(){
        gameMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> combo = (JComboBox<String>) e.getSource();
                String selected = (String) combo.getSelectedItem();
                if (selected.equals("Normal")) {
                    limitContraleoj.setEditable(false);
                    limitContraleoj.setEnabled(false);
                    limitContraleoj.setText("Limit contrarreloj");
                    limitCronometrado.setEditable(false);
                    limitCronometrado.setEnabled(false);
                    limitCronometrado.setText("Limit cronometradooooo");
                } else if (selected.equals("Contrarreloj")) {
                    limitContraleoj.setEditable(true);
                    limitContraleoj.setEnabled(true);
                    limitCronometrado.setEditable(false);
                    limitCronometrado.setEnabled(false);
                    limitCronometrado.setText("Limit cronometrado");
                } else if (selected.equals("Cronometrado")) {
                    limitContraleoj.setEditable(false);
                    limitContraleoj.setEnabled(false);
                    limitContraleoj.setText("Limit contrarreloj");
                    limitCronometrado.setEditable(true);
                    limitCronometrado.setEnabled(true);
                }
            }

        });
    }

    private void prepareActionsStarConfigGameSize(GameConfig parent){
        buttonStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int size = Integer.parseInt(gameSizeField.getText());
                    if(size < 9 && size % 2 != 0){
                        JOptionPane.showMessageDialog(null, "The size must be greater than 9 and is different from odd", "Error", JOptionPane.ERROR_MESSAGE);
                    }else{
                        quoripoobGUI.setQuoridor(new Quoridor());
                        quoripoobGUI.getQuoridor().setSize(Integer.parseInt(gameSizeField.getText()));
                        prapareInfomationsPlayers();
                        parent.dispose();
                        quoripoobGUI.prepareElemtsGame();
                    }
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "The size must be a number", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

    /**
     * Method to prepare the actions of the screen
     */
    private void prepareActionsGae(){
        prepareActionsStarConfigGameMode();
        prepareActionsStarConfigPlayer();
    }

    /**
     * Constructor
     */
    public GameConfig(QuoripoobGUI quoripoobGUI) throws QuoridorException {
        preparateElement();
        this.quoripoobGUI = quoripoobGUI;
        this.setVisible(true);
        prepareActionsStarConfigGameSize(this);
    }

    private void prapareInfomationsPlayers(){
        HashMap<String, Integer> walls = new HashMap<>();
        walls.put("Normal", 7);
        walls.put("Temporales", 3);
        walls.put("Largas", 3);
        walls.put("Aliadas", 3);

        if (gamePlayers.getSelectedItem().equals("Player vs Player")) {
            //Config player one
            Player playerOne = new NormalPlayer();
            playerOne.setName(player1Name.getText());
            playerOne.setColor(player1Color);
            playerOne.setWalls(walls);
            quoripoobGUI.getQuoridor().setPlayerOne(playerOne);


            //Config player two
            Player playerTwo = new NormalPlayer();
            playerTwo.setName(player2Name.getText());
            playerTwo.setColor(player2Color);
            playerTwo.setWalls(walls);
            quoripoobGUI.getQuoridor().setPlayerTwo(playerTwo);

            quoripoobGUI.getQuoridor().setGameMode(gameMode.getSelectedItem().toString());

            quoripoobGUI.getQuoridor().setSize(Integer.parseInt(gameSizeField.getText()));

        } else if (gamePlayers.getSelectedItem().equals("Player vs Machine")) {
            return;
        } else if (gamePlayers.getSelectedItem().equals("Machine vs Machine")) {
            return;
        }
    }
}
