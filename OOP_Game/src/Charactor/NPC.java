/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Charactor;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Display.GamePanel;

/**
 *
 * @author pangpntt
 */
public class NPC extends Charactor {
	private int stage;
	private boolean touchPlayer;
	private GamePanel gp;
	private BufferedImage img;
	private BufferedImage animationSlide, animationJump;
	private String action;
	private int round = 0;
	private boolean isJump = true;
	private int map;

	public NPC(GamePanel gp, int height, int weight, int positionX, int positionY, String action, int map) {
		this.setHeight(height);
		this.setWeight(weight);
		this.setPositionX(positionX);
		this.setPositionY(positionY);
		this.action = action;
		this.gp = gp;
		this.map = map;
		importImgSlide();
		importImgStand_Jump();

	}

	private void importImgSlide() {
		InputStream importImg = getClass().getResourceAsStream("/Image/bot_slide.png");
		try {
			animationSlide = ImageIO.read(importImg);
			importImg.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void importImgStand_Jump() {
		InputStream importImg = getClass().getResourceAsStream("/Image/bot_stand_jump.png");
		try {
			animationJump = ImageIO.read(importImg);
			importImg.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public boolean getTouchPlayer() {
		return touchPlayer;
	}

	public void Draw(Graphics2D g) {
		if (this.action.equals("jump") && gp.getMap() == this.map) {
			img = animationJump;
			if (this.getPositionY() >= 400 && this.isJump == true) {
				this.round++;
				if (this.round > 10) {
					this.setPositionY(this.getPositionY() - 1);
					if (this.getPositionY() == 400) {
						this.isJump = false;
					}
					this.round = 0;
				}

			}

			else {
				this.round++;
				if (this.round > 10) {
					this.setPositionY(this.getPositionY() + 1);
					this.round = 0;
					if (this.getPositionY() >= 550) {
						this.isJump = true;

					}

				}
			}

		} else if (this.action.equals("slide") && gp.getMap() == this.map) {
			img = animationSlide;
		} else if (this.map != gp.getMap()) {
			img = null;
		}

		g.drawImage(img, this.getPositionX(), this.getPositionY(), this.getWeight(), this.getHeight(), null);

	}

	public void setTouchPlayer(boolean touchPlayer) {
		this.touchPlayer = touchPlayer;
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
