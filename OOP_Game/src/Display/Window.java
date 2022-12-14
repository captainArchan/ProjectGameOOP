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
public class Window {
    private JPanel menu, selectTeam;
    private JInternalFrame windowWin, windowLost, windowPause;
    private Game game;
    private JFrame jf;
    
    
    public Window(){
        JPanel menu = new Menu();
        JPanel selectTeam = new SelectTeamWindow();
        jf = new JFrame();
        jf.setLayout(new BorderLayout());
        jf.add(menu);
//       jf.add(selectTeam);
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
    public void changePanel(){
        
    }
    public static void main(String[] args) {
        new Window();
    }
}
