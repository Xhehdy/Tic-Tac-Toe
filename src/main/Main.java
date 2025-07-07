// File: main/Main.java
package main;

import ui.WelcomeScreen;
import ui.PlayerInputScreen;

public class Main {
    public static void main(String[] args) {
        new WelcomeScreen(e -> {
            ((WelcomeScreen) ((javax.swing.JButton) e.getSource()).getTopLevelAncestor()).dispose();
            new PlayerInputScreen();
        });
    }
}
