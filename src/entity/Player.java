package entity;

import main.KeyHandler;
import main.Screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    Screen sc;
    KeyHandler keyH;
    public BufferedImage platL, platR;
    public Player(Screen sc, KeyHandler keyH){
        this.sc = sc;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = sc.screenWidth/2;
        y = sc.screenHeight-(sc.screenHeight/8);
        speed = 4;
        direction = "left";
    }

    public void getPlayerImage(){
        try {
            platL = ImageIO.read(getClass().getResourceAsStream("/PlatL.png"));
            platR = ImageIO.read(getClass().getResourceAsStream("/PlatR.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if (keyH.upPressed) {
//            y -= speed;
        } else if (keyH.downPressed){
//            y += speed;
        } else if (keyH.leftPressed){
            x -= speed;
            direction = "left";
        } else if (keyH.rightPressed){
            x += speed;
            direction = "right";
        }
    }
    public void draw(Graphics2D g2){
//        g2.setColor(Color.white);
//        g2.fillRect(x,y, sc.tileSize, sc.tileSize);
        BufferedImage image = null;

        switch(direction){
            case "left":
                image = platL;
                break;
            case "right":
                image = platR;
                break;
        }
        g2.drawImage(image, x, y, sc.tileSize*2, sc.tileSize, null);
    }
}
