/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Charactor;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Display.GamePanel;

/**
 *
 * @author pangpntt
 */
public class Background {
	private GamePanel gp;
	private int numBackground;
	private BufferedImage img1;
	private BufferedImage img2;
	private BufferedImage img3;
	private BufferedImage img4;
	private BufferedImage img5;
	private Player player;
	public Background(GamePanel gp, Player player) {
		this.gp = gp;
		importImg();

	}

	private void importImg() {
		InputStream importImg1 = getClass().getResourceAsStream("/Image/bg1.png");
		InputStream importImg2 = getClass().getResourceAsStream("/Image/bg2.png");
		InputStream importImg3 = getClass().getResourceAsStream("/Image/bg3.png");
		InputStream importImg4 = getClass().getResourceAsStream("/Image/bg4.png");
		InputStream importImg5 = getClass().getResourceAsStream("/Image/bg5.png");
		try {
			img1 = ImageIO.read(importImg1);
			img2 = ImageIO.read(importImg2);
			img3 = ImageIO.read(importImg3);
			img4 = ImageIO.read(importImg4);
			img5 = ImageIO.read(importImg5);
			importImg1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void Draw(Graphics g) {
		if(gp.getNumBackground()== 1) {
			g.drawImage(img1, 0, 0, gp.screenWidth, gp.screenHeight, null);
		}
		else if(gp.getNumBackground()== 2) {
			g.drawImage(img2, 0, 0, gp.screenWidth, gp.screenHeight, null);
		}
		else if(gp.getNumBackground()== 3) {
			g.drawImage(img3, 0, 0, gp.screenWidth, gp.screenHeight, null);
		}
		else if(gp.getNumBackground()== 4) {
			g.drawImage(img4, 0, 0, gp.screenWidth, gp.screenHeight, null);
		}
		else if(gp.getNumBackground()== 5) {
			g.drawImage(img5, 0, 0, gp.screenWidth, gp.screenHeight, null);
		}

	}

}
