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

/**
 *
 * @author pangpntt
 */
public class WindowLose extends extraWindow {
    private JFrame fr;
    private JInternalFrame jpLose;
    private JDesktopPane dp;
    private JPanel jptxt, jpbutton;
    private JButton buttonRestart, buttonBackToMenu;
    private JLabel textLose;
    public WindowLose(){
        fr = new JFrame();
        jpLose = new JInternalFrame("lose", true, true, true, true);
        dp = new JDesktopPane();
        jptxt = new JPanel();
        jpbutton = new JPanel();
        buttonRestart = new JButton("RESTART");
        buttonBackToMenu = new JButton("MENU");
        textLose = new JLabel("<html>GAME<br/>OVER</html>", SwingConstants.CENTER);
        
        Font myFont = new Font("Monospaced", Font.BOLD, 100);
        Font myFont2 = new Font("Monospaced", Font.BOLD, 30);
        textLose.setFont(myFont);
        buttonRestart.setFont(myFont2);
        buttonBackToMenu.setFont(myFont2);
                
        fr.setLayout(new BorderLayout());
        jpLose.setLayout(new BorderLayout());
        jptxt.setLayout(new GridLayout(2,1));
        jpbutton.setLayout(new FlowLayout());
        
        jpbutton.add(buttonRestart);
        jpbutton.add(buttonBackToMenu);
        jptxt.add(textLose);
        jptxt.add(jpbutton);
        jpLose.add(jptxt);
        dp.add(jpLose);
        fr.add(dp);
        
        jpLose.setSize(500, 450);
        jpLose.setLocation(350, 100);
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
