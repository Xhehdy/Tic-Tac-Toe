// File: ui/GameScreen.java
package ui;

import logic.TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame {
    private final JButton[][] buttons = new JButton[3][3];
    private final String player1;
    private final String player2;
    private final TicTacToe game;

    public GameScreen(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.game = new TicTacToe(player1, player2);

        setTitle("Tic Tac Toe - Game");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 3));
        Font btnFont = new Font("Arial", Font.BOLD, 40);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton btn = new JButton("");
                btn.setFont(btnFont);
                int finalI = i, finalJ = j;

                btn.addActionListener(e -> {
                    if (game.makeMove(finalI, finalJ)) {
                        btn.setText(game.getCurrentPlayerSymbol());

                        if (game.checkWin()) {
                            JOptionPane.showMessageDialog(this,
                                    game.getCurrentPlayerName() + " wins!");
                            int result = JOptionPane.showConfirmDialog(this,
                                    "Play again?", "Game Over", JOptionPane.YES_NO_OPTION);

                            if (result == JOptionPane.YES_OPTION) {
                                dispose();
                                new PlayerInputScreen();
                            } else {
                                System.exit(0);
                            }
                        } else if (game.isBoardFull()) {
                            JOptionPane.showMessageDialog(this, "It's a draw!");
                            System.exit(0);
                        } else {
                            game.switchPlayer();
                        }
                    }
                });

                buttons[i][j] = btn;
                panel.add(btn);
            }
        }

        add(panel);
        setVisible(true);
    }
}


