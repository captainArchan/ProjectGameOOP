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
    private JButton back;
    private JSlider s;
    private JFrame fr;

    public SystemsWindow() {
        fr = new JFrame();
        jpSystems = new JInternalFrame("test", true, true, true, true);
        jpsound = new JPanel();
        jpback = new JPanel();
        sound = new JLabel("SOUND", SwingConstants.CENTER);
        back = new JButton("BACK");
        s = new JSlider();
        dp = new JDesktopPane();
        Font myFont = new Font("Monospaced", Font.BOLD, 80);
        Font myFont2 = new Font("Monospaced", Font.BOLD, 30);
        sound.setFont(myFont);
        back.setFont(myFont2);
        
        fr.setLayout(new BorderLayout());
        jpSystems.setLayout(new BorderLayout());
        jpsound.setLayout(new GridLayout(2, 1));
        jpsound.add(sound);
        jpsound.add(s);
        jpSystems.getContentPane().add(jpsound, BorderLayout.NORTH);
        
        jpback.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jpback.add(back);
        jpSystems.getContentPane().add(jpback);
        
        dp.add(jpSystems);
        fr.add(dp);
        jpSystems.setSize(700, 300);
        fr.setSize(1240, 750);
        fr.add(dp);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jpSystems.setLocation(250, 200);
        jpSystems.setVisible(true);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            SystemsWindow frame = new SystemsWindow();
        });
        
    }
}
