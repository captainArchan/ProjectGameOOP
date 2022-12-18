/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author maxsky
 */
public class Entity extends JPanel{
    public int playerX, playerY,enemyX, enemyY;
    public int speed;
    public BufferedImage die,slide,stand,walk,walk2,win,enemy1,enemy2;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    
}
