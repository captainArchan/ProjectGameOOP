package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import Charactor.Player;
import Display.GamePanel;
import Display.Menu;
import Display.SelectTeamWindow;
import Display.SystemsWindow;
import Display.WindowLose;

public class DisplayListener implements ActionListener {
	private JFrame jf, systemsWindow;
	private JPanel selectTeamWindow, menu, gameLose;
	private GamePanel gamePanel;
	private JDesktopPane desktop;
	private WindowLose windowLose;

	public DisplayListener(JFrame jf) {
		this.jf = jf;
	}

	public DisplayListener(JFrame jf, SystemsWindow systemsWindow) {
		this.jf = jf;
		this.systemsWindow = systemsWindow;
	}
	public DisplayListener(JFrame jf, WindowLose windowLose) {
		this.jf = jf;
		this.windowLose = windowLose;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start")) {
			selectTeamWindow = new SelectTeamWindow(jf);
			jf.getContentPane().removeAll();
			jf.getContentPane().add(selectTeamWindow);
			jf.revalidate();
			jf.repaint();

		} else if (e.getActionCommand().equals("Exit")) {
			System.exit(0);
		} else if (e.getActionCommand().equals("Systems")) {
			this.systemsWindow = new SystemsWindow(jf);
			System.out.print(this.systemsWindow);

		} else if (e.getActionCommand().equals("BACK")) {
			System.out.println(this.systemsWindow);
			if (this.systemsWindow != null) {
				this.systemsWindow.setVisible(false);
				this.systemsWindow.dispose();
			}
			menu = new Menu(jf);
			jf.getContentPane().removeAll();
			jf.getContentPane().add(menu);
			jf.revalidate();
			jf.repaint();

		} else if (e.getActionCommand().equals("Brazil")) {
			gamePanel = new GamePanel(jf, e.getActionCommand());
			jf.getContentPane().removeAll();
			jf.getContentPane().add(gamePanel);
			jf.revalidate();
			jf.repaint();
			gamePanel.requestFocus();
			gamePanel.startGameThread();
			
		} else if (e.getActionCommand().equals("Germany")) {
			gamePanel = new GamePanel(jf, e.getActionCommand());
			jf.getContentPane().removeAll();
			jf.getContentPane().add(gamePanel);
			jf.revalidate();
			jf.repaint();
			gamePanel.requestFocus();
			gamePanel.startGameThread();
		} else if (e.getActionCommand().equals("Argentina")) {
			gamePanel = new GamePanel(jf, e.getActionCommand());
			jf.getContentPane().removeAll();
			jf.getContentPane().add(gamePanel);
			jf.revalidate();
			jf.repaint();
			gamePanel.requestFocus();
			gamePanel.startGameThread();
		} else if (e.getActionCommand().equals("MENU")) {
			menu = new Menu(jf);
			jf.getContentPane().removeAll();
			jf.getContentPane().add(menu);
			jf.revalidate();
			jf.repaint();
		} else if (e.getActionCommand().equals("RESTART")) {
			gamePanel = new GamePanel(jf, windowLose.getNation());
			jf.getContentPane().removeAll();
			jf.getContentPane().add(gamePanel);
			jf.revalidate();
			jf.repaint();
			gamePanel.requestFocus();
			gamePanel.startGameThread();
		}

	}

}
