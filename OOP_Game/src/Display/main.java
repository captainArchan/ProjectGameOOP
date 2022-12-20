package Display;

import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Worldcup");
        
        
        GamePanel gamePanel = new GamePanel(window, "Brazil");
        window.add(gamePanel);
        window.pack();
       
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanel.startGameThread();
	}

}
