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
public class WindowWin {
    private JFrame fr;
    private JInternalFrame jpWin;
    private JDesktopPane dp;
    private JPanel jptxt, jpMenu;
    private JButton ButtonBackToMenu;
    private JLabel textWin;
    public WindowWin(){ 
        fr = new JFrame();
        jpWin = new JInternalFrame("winner", true, true, true, true);
        dp = new JDesktopPane();
        jptxt = new JPanel();
        jpMenu = new JPanel();
        ButtonBackToMenu = new JButton("MENU");
        textWin = new JLabel("WINNER", SwingConstants.CENTER);
        
        Font myFont = new Font("Monospaced", Font.BOLD, 100);
        Font myFont2 = new Font("Monospaced", Font.BOLD, 50);
        textWin.setFont(myFont);
        ButtonBackToMenu.setFont(myFont2);
        
        jpWin.setBackground(new java.awt.Color(248, 157, 19));
        jptxt.setBackground(new java.awt.Color(248, 157, 19));
        jpMenu.setBackground(new java.awt.Color(248, 157, 19));
        ButtonBackToMenu.setBackground(new java.awt.Color(27, 18, 15));
        
        Color color = new Color(230, 222, 221);
        Color color2 = new Color(143, 29, 20);
        textWin.setForeground(color2);
        ButtonBackToMenu.setForeground(color);
        
        fr.setLayout(new BorderLayout());
        jpWin.setLayout(new BorderLayout());
        jptxt.setLayout(new GridLayout(2,1));
        jpMenu.setLayout(new FlowLayout());
        
        jpMenu.add(ButtonBackToMenu);
        jptxt.add(textWin);
        jptxt.add(jpMenu);
        jpWin.add(jptxt);
        dp.add(jpWin);
        fr.add(dp);
        
        
        jpWin.setSize(500, 300);
        jpWin.setLocation(380, 200);
        jpWin.setVisible(true);
        fr.setSize(1240, 750);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
    
    public static void main(String[] args) {
        new WindowWin();
    }
}
