package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;

public class MainGameLoop {
	public static void main(String [] args) {
		//calls method that will open the display
		DisplayManager.createDisplay();
		
		//game loop
		while(!Display.isCloseRequested()) {
			//updates the display
			DisplayManager.updateDisplay();
		}
		//closes the display after the loop is over
		DisplayManager.closeDisplay();
	}
}
