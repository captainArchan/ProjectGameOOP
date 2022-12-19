/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Charactor;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 *
 * @author pangpntt
 */
public class Goal extends Charactor {
	private BufferedImage img;
	
    public Goal(int positionX, int positionY, int weight, int height) {
    	this.setPositionX(positionX);
    	this.setPositionY(positionY);
    	this.setWeight(weight);
    	this.setHeight(height);
    }
	private void importImg() {
		InputStream importImg = getClass().getResourceAsStream("/Image/Goal.png");
		try {
			img = ImageIO.read(importImg);
			importImg.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
