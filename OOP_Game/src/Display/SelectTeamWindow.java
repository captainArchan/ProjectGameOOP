/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Display;

import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Action.DisplayListener;

/**
 *
 * @author pangpntt
 */
public class SelectTeamWindow extends JPanel {
	private final int originalTileSize = 16;
	private final int scale = 6;
	private final int tileSize = originalTileSize * scale;
	private int maxScreenCol = 13;
	private int maxScreenRow = 8;
	private final int screenWidth = tileSize * maxScreenCol;
	private final int screenHeight = tileSize * maxScreenRow;
	

    private JPanel jpteam, jpback, jptxt, jpSelect;
    private JButton buttonGermany, buttonBrazil, buttonArgentina, back;
    private JLabel title, germany, brazil, argentina;
    private BufferedImage PicGer, PicBra, PicArgen;

    //private Graphics g;
    private Window window;
    public SelectTeamWindow(Window window) {
    	this.window = window;
        jpteam = new JPanel();
        jpback = new JPanel();
        jptxt = new JPanel();
        jpSelect = new JPanel();

        back = new JButton("BACK");
        back.addActionListener(new DisplayListener(this.window));
        
        title = new JLabel("SELECT", SwingConstants.CENTER);
        title.setBorder(new EmptyBorder(70, 0, 0, 0));
        germany = new JLabel(" GERMANY   ");
        brazil = new JLabel("BRAZIL  ");
        argentina = new JLabel("ARGENTINA");
        
        Color color = new Color(236, 155, 91);
        Color color2 = new Color(248, 157, 19);
        title.setForeground(color2);
        germany.setForeground(Color.WHITE);
        brazil.setForeground(Color.WHITE);
        argentina.setForeground(Color.WHITE);
        back.setForeground(color);
        ImageIcon icon = new ImageIcon("/Image/agen.gif");
        JLabel gif = new JLabel(icon);

        title.setFont(new Font("Monospaced", Font.BOLD, 100));
        germany.setFont(new Font("Monospaced", Font.BOLD, 50));
        brazil.setFont(new Font("Monospaced", Font.BOLD, 50));
        argentina.setFont(new Font("Monospaced", Font.BOLD, 50)); 
        back.setFont(new Font("Monospaced", Font.BOLD, 50));

        try {
            PicGer = ImageIO.read(this.getClass().getResource("/Image/Germany_stand_jump.png"));
            PicBra = ImageIO.read(this.getClass().getResource("/Image/Brazil_stand_jump.png"));
            PicArgen = ImageIO.read(this.getClass().getResource("/Image/Argen_stand_jump.png"));
            //bg = ImageIO.read(this.getClass().getResource("/Image/bgSelect.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        buttonGermany = new JButton(new ImageIcon(new ImageIcon(PicGer).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT)));
        buttonBrazil = new JButton(new ImageIcon(new ImageIcon(PicBra).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT)));
        buttonArgentina = new JButton(new ImageIcon(new ImageIcon(PicArgen).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT)));
        buttonGermany.addActionListener(new DisplayListener(this.window));
        buttonGermany.setActionCommand("Germany");
        buttonBrazil.addActionListener(new DisplayListener(this.window));
        buttonBrazil.setActionCommand("Brazil");
        buttonArgentina.addActionListener(new DisplayListener(this.window));
        buttonArgentina.setActionCommand("Argentina");
        this.setLayout(new BorderLayout());
        
        jpteam.setLayout(new FlowLayout()); 
        jptxt.setLayout(new FlowLayout());
        jpback.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jpSelect.setLayout(new GridLayout(2, 1));
        jpteam.add(buttonGermany);
        jpteam.add(buttonBrazil);
        jpteam.add(buttonArgentina);
        jptxt.add(germany);
        jptxt.add(brazil);
        jptxt.add(argentina);
        jpSelect.add(jpteam);
        jpSelect.add(jptxt);
        jpback.add(back);

        this.add(title, BorderLayout.NORTH);
        this.add(jpSelect);
        this.add(jpback, BorderLayout.SOUTH);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));

        this.setBackground(new java.awt.Color(143, 29, 20));
        jptxt.setBackground(new java.awt.Color(143, 29, 20));
        jpback.setBackground(new java.awt.Color(143, 29, 20));
        jpteam.setBackground(new java.awt.Color(143, 29, 20));
        jpSelect.setBackground(new java.awt.Color(143, 29, 20));
        back.setBackground(Color.BLACK);
        buttonGermany.setBackground(new java.awt.Color(236, 155, 91));
        buttonBrazil.setBackground(new java.awt.Color(236, 155, 91));
        buttonArgentina.setBackground(new java.awt.Color(236, 155, 91));
    }

}
