/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Display;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author pangpntt
 */
public class Menu extends JPanel{
    private JPanel jpTitle, jpButtonStart, jpButtonSystems, jpButtonExit, jpTitle1;
    private JButton buttonStart, buttonSystems, buttonExit;
    private JInternalFrame selectFrame, SystemsFrame;
    private JLabel title, title2;
    public Menu(){
    	this.setLayout(new BorderLayout());
    	jpTitle = new JPanel();
    	jpButtonStart = new JPanel();
    	jpButtonSystems = new JPanel();
    	jpButtonExit = new JPanel();
    	jpTitle1 = new JPanel();
    	
    	title = new JLabel("<html>WORLD CUP<br/>ADVENTURE</html>", SwingConstants.CENTER);
    	buttonStart = new JButton("Start");
    	buttonSystems = new JButton("Systems");
    	buttonExit = new JButton("Exit");
        
        buttonStart.setBackground(new java.awt.Color(89,6,4));
        buttonSystems.setBackground(new java.awt.Color(89,6,4));
        buttonExit.setBackground(new java.awt.Color(166,166,166));
        
        Color color = new Color(255,189,89);
        buttonStart.setForeground(color);
        buttonSystems.setForeground(color);
        buttonExit.setForeground(Color.RED);
        
    	
    	title.setFont(new Font("Monospaced", Font.BOLD, 80));
    	buttonStart.setFont(new Font("Monospaced", Font.BOLD, 60));
    	buttonSystems.setFont(new Font("Monospaced", Font.BOLD, 60));
        buttonExit.setFont(new Font("Monospaced", Font.BOLD, 60));
    	
    	jpTitle.setLayout(new GridLayout(3,1));
    	jpButtonExit.setLayout(new FlowLayout(FlowLayout.RIGHT));
    	
    	jpTitle1.add(title);

    	jpButtonStart.add(buttonStart);
    	jpButtonSystems.add(buttonSystems);
    	jpTitle.add(jpTitle1);

    	jpTitle.add(jpButtonStart);
    	jpTitle.add(jpButtonSystems);
    	jpButtonExit.add(buttonExit);
    	
    	
        this.add(jpTitle, BorderLayout.CENTER);
        this.add(jpButtonExit, BorderLayout.SOUTH);
        this.setPreferredSize(new Dimension(1240, 750));

    }
    public void changeToSystem(){
        
    }
}
