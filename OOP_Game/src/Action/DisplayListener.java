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

public class DisplayListener implements ActionListener {
	private JFrame jf, systemsWindow;
	private JPanel selectTeamWindow, menu;
	private GamePanel gamePanel;
	private Player player;
	private JDesktopPane desktop;

	public DisplayListener(JFrame jf) {
		this.jf = jf;
	}

	public DisplayListener(JFrame jf, SystemsWindow systemsWindow) {
		this.jf = jf;
		this.systemsWindow = systemsWindow;
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
			jf.add(gamePanel);
			jf.revalidate();
			jf.repaint();
			gamePanel.startGameThread();

		} else if (e.getActionCommand().equals("Germany")) {

		} else if (e.getActionCommand().equals("Argentina")) {

		}

	}

}
