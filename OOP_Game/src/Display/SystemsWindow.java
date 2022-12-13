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
public class SystemsWindow {
    private JInternalFrame jpSystems;
    private JDesktopPane dp;
    private JPanel jpsound, jpback;
    private JLabel sound;
    private JButton back, s;
    private JFrame fr;
    public SystemsWindow(){
        fr = new JFrame();
        jpSystems = new JInternalFrame("tesr", true, true,true,true);
        jpsound = new JPanel();
        jpback = new JPanel();
        sound = new JLabel("SOUND");
        back = new JButton("BACK");
        s = new JButton("s");
        dp = new JDesktopPane();
        fr.setLayout(new BorderLayout());
        jpSystems.setLayout(new BorderLayout());
        jpsound.setLayout(new GridLayout(2,1));
        jpsound.add(sound);
        jpsound.add(s);
        jpSystems.getContentPane().add(jpsound, BorderLayout.NORTH);
        jpback.setLayout(new FlowLayout());
        jpback.add(back);
        jpSystems.getContentPane().add(jpback);
        dp.add(jpSystems);
        fr.add(dp);
        jpSystems.setPreferredSize(new Dimension(800, 400));
        fr.setSize(1240, 750);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jpSystems.setVisible(true);
        fr.setVisible(true);
    }
    
    public static void main(String[] args) {
        new SystemsWindow();
    }
}
