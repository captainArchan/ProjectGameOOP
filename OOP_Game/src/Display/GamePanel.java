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

	private Player player = new Player(this, keyH);
	private NPC npc1 = new NPC(this, 150, 150, 350, 600, "jump", 1);
	private Pit npc2 = new Pit(this, 600, 525, 200, 200, 1);
	private NPC npc3 = new NPC(this, 150, 150, 900, 600, "slide", 1);
	private NPC npc4 = new NPC(this, 150, 150, 350, 600, "jump", 2);
	private Pit npc5 = new Pit(this, 900, 525, 200, 200, 2);


	private Background background = new Background(this, player);
	private int numBackground = 1;
	private final int finalLine = 1096;
	private final int startPositionX = 10;
	private final int startPositionY = 550;

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

		background.Draw(g5);
		player.Draw(g2);
		npc1.Draw(g3);
		npc2.Draw(g4);
		npc3.Draw(g6);
		npc4.Draw(g7);
		npc5.Draw(g8);

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