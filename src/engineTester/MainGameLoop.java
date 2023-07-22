package engineTester;

import org.lwjgl.glfw.GLFW;

import renderEngine.DisplayManager;

/**
 * This class contains the main method and is used to test the engine.
 * 
 * @author VitorBrisola
 *
 */
public class MainGameLoop {

    /**
     * Creates a display and then continuously updates the display until the user tries to close it.
     * @param args
     */
    public static void main(String[] args) {
        DisplayManager.createDisplay();

        while (!GLFW.glfwWindowShouldClose(DisplayManager.getWindow())) {

            // Game logic goes here
            // Render geometry goes here

            DisplayManager.updateDisplay();
        }

        DisplayManager.closeDisplay();
    }

}
