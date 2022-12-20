
package Display;

import java.awt.*;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;

public class Window extends JFrame {
	private Clip clip;
	private String filePath = "src/Music/bgmusic.wav";

	public Window() {
		
		playMusic(filePath);
		JPanel menu = new Menu(this);
		this.setLayout(new BorderLayout());
		this.add(menu);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void playMusic(String musicLocation) {
		try {
			File musicPath = new File(musicLocation);
			if (musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				this.clip = AudioSystem.getClip();
				clip.open(audioInput);
				FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				volume.setValue(-35.0f);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			} else {
				System.out.println("Can't find files.");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public Clip getSound() {
		return this.clip;
	}

	public static void main(String[] args) {
		new Window();
	}

}
