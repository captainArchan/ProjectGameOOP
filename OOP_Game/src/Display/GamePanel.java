package Display;
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

public class GamePanel extends JPanel implements Runnable {
	private Window window;
	private final int originalTileSize = 16;
	private final int scale = 6;
	private final int tileSize = originalTileSize * scale;
	private int maxScreenCol = 13;
	private int maxScreenRow = 8;
	private final int screenWidth = tileSize * maxScreenCol;
	private final int screenHeight = tileSize * maxScreenRow;
	private CharacterListener keyH = new CharacterListener();
	private Thread gameThread;

	private final int FPS = 60;
	private final int playerY = 550;
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

	private Player player;
	private NPC npc1;
	private Pit pit1;
	private NPC npc2;
	private NPC npc3;
	private Pit pit2 ;
	private Pit pit3 ;
	private NPC npc4 ;
	private Pit pit4 ;
	private NPC npc5 ;
	private NPC npc6 ;
	private Pit pit5;
	private NPC npc7 ;
	private NPC npc8 ;
	private Goal goal = new Goal(this, 1000, 450, 400, 400, 5);
	private Background background = new Background(this);
	private String nationality;

	public GamePanel(Window window, String nationality) {
		this.window = window;
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.nationality = nationality;
		player = new Player(this, keyH);
		setNPC(); 
		this.setFocusable(true);
	}

	private void setNPC() {
		npc1 = new NPC(this, player, 150, 150, 350, 600, "jump", 1);
		pit1 = new Pit(this, player, 700, 525, 200, 200, 1);
		npc2 = new NPC(this, player, 150, 150, 1000, 600, "slide", 1);
		npc3 = new NPC(this, player, 150, 150, 350, 600, "jump", 2);
		pit2 = new Pit(this, player, 900, 525, 200, 200, 2);
		pit3 = new Pit(this, player, 300, 525, 200, 200, 3);
		npc4 = new NPC(this, player, 150, 150, 600, 600, "jump", 3);
		pit4 = new Pit(this, player, 950, 525, 200, 200, 3);
		npc5 = new NPC(this, player, 150, 150, 300, 600, "jump", 4);
		npc6 = new NPC(this, player, 150, 150, 600, 600, "slide", 4);
		pit5 = new Pit(this, player, 950, 525, 200, 200, 4);
		npc7 = new NPC(this, player, 150, 150, 350, 600, "jump", 5);
		npc8 = new NPC(this, player, 150, 150, 700, 600, "jump", 5);
	}

	public int getScreenHeight() {
		return this.screenHeight;
	}

	public int getScreenWidth() {
		return this.screenWidth;
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

	public String getNationality() {
		return this.nationality;

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
				if (player.getDirection().equals("win")) {
					new ChangePanel(this.window, player.getDirection(), this.getNationality());
					gameThread.stop();
				}
			}
		}
	}

	public void update() {
		player.move();
		checkBG();
		if (player.getDirection().equals("die")) {
			new ChangePanel(this.window, player.getDirection(), this.getNationality());
			gameThread.stop();
		}


		npc1.checkTouch();
		npc2.checkTouch();
		npc3.checkTouch();
		npc4.checkTouch();
		npc5.checkTouch();
		npc6.checkTouch();
		npc7.checkTouch();
		npc8.checkTouch();
		pit1.checkTouch();
		pit2.checkTouch();
		pit3.checkTouch();
		pit4.checkTouch();
		pit5.checkTouch();

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