/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Charactor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Action.CharacterListener;
import test.GamePanel;
import test.KeyHandler;

/**
 *
 * @author pangpntt
 */
public class Player extends Charactor {
	private String nationality;
	private boolean status;
	private BufferedImage img;
	private BufferedImage[][] animations;
	private Display.GamePanel gp;
	private CharacterListener keyH;
	BufferedImage image;

	public Player(Display.GamePanel gp, CharacterListener keyH) {
		this.gp = gp;
		this.keyH = keyH;
		setDefaultValues();
		importImg();
		lodeImage();
	}

	private void importImg() {
		InputStream importImg = getClass().getResourceAsStream("/Image/AllCharactor.png");
		try {
			img = ImageIO.read(importImg);
			importImg.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void lodeImage() {
		animations = new BufferedImage[3][6];
		for (int j = 0; j < animations.length; j++)
			for (int i = 0; i < animations[j].length; i++)
				animations[j][i] = img.getSubimage(i * 40, j * 40, 40, 40);

	}

	public void setDefaultValues() {
		this.setPositionX(10);
		this.setPositionY(550);
		this.setSpeed(6);
		this.setWeight(96);
		this.setHeight(96);
		this.setSpriteNum(1);

	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void move() {
//		if (keyH.jumpPressed == true || keyH.rightPressed == true || keyH.leftPressed == true
//				|| keyH.slidePressed == true) {

		if (keyH.getJumpPressed() == true || keyH.getRightPressed() == true || keyH.getLeftPressed() == true
				|| keyH.getSlidePressed() == true) {

			if (keyH.getJumpPressed() == true && this.getPositionY() >= 550) {
				this.setDirection("up");
//				gp.jumping = true;
				gp.setJumping(true);
				new Thread(new Player.thread()).start();
			}
			if (keyH.getRightPressed() == true) {
				// direction = "right";
				this.setDirection("right");
				this.setPositionX(this.getSpeed() + this.getPositionX());
			}
			if (keyH.getLeftPressed() == true) {
				// direction = "left";
				this.setDirection("left");
				this.setPositionX(this.getPositionX() - this.getSpeed());
			}
			if (keyH.getSlidePressed() == true) {
				// direction = "down";
				this.setDirection("down");
			}
//			spriteCounter++;
			this.setSpriteCounter(this.getSpriteCounter() + 1);
			if (this.getSpriteCounter() > 10) {// spriteCounter > 10
				if (this.getSpriteNum() == 1) {
					this.setSpriteNum(2);
				} else if (this.getSpriteNum() == 2) {
					this.setSpriteNum(1);
				}
				this.setSpriteCounter(0);
			}
		} else {
			this.setDirection("up");// direction = "up";
		}
	}

	public void Draw(Graphics2D g2) {
//		g2.setColor(Color.red);
//		Image img = new ImageIcon("Image\\Argen_stand_jump.PNG").getImage();
		img = animations[0][0];
		if (this.getDirection().equals("up")) {
			img = animations[0][0];
		} else if (this.getDirection().equals("down")) {
			img = animations[0][3];
		} else if (this.getDirection().equals("left")) {
			if (this.getSpriteNum() == 1) {
				img = animations[0][1];
			} else if (this.getSpriteNum() == 2) {
				img = animations[0][2];
			}
		} else if (this.getDirection().equals("right")) {
			if (this.getSpriteNum() == 1) {
				img = animations[0][1];
			} else if (this.getSpriteNum() == 2) {
				img = animations[0][2];
			}
		}
//		switch (this.getDebugGraphicsOptions()) {
//		case "up":
//			if (spriteNum == 1) {
//				img = animations[0][3];
//			}
//			break;
//		case "down":
//			img = animations[0][3];
//			break;
//		case "left":
//			if (spriteNum == 1) {
//				img = animations[0][1];
//			} else if (spriteNum == 2) {
//				img = animations[0][2];
//			}
//			break;
//		case "right":
//			if (spriteNum == 1) {
//				img = animations[0][1];
//			} else if (spriteNum == 2) {
//				img = animations[0][2];
//			}
//			break;
//		}

		g2.drawImage(img, this.getPositionX(), this.getPositionY(), this.getWeight(), this.getHeight(), null);

//		g2.fillRect(this.getPositionX(), this.getPositionY(), gp.tileSize, gp.tileSize);
		if (gp.getJumping()) {
			if (this.getPositionY() >= 400) {
				this.setPositionY(this.getPositionY() - 1);
				;
			} else {
				this.setPositionY(this.getPositionY() + 1);
				;
			}
		}

		if (this.getPositionY() != 550 && !gp.getJumping()) {
			this.setPositionY(this.getPositionY() + 1);
			;
		}
		repaint();
	}

	public class thread implements Runnable {
		@Override
		public void run() {
			try {
				Thread.sleep(gp.getJumpingTime());
				gp.setJumping(false);
				Thread.sleep(gp.getJumpingTime());
			} catch (Exception e) {
				e.printStackTrace();
				new Thread(this).start();
				System.exit(0);
			}
		}
	}
}
