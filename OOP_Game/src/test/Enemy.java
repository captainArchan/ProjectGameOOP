/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;




import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 *
 * @author maxsky
 */
public class Enemy extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    Player p;
    public Enemy(GamePanel gp){
        this.gp = gp;
        setDefaultValues();
    }
    public void setDefaultValues(){
        enemyX = 600;
        enemyY = 565;
        speed = 6;
    }
    public void Draw(Graphics g){
        Image enemy_slide = new ImageIcon("bot_slide.PNG").getImage();
        Image enemy_jump = new ImageIcon("bot_stand_jump.PNG").getImage();
        g.drawImage(enemy_slide,enemyX,enemyY,gp.tileSize,gp.tileSize,null);
    }
    public void update(){
        enemyX-= speed;
    }
}
