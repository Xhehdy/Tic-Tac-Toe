// File: ui/PlayerInputScreen.java
package ui;

import javax.swing.*;
import java.awt.*;

public class PlayerInputScreen extends JFrame {
    public PlayerInputScreen() {
        setTitle("Enter Player Names");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextField player1Field = new JTextField(10);
        JTextField player2Field = new JTextField(10);
        JButton continueButton = new JButton("Continue");

        continueButton.addActionListener(e -> {
            String player1 = player1Field.getText();
            String player2 = player2Field.getText();

            if (player1.isEmpty() || player2.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter both player names!");
                return;
            }

            dispose(); // close this screen
            new GameScreen(player1, player2); // we'll build this next!
        });

        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(new JLabel("Player 1 Name:"));
        panel.add(player1Field);
        panel.add(new JLabel("Player 2 Name:"));
        panel.add(player2Field);
        panel.add(continueButton);

        add(panel);
        setVisible(true);
    }
}

