package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {

	//integers to define the dimensions of the display
	private final static int WIDTH = 1280;
	private final static int HEIGHT = 720;
	private final static int FPS_CAP = 120;
	
	//method that will start up the display
	public static void createDisplay() {
		
		ContextAttribs attributes = new ContextAttribs(3,2).withForwardCompatible(true).withProfileCore(true);
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat(), attributes);
			Display.setTitle("Magiscape");
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
	}
	
	//method that will update the display
	public static void updateDisplay() {
		Display.sync(FPS_CAP);
		Display.update();
	}
	
	//method to close the display
	public static void closeDisplay() {
		Display.destroy();
	}
	
}
