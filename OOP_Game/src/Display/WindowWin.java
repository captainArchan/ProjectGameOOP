
package Display;

import java.awt.*;
import javax.swing.*;

import Action.DisplayListener;

public class WindowWin extends JPanel{
    private JPanel jptxt, jpMenu;
    private JButton buttonBackToMenu;
    private JLabel textWin;
    private Window window;
    public WindowWin(Window window){ 
    	this.window = window; 
        jptxt = new JPanel();
        jpMenu = new JPanel();
        buttonBackToMenu = new JButton("MENU");
        buttonBackToMenu.addActionListener(new DisplayListener(this.window));
        textWin = new JLabel("WINNER", SwingConstants.CENTER);
        
        Font myFont = new Font("Monospaced", Font.BOLD, 100);
        Font myFont2 = new Font("Monospaced", Font.BOLD, 50);
        textWin.setFont(myFont);
        buttonBackToMenu.setFont(myFont2);
        
        this.setBackground(new java.awt.Color(248, 157, 19));
        jptxt.setBackground(new java.awt.Color(248, 157, 19));
        jpMenu.setBackground(new java.awt.Color(248, 157, 19));
        buttonBackToMenu.setBackground(new java.awt.Color(27, 18, 15));
        
        Color color = new Color(230, 222, 221);
        Color color2 = new Color(143, 29, 20);
        textWin.setForeground(color2);
        buttonBackToMenu.setForeground(color);
        
        this.setLayout(new BorderLayout());
        jptxt.setLayout(new GridLayout(2,1));
        jpMenu.setLayout(new FlowLayout());
        
        jpMenu.add(buttonBackToMenu);
        jptxt.add(textWin);
        jptxt.add(jpMenu);
        this.add(jptxt);

    }
    
}
