package Quoripoob.src.presentation;

import javax.swing.*;

public class QuoripoobGUI extends JFrame {

    public QuoripoobGUI() {
        super("Quoripoob");
        setSize(1024, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new QuoripoobGUI();
    }
}
