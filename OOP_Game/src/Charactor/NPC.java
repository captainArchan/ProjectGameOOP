/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Charactor;

/**
 *
 * @author pangpntt
 */
public class NPC extends Charactor {
    private int speed;
    private int stage;
    public NPC(int height, int weight, int positionX, int positionY, int speed, int stage) {
    	this.setHeight(height);
    	this.setWeight(weight);
    	this.setPositionX(positionX);
    	this.setPositionY(positionY);
    	this.speed = speed;
    	this.stage = stage;
    	
    }
    public void jump(){
        
    }
    
    public void slide(){
        
    }
    
    public boolean touchPlayer(){
        return true;
    }
}
