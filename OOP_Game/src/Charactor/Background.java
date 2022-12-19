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
	private BufferedImage img;
	private Player player;
	private int finalLnie = 1096;
    public Background(GamePanel gp, Player player) {
    	this.gp = gp;
    	this.player = player;
    	importImg();
    }
    
	private void importImg() {
		InputStream importImg = getClass().getResourceAsStream("/Image/bg.png");
		try {
			img = ImageIO.read(importImg);
			importImg.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void Draw(Graphics g) {
		 g.drawImage(img, 0, 0, gp.screenWidth, gp.screenHeight, null);
	}
	public void checkFinalLine() {
		if(player.getPositionX() == 1096) {
			gp.setNumBackground(gp.getNumBackground()+1);
			player.setPositionX(10);
			player.setPositionY(550);
		}
		
	}
	
	

    
    
	
}
