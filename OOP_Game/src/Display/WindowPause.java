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
public class WindowPause {
    private JFrame fr;
    private JInternalFrame jpPause;
    private JDesktopPane dp;
    private JPanel jpPlay, jpRestart, jpMenu;
    private JButton buttonPlay, buttonRestart, buttonMenu;
    public WindowPause(){
        fr = new JFrame();
        jpPause = new JInternalFrame("pause", true, true, true, true);
        dp = new JDesktopPane();
        jpPlay = new JPanel();
        jpRestart = new JPanel();
        jpMenu = new JPanel();
        buttonPlay = new JButton("PLAY");
        buttonRestart = new JButton("RESTART");
        buttonMenu = new JButton("MENU");
        
        Font myFont = new Font("Monospaced", Font.BOLD, 50);
        buttonPlay.setFont(myFont);
        buttonRestart.setFont(myFont);
        buttonMenu.setFont(myFont);
        
        buttonPlay.setBackground(new java.awt.Color(143, 29, 20));
        buttonRestart.setBackground(new java.awt.Color(143, 29, 20));
        buttonMenu.setBackground(new java.awt.Color(143, 29, 20));
        jpPause.setBackground(new java.awt.Color(248, 157, 19));
        jpPlay.setBackground(new java.awt.Color(248, 157, 19));
        jpRestart.setBackground(new java.awt.Color(248, 157, 19));
        jpMenu.setBackground(new java.awt.Color(248, 157, 19));
        
        buttonPlay.setForeground(Color.WHITE);
        buttonRestart.setForeground(Color.WHITE);
        buttonMenu.setForeground(Color.WHITE);
        
        fr.setLayout(new BorderLayout());
        jpPause.setLayout(new GridLayout(3,1));
        jpPlay.setLayout(new FlowLayout());
        jpRestart.setLayout(new FlowLayout());
        jpMenu.setLayout(new FlowLayout());
        
        jpPlay.add(buttonPlay);
        jpRestart.add(buttonRestart);
        jpMenu.add(buttonMenu);
        jpPause.add(jpPlay);
        jpPause.add(jpRestart);
        jpPause.add(jpMenu);
        dp.add(jpPause);
        fr.add(dp);
        
        jpPause.setSize(350, 400);
        jpPause.setLocation(430, 150);
        jpPause.setVisible(true);
        fr.setSize(1240, 750);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
    
    public static void main(String[] args) {
        new WindowPause();
    }
}
