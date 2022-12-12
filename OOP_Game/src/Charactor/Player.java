/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Charactor;

/**
 *
 * @author pangpntt
 */
public class Player extends Charactor {
    private String nationality;
    private boolean status;
    private int speed;
    public void setNationality(String nationality){
        this.nationality = nationality;
    }
    public String getNationality(){
        return this.nationality;
    }
    public void setStatus(boolean status){
        this.status = status;
    }
    public boolean getStatus(){
        return this.status;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public int getSpeed(){
        return this.speed;
    }
    
    public void move(){
        
    }
}
