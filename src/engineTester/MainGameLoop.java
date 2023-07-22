package engineTester;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class MainGameLoop {
    public static void main(String[] args) {
        // Inicialização do GLFW
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Falha ao inicializar o GLFW");
        }

        // Configuração da janela
        long window = GLFW.glfwCreateWindow(800, 600, "Meu Jogo", 0, 0);
        if (window == 0) {
            GLFW.glfwTerminate();
            throw new RuntimeException("Falha ao criar a janela GLFW");
        }

        // Configuração da resolução da janela
        GLFWVidMode vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        GLFW.glfwSetWindowPos(window, (vidMode.width() - 800) / 2, (vidMode.height() - 600) / 2);

        // Definir o contexto OpenGL atual para a janela
        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities();

        // Loop principal
        while (!GLFW.glfwWindowShouldClose(window)) {
            // Renderização
        	GL11.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
        	GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

            // Troca de buffers e gerenciamento de eventos
            GLFW.glfwSwapBuffers(window);
            GLFW.glfwPollEvents();
        }

        // Finalização do GLFW
        GLFW.glfwTerminate();
    }
}
