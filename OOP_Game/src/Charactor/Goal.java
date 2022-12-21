
package Charactor;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Display.GamePanel;

public class Goal extends Charactor {
	private BufferedImage img;
	private GamePanel gp;
	private int summon;
    public Goal(GamePanel gp, int positionX, int positionY, int width, int height, int summon) {
    	this.setPositionX(positionX);
    	this.setPositionY(positionY);
    	this.setWidth(width);
    	this.setHeight(height);
    	this.gp = gp;
    	this.summon = summon;
    	importImg();
    }
	private void importImg() {
		InputStream importImg = getClass().getResourceAsStream("/Image/goal.png");
		try {
			img = ImageIO.read(importImg);
			importImg.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void Draw(Graphics2D g2) {
		if(this.gp.getNumBackground() == summon) {
			g2.drawImage(img, this.getPositionX(), this.getPositionY(), this.getWidth(), this.getHeight(), null);
		}
	}
}
