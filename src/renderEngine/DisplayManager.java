package renderEngine;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

/**
 * This class contains all the methods needed to set up, maintain, and close a LWJGL display.
 * 
 * @author VitorBrisola
 *
 */
public class DisplayManager {

    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final int FPS_CAP = 60;
    private static final String TITLE = "Our First Display";

    private static long window;

    /**
     * Creates a display window on which we can render our game. The dimensions
     * of the window are determined by setting the width and height. We also
     * specify that we want an OpenGL context with the specified version.
     */
    public static void createDisplay() {
        GLFWErrorCallback.createPrint(System.err).set();

        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Falha ao inicializar o GLFW");
        }

        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);

        window = GLFW.glfwCreateWindow(WIDTH, HEIGHT, TITLE, 0, 0);
        if (window == 0) {
            throw new RuntimeException("Falha ao criar a janela GLFW");
        }

        GLFWVidMode vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        GLFW.glfwSetWindowPos(window, (vidMode.width() - WIDTH) / 2, (vidMode.height() - HEIGHT) / 2);

        GLFW.glfwMakeContextCurrent(window);
        GLFW.glfwShowWindow(window);

        GL.createCapabilities();
        GL11.glViewport(0, 0, WIDTH, HEIGHT);
    }

    /**
     * This method is used to update the display at the end of every frame. When
     * we have set up a rendering process this method will display whatever
     * we've been rendering onto the screen. The "sync" method is used here to
     * cap the frame rate. Without this the computer would just try to run the
     * game as fast as it possibly can, doing more work than it needs to.
     */
    public static void updateDisplay() {
        // Set dark green background color
        GL11.glClearColor(0.0f, 100.0f / 255.0f, 0.0f, 1.0f);
        // Clear the color buffer and depth buffer
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

        GLFW.glfwSwapBuffers(window);
        GLFW.glfwPollEvents();
    }

    /**
     * This closes the window when the game is closed.
     */
    public static void closeDisplay() {
        GLFW.glfwTerminate();
    }

    /**
     * Get the window of the display.
     */
    public static long getWindow() {
        return window;
    }

}
