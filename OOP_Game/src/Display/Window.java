/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Display;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;


/**
 *
 * @author pangpntt
 */
public class Window{
    private JPanel menu, selectTeam;
    private JInternalFrame windowWin, windowLost, windowPause;
    private GamePanel game;
    private JFrame jf;
    
    public Window(){
    	JFrame jf = new JFrame();
        JPanel menu = new Menu(jf);
        jf.setLayout(new BorderLayout());
        jf.add(menu);  
        
        String filePath = "src/Music/bgmusic.wav";
  
        playMusic(filePath);
        
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        
    }
    
    public void playMusic(String musicLocation){
        try {          
            File musicPath = new File(musicLocation);
            
            if (musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                volume.setValue(-35.0f);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else {
                System.out.println("Can't find files.");
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
  
    public static void main(String[] args) {
        new Window();
    }

    
}
