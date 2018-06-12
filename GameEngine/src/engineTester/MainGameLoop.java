package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;
import shaders.StaticShader;

public class MainGameLoop {
	public static void main(String [] args) {
		//calls method that will open the display
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		Renderer render = new Renderer();
		StaticShader shader = new StaticShader();	
		
		float[] vertices = {
				-0.5f, 0.5f, 0,
				-0.5f, -0.5f, 0,
				0.5f, -0.5f, 0,
				0.5f, 0.5f, 0
		};
		
		int[] indices = {
			0, 1, 3, 3, 1, 2	
		};
		
		RawModel model = loader.loadToVAO(vertices, indices);
		
		//game loop
		while(!Display.isCloseRequested()) {
			render.prepare();
			shader.start();
			render.render(model);
			shader.stop();
			//updates the display
			DisplayManager.updateDisplay();
		}
		shader.cleanUp();
		loader.cleanUp();
		
		//closes the display after the loop is over
		DisplayManager.closeDisplay();
	}
}
