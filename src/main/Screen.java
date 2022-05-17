package main;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class Screen extends JPanel implements Runnable{

    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize*scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = maxScreenCol*tileSize;
    final int screenHeight = maxScreenRow*tileSize;

    Thread gameThread;

    public Screen(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void initiateThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while(gameThread != null){
            System.out.println("Running");
        }
    }
}
