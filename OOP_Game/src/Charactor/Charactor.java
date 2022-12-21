
package Charactor;

import javax.swing.JPanel;

public class Charactor extends JPanel {
	private int height;
	private int width;
	private int positionX;
	private int positionY;
	private int speed;

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return this.height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return this.width;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionX() {
		return this.positionX;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getPositionY() {
		return this.positionY;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSpeed() {
		return this.speed;
	}

}
