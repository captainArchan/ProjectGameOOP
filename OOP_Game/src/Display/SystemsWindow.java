/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Display;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;

import Action.DisplayListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author pangpntt
 */
public class SystemsWindow extends JFrame {
	private JPanel jpsound, jpback, jpSlider, jpSystems, jpEmtry;
	private JLabel sound, imgSound;
	private JButton back;
	private JSlider slider;
	private BufferedImage wPic;
	private JFrame jf;
	private Clip soundTheme;
	private Window window;
        private float currentVolume = 0;
	public SystemsWindow(Window window) {
		this.window = window;
		this.soundTheme = this.window.getSound();
		
		
		jpSystems = new JPanel();
		jpsound = new JPanel();
		jpback = new JPanel();
		jpSlider = new JPanel();
		jpEmtry = new JPanel();
		
		slider = new JSlider(-40,6);
                slider.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        currentVolume = slider.getValue();
                        FloatControl volume = (FloatControl) soundTheme.getControl(FloatControl.Type.MASTER_GAIN);
                        volume.setValue(currentVolume);
                    }
                });

		sound = new JLabel("SOUND", SwingConstants.CENTER);

		back = new JButton("BACK");
		back.addActionListener(new DisplayListener(this.window, this));
		back.setBorderPainted(false); 
		back.setBackground(new java.awt.Color(17, 20, 20));
		back.setForeground(Color.RED);

		jpSlider.setBackground(new java.awt.Color(248, 157, 19));
		jpSystems.setBackground(new java.awt.Color(248, 157, 19));
		jpsound.setBackground(new java.awt.Color(248, 157, 19));
		jpback.setBackground(new java.awt.Color(248, 157, 19));
		Color color = new Color(143, 29, 20);
		sound.setForeground(color);

		try {
			wPic = ImageIO.read(this.getClass().getResource("/Image/sound.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		imgSound = new JLabel(new ImageIcon(new ImageIcon(wPic).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));

		Font myFont = new Font("Monospaced", Font.BOLD, 80);
		Font myFont2 = new Font("Monospaced", Font.BOLD, 30);
		sound.setFont(myFont);
		back.setFont(myFont2);

		jpSlider.setLayout(new BorderLayout());
		jpSlider.add(imgSound, BorderLayout.WEST);
		jpSlider.add(slider, BorderLayout.CENTER);
		jpSlider.add(jpEmtry, BorderLayout.EAST);

		jpSystems.setLayout(new BorderLayout());
		jpSystems.setBackground(new java.awt.Color(240, 249, 255));
		jpsound.setLayout(new GridLayout(2, 1));
		jpsound.add(sound);
		jpsound.add(jpSlider);
		jpSystems.add(jpsound, BorderLayout.NORTH);
		jpback.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jpback.add(back);
		jpSystems.add(jpback);


		this.add(jpSystems);
		this.setSize(700, 320);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
        
        public void volumnUp(){
            currentVolume += 1.0f;
            if(currentVolume > 6.0f){
                currentVolume = 6.0f;
            }
            FloatControl volume = (FloatControl) soundTheme.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(currentVolume);
        }
        
        public void volumnDown(){
            currentVolume -= 1.0f;
            if(currentVolume < -80.0f){
                currentVolume = -80.0f;
            }
            FloatControl volume = (FloatControl) soundTheme.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(currentVolume);
            
        }
        

}