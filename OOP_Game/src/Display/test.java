package Display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class test {

	private JInternalFrame jpSystems;
	private JDesktopPane dp;
	private JPanel jpsound, jpback, jpSlider, picLabel;
	private JLabel sound, imgSound;
	private JButton back;
	private JSlider slider;
	private JFrame fr;
	private BufferedImage wPic;

	public test() {

		jpSystems = new JInternalFrame("sound", true, true, true, true);

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
		imgSound = new JLabel(
				new ImageIcon(new ImageIcon(wPic).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));

		Font myFont = new Font("Monospaced", Font.BOLD, 80);
		Font myFont2 = new Font("Monospaced", Font.BOLD, 30);
		sound.setFont(myFont);
		back.setFont(myFont2);

		jpSlider.setLayout(new BorderLayout());
		jpSlider.add(imgSound, BorderLayout.WEST);
		jpSlider.add(slider, BorderLayout.CENTER);

		jpSystems.setLayout(new BorderLayout());
		jpSystems.setBackground(new java.awt.Color(240, 249, 255));
		jpsound.setLayout(new GridLayout(2, 1));
		jpsound.add(sound);
		jpsound.add(jpSlider);
		jpSystems.getContentPane().add(jpsound, BorderLayout.NORTH);

		jpback.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jpback.add(back);
		jpSystems.getContentPane().add(jpback);

		dp.add(jpSystems);
		jpSystems.setSize(700, 300);
		jpSystems.setLocation(250, 200);
		jpSystems.setVisible(true);


	}

}
