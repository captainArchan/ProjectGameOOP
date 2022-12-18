/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Charactor;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 *
 * @author pangpntt
 */
public class Charactor extends JPanel {
	private int height;
	private int weight;
	private int positionX;
	private int positionY;
	private int speed;
	public int spriteCounter;
	public int spriteNum ;
    public String direction;

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return this.height;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getWeight() {
		return this.weight;
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
	public void setSpriteCounter(int spriteCounter) {
		this.spriteCounter = spriteCounter;
	}

	public int getSpriteCounter() {
		return this.spriteCounter;
	}
	public void setSpriteNum(int spriteNum) {
		this.spriteNum = spriteNum;
	}
	public int getSpriteNum() {
		return this.spriteNum;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getDirection() {
		return this.direction;
	}
}

