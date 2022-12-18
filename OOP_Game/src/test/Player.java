/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author maxsky
 */
public class Player extends Entity {
	GamePanel gp;
	KeyHandler keyH;
	BufferedImage image ;

	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		setDefaultValues();
//        getPlayerImage();
	}

	public void setDefaultValues() {
		playerX = 10;
		playerY = 550;
		speed = 6;
		direction = "up";
	}

	public void update() {
		if (keyH.jumpPressed == true || keyH.rightPressed == true || keyH.leftPressed == true
				|| keyH.slidePressed == true) {

			if (keyH.jumpPressed == true && playerY >= 550) {
				direction = "up";
				gp.jumping = true;
				new Thread(new Player.thread()).start();
			}
			if (keyH.rightPressed == true) {
				direction = "right";
				playerX += speed;
			}
			if (keyH.leftPressed == true) {
				direction = "left";
				playerX -= speed;
			}
			if (keyH.slidePressed == true) {
				direction = "down";
			}
			spriteCounter++;
			if (spriteCounter > 10) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		} else {
			direction = "up";
		}
	}

//    public void getPlayerImage(){
//        try {
//            stand = ImageIO.read(getClass().getResourceAsStream("Argen_stand_jump.PNG"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.print("ww");
//    }
	public void Draw(Graphics2D g2) {
//        g2.setColor(Color.red);
//     
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		Image img = new ImageIcon("Image\\Argen_stand_jump.PNG").getImage();
//		image = ImageIO.read(new File("Image\\\\Argen_stand_jump.png"));
		switch (direction) {
		case "up":

			if (spriteNum == 1) {
				img = new ImageIcon("Argen_stand_jump.PNG").getImage();

			}
			break;
		case "down":
			img = new ImageIcon("Argen_slide.PNG").getImage();
			break;
		case "left":
			if (spriteNum == 1) {
				img = new ImageIcon("Argen_walk.PNG").getImage();
			} else if (spriteNum == 2) {
				img = new ImageIcon("Argen_walk2.PNG").getImage();
			}
			break;
		case "right":
			if (spriteNum == 1) {
				img = new ImageIcon("Argen_walk.PNG").getImage();
			} else if (spriteNum == 2) {
				img = new ImageIcon("Argen_walk2.PNG").getImage();
			}
			break;
		}
		g2.drawImage(img, playerX, playerY, gp.tileSize, gp.tileSize, null);
		if (gp.jumping) {
			if (playerY >= 250) {
				playerY--;
			} else {
				playerY++;
			}
		}

		if (playerY != 550 && !gp.jumping) {
			playerY++;
		}
		repaint();
	}

	public class thread implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(gp.jumpingTime);
				gp.jumping = false;
				Thread.sleep(gp.jumpingTime);
			} catch (Exception e) {
				e.printStackTrace();
				new Thread(this).start();
				System.exit(0);
			}
		}
	}

}
