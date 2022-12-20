package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.Clip;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import Charactor.Player;
import Display.GamePanel;
import Display.Menu;
import Display.SelectTeamWindow;
import Display.SystemsWindow;
import Display.Window;
import Display.WindowLose;

public class DisplayListener implements ActionListener {
	private JFrame systemsWindow;
	private JPanel selectTeamWindow, menu;
	private GamePanel gamePanel;
	private WindowLose windowLose;
	private Window window;

	public DisplayListener(Window window) {
		this.window = window;
	}

	public DisplayListener(Window window, SystemsWindow systemsWindow) {
		this.window = window;
		this.systemsWindow = systemsWindow;
	}
	public DisplayListener(Window window, WindowLose windowLose) {
		this.window = window;
		this.windowLose = windowLose;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start")) {
			selectTeamWindow = new SelectTeamWindow(this.window);
			this.window.getContentPane().removeAll();
			this.window.getContentPane().add(selectTeamWindow);
			this.window.revalidate();
			this.window.repaint();

		} else if (e.getActionCommand().equals("Exit")) {
			System.exit(0);
		} else if (e.getActionCommand().equals("Systems")) {
			this.systemsWindow = new SystemsWindow(this.window);


		} else if (e.getActionCommand().equals("BACK")) {
			System.out.println(this.systemsWindow);
			if (this.systemsWindow != null) {
				this.systemsWindow.setVisible(false);
				this.systemsWindow.dispose();
			}
			menu = new Menu(this.window);
			this.window.getContentPane().removeAll();
			this.window.getContentPane().add(menu); 
			this.window.revalidate();
			this.window.repaint();

		} else if (e.getActionCommand().equals("Brazil")) {
			gamePanel = new GamePanel(this.window, e.getActionCommand());
			this.window.getContentPane().removeAll();
			this.window.getContentPane().add(gamePanel);
			this.window.revalidate();
			this.window.repaint();
			gamePanel.requestFocus();
			gamePanel.startGameThread();
			
		} else if (e.getActionCommand().equals("Germany")) {
			gamePanel = new GamePanel(this.window, e.getActionCommand());
			this.window.getContentPane().removeAll();
			this.window.getContentPane().add(gamePanel);
			this.window.revalidate();
			this.window.repaint();
			gamePanel.requestFocus();
			gamePanel.startGameThread();
		} else if (e.getActionCommand().equals("Argentina")) {
			gamePanel = new GamePanel(this.window, e.getActionCommand());
			this.window.getContentPane().removeAll();
			this.window.getContentPane().add(gamePanel);
			this.window.revalidate();
			this.window.repaint();
			gamePanel.requestFocus();
			gamePanel.startGameThread();
		} else if (e.getActionCommand().equals("MENU")) {
			menu = new Menu(this.window);
			this.window.getContentPane().removeAll();
			this.window.getContentPane().add(menu);
			this.window.revalidate();
			this.window.repaint();
		} else if (e.getActionCommand().equals("RESTART")) {
			gamePanel = new GamePanel(this.window, windowLose.getNation());
			this.window.getContentPane().removeAll();
			this.window.getContentPane().add(gamePanel);
			this.window.revalidate();
			this.window.repaint();
			gamePanel.requestFocus();
			gamePanel.startGameThread();
		}

	}

}
