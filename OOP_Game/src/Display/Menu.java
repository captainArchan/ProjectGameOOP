/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Display;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Action.DisplayListener;
import java.io.File;

/**
 *
 * @author pangpntt
 */
public class Menu extends JPanel {

	private JPanel jpButtonStart, jpButtonSystems, jpButtonExit, jpbutton, jpimg, jp;
	private JButton buttonStart, buttonSystems, buttonExit;
	private JLabel title, img;
        ImageIcon icon = new ImageIcon("/ProjectGameOOP/OOP_Game/src/Image/Argen_win.png");
	private JFrame jf;

	public Menu(JFrame jf) {
		this.jf = jf;
		this.setLayout(new BorderLayout());

		jpButtonStart = new JPanel();
		jpButtonSystems = new JPanel();
		jpButtonExit = new JPanel();
		jpbutton = new JPanel();
		jpimg = new JPanel();
		jp = new JPanel();
		title = new JLabel("<html>WORLD CUP<br/>ADVENTURE<br><br></html>", SwingConstants.CENTER);
                img = new JLabel();
		title.setBorder(new EmptyBorder(60, 0, 0, 0));
		buttonStart = new JButton("Start");
		buttonSystems = new JButton("Systems");
		buttonExit = new JButton("Exit");
		buttonStart.addActionListener(new DisplayListener(jf));
		buttonSystems.addActionListener(new DisplayListener(jf));
		buttonExit.addActionListener(new DisplayListener(jf));
                img.setIcon(icon);
                img.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconWidth()));

		buttonStart.setBackground(new java.awt.Color(27, 18, 15));
		buttonSystems.setBackground(new java.awt.Color(27, 18, 15));
		buttonExit.setBackground(new java.awt.Color(238, 238, 238));
		this.setBackground(new java.awt.Color(143, 29, 20));
		jpButtonStart.setBackground(new java.awt.Color(143, 29, 20));
		jpButtonSystems.setBackground(new java.awt.Color(143, 29, 20));
		jpButtonExit.setBackground(new java.awt.Color(143, 29, 20)); 
		jp.setBackground(new java.awt.Color(143, 29, 20));

		Color color = new Color(248, 157, 19);
		Color color2 = new Color(230, 222, 221);
		buttonStart.setForeground(color2);
		buttonSystems.setForeground(color2);
		buttonExit.setForeground(Color.RED);

		title.setForeground(color);

		title.setFont(new Font("Monospaced", Font.BOLD, 80));
		buttonStart.setFont(new Font("Monospaced", Font.BOLD, 60));
		buttonSystems.setFont(new Font("Monospaced", Font.BOLD, 60));
		buttonExit.setFont(new Font("Monospaced", Font.BOLD, 60));

		jpButtonStart.setLayout(new FlowLayout());
		jpButtonSystems.setLayout(new FlowLayout());
		jpButtonExit.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jpimg.setLayout(new FlowLayout(FlowLayout.LEFT));
		jpbutton.setLayout(new GridLayout(2, 1));
		jp.setLayout(new FlowLayout());

		jpButtonStart.add(buttonStart);
		jpButtonSystems.add(buttonSystems);
		jpbutton.add(jpButtonStart);
		jpbutton.add(jpButtonSystems);
		jpButtonExit.add(buttonExit);
                jp.add(img);
                jp.add(title);

		this.add(jp, BorderLayout.NORTH);
		this.add(jpbutton);
		this.add(jpButtonExit, BorderLayout.SOUTH);
		this.setPreferredSize(new Dimension(1240, 750));
	}



}
