package Action;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Display.SystemsWindow;

public class SoundListener implements ChangeListener{
	private SystemsWindow systemsWindow;
	private Clip soundTheme;
	private float currentVolume = 0;
	public SoundListener(Clip soundTheme, SystemsWindow systemsWindow) {
		this.soundTheme = soundTheme;
		this.systemsWindow = systemsWindow;
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		currentVolume = this.systemsWindow.getSliderValue();
		FloatControl volume = (FloatControl) soundTheme.getControl(FloatControl.Type.MASTER_GAIN);
		volume.setValue(currentVolume);
	}

}
