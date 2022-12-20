
package Display;

import java.awt.*;
import javax.swing.*;
import Action.DisplayListener;

public class WindowLose extends JPanel {
    private JPanel jptxt1, jptxt2, jpbutton;
    private JButton buttonRestart, buttonBackToMenu;
    private JLabel textLose, txt2;
    private String nation; 
    public WindowLose(Window window, String nation){
    	this.nation = nation;
        jptxt1 = new JPanel();
        jpbutton = new JPanel();
        jptxt2 = new JPanel();
        buttonRestart = new JButton("RESTART");
        buttonBackToMenu = new JButton("MENU");
        buttonBackToMenu.addActionListener(new DisplayListener(window, this));
        buttonRestart.addActionListener(new DisplayListener(window, this));
        textLose = new JLabel("GAME", SwingConstants.CENTER);
        txt2 = new JLabel("OVER", SwingConstants.CENTER);
        
        Font myFont = new Font("Monospaced", Font.BOLD, 100);
        Font myFont2 = new Font("Monospaced", Font.BOLD, 30);
        textLose.setFont(myFont);
        txt2.setFont(myFont);
        buttonRestart.setFont(myFont2);
        buttonBackToMenu.setFont(myFont2);
        
        this.setBackground(new java.awt.Color(27, 18, 15));
        jptxt1.setBackground(new java.awt.Color(27, 18, 15));
        jptxt2.setBackground(new java.awt.Color(27, 18, 15));
        jpbutton.setBackground(new java.awt.Color(27, 18, 15));
        buttonRestart.setBackground(new java.awt.Color(230, 222, 221));
        buttonBackToMenu.setBackground(new java.awt.Color(230, 222, 221));
        
        Color color = new Color(248, 157, 19);
        Color color2 = new Color(143, 29, 20);
        textLose.setForeground(color);
        txt2.setForeground(color);
        buttonRestart.setForeground(color2);
        buttonBackToMenu.setForeground(color2);
          
        this.setLayout(new GridLayout(3,1));
        jptxt1.setLayout(new BorderLayout());
        jptxt2.setLayout(new BorderLayout());
        jpbutton.setLayout(new FlowLayout());
        jptxt1.add(textLose);
        jptxt2.add(txt2);
        jpbutton.add(buttonRestart);
        jpbutton.add(buttonBackToMenu);
        this.add(jptxt1);
        this.add(jptxt2);
        this.add(jpbutton);
        
    }
    public String getNation() {
    	return this.nation;
    }
}
