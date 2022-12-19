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

	public void setWeight(int weight) {
		this.width = weight;
	}

	public int getWeight() {
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

