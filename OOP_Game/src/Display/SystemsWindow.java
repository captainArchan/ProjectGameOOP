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
import javax.swing.*;

/**
 *
 * @author pangpntt
 */
public class SystemsWindow {

	private JInternalFrame jpSystems;
	private JDesktopPane dp;
	private JPanel jpsound, jpback, jpSlider, picLabel;
	private JLabel sound, imgSound;
	private JButton back;
	private JSlider slider;
	private JFrame fr;
	private BufferedImage wPic;

	public SystemsWindow() {
		fr = new JFrame();
		
		jpSystems = new JInternalFrame("test", true, true, true, true);
		
		jpsound = new JPanel();
		jpback = new JPanel();
		jpSlider = new JPanel();
		
		sound = new JLabel("SOUND", SwingConstants.CENTER);
		
		dp = new JDesktopPane();
		
		slider = new JSlider();
		
		back = new JButton("BACK");
		back.setBorderPainted(false);
		back.setBackground(new java.awt.Color(17, 20, 20));
		back.setForeground(Color.RED);
		

		
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

		jpSystems.setLayout(new BorderLayout()); 
		jpsound.setLayout(new GridLayout(2, 1));
		jpsound.add(sound);
		jpsound.add(jpSlider);
		jpSystems.getContentPane().add(jpsound, BorderLayout.NORTH);

		jpback.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jpback.add(back);
		jpSystems.getContentPane().add(jpback);
		
		dp.add(jpSystems);
		fr.add(dp);
		jpSystems.setSize(700, 300);
		fr.setSize(1240, 750);
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
