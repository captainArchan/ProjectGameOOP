package Display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import Action.CharacterListener;

import Charactor.Background;
import Charactor.Goal;
import Charactor.NPC;
import Charactor.Pit;
import Charactor.Player;

/**
 *
 * @author pangpntt
 */
public class GamePanel extends JPanel implements Runnable {
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

	private int numBackground = 1;
	private final int finalLine = 1096;
	private final int startPositionX = 10;
	private final int startPositionY = 550;

	private Player player = new Player(this, keyH);
	private NPC npc1 = new NPC(this, player,150, 150, 350, 600, "jump", 1);
	private Pit pit1 = new Pit(this, player, 650, 525, 200, 200, 1);
	private NPC npc2 = new NPC(this, player,150, 150, 950, 600, "slide", 1);
	private NPC npc3 = new NPC(this, player,150, 150, 350, 600, "jump", 2);
	private Pit pit2 = new Pit(this, player, 900, 525, 200, 200, 2);
	private Pit pit3 = new Pit(this, player, 300, 525, 200, 200, 3);
	private NPC npc4 = new NPC(this, player,150, 150, 600, 600, "jump", 3);
	private Pit pit4 = new Pit(this, player,950, 525, 200, 200, 3);
	private NPC npc5 = new NPC(this, player,150, 150, 300, 600, "jump", 4);
	private NPC npc6 = new NPC(this,player,150, 150, 600, 600, "slide", 4);
	private Pit pit5 = new Pit(this, player,950, 525, 200, 200, 4);
	private NPC npc7 = new NPC(this, player,150, 150, 300, 600, "jump", 5);
	private NPC npc8 = new NPC(this, player,150, 150, 600, 600, "jump", 5);
	private Goal goal = new Goal(this, 1000, 450, 400, 400, 5);

	private Background background = new Background(this, player);

	public GamePanel() {
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

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
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

	public void update() {
		player.move();
		checkBG();
		npc1.checkTouch();
		pit1.checkTouch();
		npc2.checkTouch();
		npc3.checkTouch();
		pit2.checkTouch();
		pit3.checkTouch();
		pit4.checkTouch();
		npc4.checkTouch();
		npc5.checkTouch();
		npc6.checkTouch();
		pit5.checkTouch();
		npc7.checkTouch();
		npc8.checkTouch();
	}

	private void checkBG() {
		if (player.getPositionX() >= this.finalLine) {
			if (this.getNumBackground() == 5) {
				player.setPositionX(finalLine);
			} else {
				this.setNumBackground(this.getNumBackground() + 1);
				player.setPositionX(startPositionX);
				player.setPositionY(startPositionY);
			}

		} else if (player.getPositionX() < startPositionX - 1 && this.getNumBackground() > 1) {
			player.setPositionX(finalLine);
			this.setNumBackground(this.getNumBackground() - 1);
		} else if (player.getPositionX() < 1) {
			player.setPositionX(1);
		}

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

		Graphics2D g6 = (Graphics2D) g;
		Graphics2D g7 = (Graphics2D) g;
		Graphics2D g8 = (Graphics2D) g;

		Graphics2D g9 = (Graphics2D) g;
		Graphics2D g10 = (Graphics2D) g;
		Graphics2D g11 = (Graphics2D) g;

		Graphics2D g12 = (Graphics2D) g;
		Graphics2D g13 = (Graphics2D) g;
		Graphics2D g14 = (Graphics2D) g;

		Graphics2D g15 = (Graphics2D) g;
		Graphics2D g16 = (Graphics2D) g;
		Graphics2D g17 = (Graphics2D) g;

		background.Draw(g5);

		npc1.Draw(g3);
		pit1.Draw(g4);
		npc2.Draw(g6);
		npc3.Draw(g7);
		pit2.Draw(g8);
		pit3.Draw(g9);
		pit4.Draw(g10);
		npc4.Draw(g11);
		npc5.Draw(g12);
		npc6.Draw(g13);
		pit5.Draw(g14);
		npc7.Draw(g15);
		npc8.Draw(g16);
		goal.Draw(g17);

		player.Draw(g2);
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