/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import test.TileManager;
import test.Enemy;
import test.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author maxsky
 */
public class GamePanel extends JPanel implements Runnable {
	// Screen
	final int originalTileSize = 16;
	final int scale = 6;

	public final int tileSize = originalTileSize * scale; // 48 * 48 pixel
	final int maxScreenCol = 13; // พพพพพพพพพพพพพพพพพพพพพพพพพพ
	final int maxScreenRow = 8; // กกกกกกกกกกกกกกกก
	public final int screenWidth = tileSize * maxScreenCol; // 1248px
	public final int screenHeight = tileSize * maxScreenRow; // 768px
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	Enemy enemy = new Enemy(this);
	Player player = new Player(this, keyH);
	int FPS = 60;
	TileManager tileM = new TileManager(this);
	// player Start Position
	int playerY = 550;
	// player jump
	public boolean jumping = false;
	public long jumpingTime = 400;

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		while (gameThread != null) {
			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			if (delta >= 1) {
				update();
				repaint();
				delta--;
			}
		}
	}

//    if (gc.getInput().isKeyDown(Input.KEY_SPACE) && y >= floorHeight) // Must be on the ground to jump.
//   jumpStrength = 24; // Will result in the player moving upwards.
//  
//  y -= jumpStrength; // Move the player on the y-axis based on the strength of the jump.
//  jumpStrength -= weight; // Gradually decrease the strength of the jump by the player's weight.
//  
//  if (y >= floorHeight) y = floorHeight;
	public void update() {
		player.update();
		enemy.update();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		tileM.Draw(g);
		player.Draw(g2);
		enemy.Draw(g);
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
