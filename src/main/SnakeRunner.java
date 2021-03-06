package main;

import javax.swing.*;

public class SnakeRunner {
    public static void main (String[] args){

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Snake Game");

        Screen screen = new Screen();
        window.add(screen);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        screen.initiateThread();
    }
}
