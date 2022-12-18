/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import test.GamePanel;
import java.awt.Graphics;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 *
 * @author maxsky
 */
public class TileManager {
    GamePanel gp;
    Tile[] tile;
    public TileManager(GamePanel gp){
        this.gp =gp;
        tile = new Tile[10];
        getTileImage();
    }
    public void getTileImage(){
        tile[0] = new Tile();
        tile[0].image = new ImageIcon("stand.PNG").getImage();
    }
    public void Draw(Graphics g){
        g.drawImage(tile[0].image, 0, 0, gp.screenWidth, gp.screenHeight, null);
    }
}
