package Display;

import javax.swing.*;

public class ChangePanel {
	private WindowLose windowLose;
	private WindowWin windowWin;


	public ChangePanel(JFrame jf, String status, String nation) {
		if(status.equals("die")) {
			windowLose = new WindowLose(jf, nation);
			jf.getContentPane().removeAll();
			jf.getContentPane().add(windowLose);
			jf.revalidate();
			jf.repaint();
			
		}else if(status.equals("win")){
			windowWin = new WindowWin(jf);
			jf.getContentPane().removeAll();
			jf.getContentPane().add(windowWin);
			jf.revalidate();
			jf.repaint();
		}

	}

}
