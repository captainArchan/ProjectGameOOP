/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Display;

import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author pangpntt
 */
public class WindowLose extends extraWindow {
    private JFrame fr;
    private JInternalFrame jpLose;
    private JDesktopPane dp;
    private JPanel jptxt1, jptxt2, jpbutton;
    private JButton buttonRestart, buttonBackToMenu;
    private JLabel textLose, txt2;
    public WindowLose(){
        fr = new JFrame();
        jpLose = new JInternalFrame("lose", true, true, true, true);
        dp = new JDesktopPane();
        jptxt1 = new JPanel();
        jpbutton = new JPanel();
        jptxt2 = new JPanel();
        buttonRestart = new JButton("RESTART");
        buttonBackToMenu = new JButton("MENU");
        textLose = new JLabel("GAME", SwingConstants.CENTER);
        txt2 = new JLabel("OVER", SwingConstants.CENTER);
        
        Font myFont = new Font("Monospaced", Font.BOLD, 100);
        Font myFont2 = new Font("Monospaced", Font.BOLD, 30);
        textLose.setFont(myFont);
        txt2.setFont(myFont);
        buttonRestart.setFont(myFont2);
        buttonBackToMenu.setFont(myFont2);
        
        jpLose.setBackground(new java.awt.Color(27, 18, 15));
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
          
        fr.setLayout(new BorderLayout());
        jpLose.setLayout(new GridLayout(3,1));
        jptxt1.setLayout(new BorderLayout());
        jptxt2.setLayout(new BorderLayout());
        jpbutton.setLayout(new FlowLayout());
        jptxt1.add(textLose);
        jptxt2.add(txt2);
        jpbutton.add(buttonRestart);
        jpbutton.add(buttonBackToMenu);
        jpLose.add(jptxt1);
        jpLose.add(jptxt2);
        jpLose.add(jpbutton);
        
        dp.add(jpLose);
        fr.add(dp);
        
        jpLose.setSize(500, 380);
        jpLose.setLocation(350, 150);
        jpLose.setVisible(true);
        fr.setSize(1240, 750);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
    
    public static void main(String[] args) {
        new WindowLose();
    }
}
