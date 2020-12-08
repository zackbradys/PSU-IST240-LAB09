// GamePanel.java
// Zack Brady | IST 240

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

    JButton b1;
    JProgressBar pbVertical;
    Timer timer;

    int score = 0;
    int limit = 0;
    int delay = 0;
    int buttonA;
    int buttonB;
    int buttonWidth = 100;
    int buttonHeight = 500;
    int sizeDecrement = 2;

    public GamePanel() {
        super();
        setLayout(null);
        setBackground(Color.white);

        b1 = new JButton("click me");
        b1.setBounds(50, 50, 100, 100);
        b1.setEnabled(false);
        b1.addActionListener(this);
        add(b1);

        setFocusable(true);
        addKeyListener(this);
        requestFocusInWindow();

        pbVertical = new JProgressBar(JProgressBar.VERTICAL, 0, 60);
        pbVertical.setBounds(1100, 0, 100, 600);
        pbVertical.setValue(60);
        add(pbVertical);

        delay = 1000;
        timer = new Timer(delay, this);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("score = " + score, 10, 500);
        g.drawString("Press Spacebar to start the game", 10, 520);
        g.drawString("You have 60 seconds to keep clicking on the button to score", 10, 540);
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            b1.setEnabled(true);

            ActionListener listener = new ActionListener() {
                int counter = 60;

                public void actionPerformed(ActionEvent ae) {
                    counter--;

                    do {
                        buttonA = (int) (Math.random() * (1100));
                        buttonB = (int) (Math.random() * (500));

                    } while (!(buttonA >= 0
                            && buttonA + 100 < 1100)
                            || !(buttonB >= 0
                            && buttonB < 500 - 100));

                    b1.setBounds(buttonA, buttonB, buttonWidth, buttonWidth);

                    pbVertical.setValue(counter);
                    pbVertical.setString(String.valueOf(counter));

                    if (counter < 1) {
                        timer.stop();
                        JOptionPane.showMessageDialog(null, "Game Over. Your score was: " + score);
                        System.exit(10);
                    }
                }
            };

            timer = new Timer(delay, listener);
            timer.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object object = event.getSource();
        if (object == b1) {
            buttonWidth -= sizeDecrement;
            score++;
            repaint();
        }
    }
}
