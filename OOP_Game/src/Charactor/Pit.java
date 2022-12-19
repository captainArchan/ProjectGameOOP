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
public class Pit extends Charactor {
	private int numOfBackground;
	private BufferedImage img;
	private GamePanel gp;
	private Player player;

	public Pit(GamePanel gp, Player player, int positionX, int positionY, int weight, int height, int numOfBackground) {
		this.setPositionX(positionX);
		this.setPositionY(positionY);
		this.setWeight(weight);
		this.setHeight(height);
		this.numOfBackground = numOfBackground;
		this.gp = gp;
		this.player = player;
		importImg();
	}

	private void importImg() {
		InputStream importImg = getClass().getResourceAsStream("/Image/hole.png");
		try {
			img = ImageIO.read(importImg);
			importImg.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void Draw(Graphics2D g2) {
		if (gp.getNumBackground() == this.numOfBackground) {
			g2.drawImage(img, this.getPositionX(), this.getPositionY(), this.getWeight(), this.getHeight(), null);

		}
	}

	public void checkTouch() {
		if (((player.getPositionX() <= this.getPositionX() + 120 && player.getPositionX() >= this.getPositionX() - 130)
				&& (player.getPositionY() == 550)) && (this.numOfBackground == gp.getNumBackground())) {
			player.setStatus(false);
			System.out.println(player.getPositionX());
		}

	}

}
