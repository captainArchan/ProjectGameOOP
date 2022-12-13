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
    private JPanel jpTitle, jpButtonStart, jpButtonSystems, jpButtonExit, jpButton;
    private JButton buttonStart, buttonSystems, buttonExit;
    private JInternalFrame selectFrame, SystemsFrame;
    private JLabel title, title2;
    public Menu(){

        jpTitle = new JPanel();
        jpButtonStart = new JPanel();
        jpButtonSystems = new JPanel();
        jpButtonExit = new JPanel();
        jpButton = new JPanel();
        buttonStart = new JButton("START");
        buttonSystems = new JButton("SYSTEMS");
        buttonExit = new JButton("EXIT");
        title = new JLabel("WORLD CUP");
        title2 = new JLabel("ADVENTURE");
        this.setLayout(new BorderLayout());
        jpTitle.setLayout(new GridLayout(2,1));
        jpTitle.add(title);
        jpTitle.add(title2);
        this.add(jpTitle, BorderLayout.NORTH);
        jpButton.setLayout(new GridLayout(2,1));
        jpButtonStart.setLayout(new FlowLayout());
        jpButtonStart.add(buttonStart);
        jpButtonSystems.setLayout(new FlowLayout());
        jpButtonSystems.add(buttonSystems);
        jpButton.add(jpButtonStart);
        jpButton.add(jpButtonSystems);
        this.add(jpButton);
        jpButtonExit.setLayout(new FlowLayout());
        jpButtonExit.add(buttonExit);
        this.add(jpButtonExit, BorderLayout.SOUTH);
        this.setPreferredSize(new Dimension(640, 480));

    }
    public void changeToSystem(){
        
    }
}
