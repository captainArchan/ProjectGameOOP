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
    private JPanel jpTitle, jpButtonStart, jpButtonSystems, jpButtonExit, jpTitle1, jpTitle2;
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
    	jpTitle2 = new JPanel();
    	
    	title = new JLabel("WORLD CUP");
    	title2 = new JLabel("ADVENTURE");
    	
    	buttonStart = new JButton("Start");
    	buttonSystems = new JButton("Systems");
    	buttonExit = new JButton("Exit");
    	

    	jpTitle.setLayout(new GridLayout(4,1));
    	jpTitle1.add(title);
    	jpTitle2.add(title2);
    	jpButtonStart.add(buttonStart);
    	jpButtonSystems.add(buttonSystems);
    	jpTitle.add(jpTitle1);
    	jpTitle.add(jpTitle2);
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
