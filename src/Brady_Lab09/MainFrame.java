// MainFrame.java
// Zack Brady | IST 240

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame {

    GamePanel game;

    public MainFrame() {
        super("L09: Lab Assignment - Java: The Click Me Game | Zack Brady");
        MacLayoutSetup();

        game = new GamePanel();
        getContentPane().add(game, "Center");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 600);
        setVisible(true);

    }

    public void MacLayoutSetup() {
        // On some MACs it might be necessary to have the statement below
        //for the background color of the button to appear
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
