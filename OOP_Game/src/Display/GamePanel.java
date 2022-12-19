/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import Action.CharacterListener;
import Charactor.Background;
import Charactor.NPC;
import Charactor.Player;


/**
 *
 * @author pangpntt
 */
public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize = 16;
    final int scale = 6;
    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 13; 
    final int maxScreenRow = 8;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    
    private CharacterListener keyH = new CharacterListener(this);
    private Thread gameThread;
	
    int FPS = 60;
    int playerY = 550;
    private boolean jumping = false;
    private long jumpingTime = 400;
    private double drawInterval = 1000000000 / FPS;
    private double delta = 0;
    private long lastTime = System.nanoTime();
    private long currentTime;
    
    private Player player = new Player(this, keyH);
    private NPC npc1 = new NPC(this, 96, 96, 400, 550, "jump", 1);
    private NPC npc2 = new NPC(this, 96, 96, 90, 550, "slide", 2);
    private Background background = new Background(this, player);
    private int numBackground = 1;
    private final int finalLine = 1096;
    
    public GamePanel(){
    	this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    
    }
    public void setJumping(boolean jumping) {
    	this.jumping = jumping;
    }
    public boolean getJumping() {
    	return this.jumping;
    }
    
    public long getJumpingTime() {
    	return this.jumpingTime;
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
	@Override
	public void run() {
        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if(delta >= 1){
            	update();
            	repaint();
            	delta--;
            }
        }
		
	}

	
    public void update(){
        player.move();
        
    }

	
	public int getNumBackground() {
		return this.numBackground;
	}
	public void setNumBackground(int numBackground) {
		this.numBackground = numBackground;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Graphics2D g3 = (Graphics2D) g;
		Graphics2D g4 = (Graphics2D) g;
		Graphics2D g5 = (Graphics2D) g;
		background.Draw(g5);
		player.Draw(g2);
		npc1.Draw(g3);
		npc2.Draw(g4);

		g2.dispose();
		if (jumping) {
			if (playerY >= 100) {
				playerY--;
			} else {
				playerY++;
			}
		}
		if (playerY != 550 && !jumping) {
			playerY++;
		}
		repaint();
	}
}
