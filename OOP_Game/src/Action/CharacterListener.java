package Action;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Display.GamePanel;

public class CharacterListener implements KeyListener{
	private boolean leftPressed , rightPressed, jumpPressed, slidePressed;
	private GamePanel gp;
	public CharacterListener(GamePanel gp) {
		this.gp = gp;
	}
    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            jumpPressed = true;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_S){
            slidePressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    	System.out.println("1");
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            jumpPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_S){
            slidePressed = false;
        }
    }
    
    public boolean getLeftPressed () {
    	return leftPressed;
    }
    public boolean getRightPressed() {
    	return rightPressed;
    }
    public boolean getJumpPressed() {
    	return  jumpPressed;
    }
    public boolean getSlidePressed () {
    	return slidePressed;
    }
    

}
