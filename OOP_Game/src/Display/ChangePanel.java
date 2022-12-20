package Display;

import javax.swing.*;

public class ChangePanel {
	private WindowLose windowLose;
	private WindowWin windowWin;


	public ChangePanel(Window window, String status, String nation) {
		if(status.equals("die")) {
			windowLose = new WindowLose(window, nation);
			window.getContentPane().removeAll();
			window.getContentPane().add(windowLose);
			window.revalidate();
			window.repaint();
			
		}else if(status.equals("win")){
			windowWin = new WindowWin(window);
			window.getContentPane().removeAll();
			window.getContentPane().add(windowWin);
			window.revalidate();
			window.repaint();
		}

	}

}
