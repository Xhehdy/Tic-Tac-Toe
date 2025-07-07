// File: ui/WelcomeScreen.java
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WelcomeScreen extends JFrame {

    public WelcomeScreen(ActionListener startListener) {
        setTitle("Welcome to Tic Tac Toe!");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("🔥 TIC TAC TOE 🔥", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.PLAIN, 18));
        startButton.addActionListener(startListener);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(titleLabel, BorderLayout.CENTER);
        panel.add(startButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
}
