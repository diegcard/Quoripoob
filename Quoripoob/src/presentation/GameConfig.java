package Quoripoob.src.presentation;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class GameConfig extends JFrame {
    // Constants Screen
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int WIDTH = (int) (3 * screenSize.getWidth() / 5);
    private static final int HEIGHT = (int) (3 * screenSize.getHeight() / 5);

    private QuoripoobGUI quoripoobGUI;

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


    /**
     * Method to prepare the elements of the screen
     */
    private void preparateElement() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
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
        JButton player1ColorButton = new JButton("Color");

        player2Color = new Color(0, 0, 255);
        JButton player2ColorButton = new JButton("Color");

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
        JButton button = new JButton("Create Game");
        button.setFont(new Font("Arial", Font.BOLD, 25));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(51, 153, 255));
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.setFocusPainted(false);
        panel.add(button);
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

    /**
     * Method to prepare the actions
     */
    private void prepareActionsGae(){
        prepareActionsStarConfigGameMode();
        prepareActionsStarConfigPlayer();
    }

    /**
     * Constructor
     */
    public GameConfig(){
        preparateElement();
    }

}
