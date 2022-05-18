package main;

import javax.swing.JPanel;
import java.awt.*;

public class Screen extends JPanel implements Runnable{

    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize*scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = maxScreenCol*tileSize;
    final int screenHeight = maxScreenRow*tileSize;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //Default Starting Position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    //FPS
    int FPS = 60;

    public Screen(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void initiateThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime)/drawInterval;

            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }
    public void update(){
        if (keyH.upPressed) {
            playerY -= playerSpeed;
        } else if (keyH.downPressed){
            playerY += playerSpeed;
        } else if (keyH.leftPressed){
            playerX -= playerSpeed;
        } else if (keyH.rightPressed){
            playerX += playerSpeed;
        }

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(playerX,playerY,tileSize,tileSize);
        g2.dispose();
    }
}
