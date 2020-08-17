package org.specificlanguage.javastone;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;

import java.nio.IntBuffer;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;


public class Hearthstone {

    private GLFWErrorCallback errorCallback = GLFWErrorCallback.createPrint(System.err);

    //key callback
    private GLFWKeyCallback keyCallback = new GLFWKeyCallback(){
        @Override
        public void invoke(long window, int key, int scancode, int action, int mods) {
            if(key == GLFW_KEY_ESCAPE && action == GLFW_PRESS){
                glfwSetWindowShouldClose(window, true);
            }
        }
    };

    //creates a window to start
    public void start(){
        glfwSetErrorCallback(errorCallback);

        if(!glfwInit()){
            throw new IllegalStateException("Can't initialize GLFW");
        }

        long window = glfwCreateWindow(640, 480, "Hello World", NULL, NULL);

        if(window == NULL){
            glfwTerminate();
            throw new RuntimeException("Failed to create the window");
        }

        glfwSetKeyCallback(window, keyCallback);
        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
        GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(window, (vidMode.width() - 640) / 2, (vidMode.height() - 480 / 2));
        GL.createCapabilities();

        IntBuffer width = MemoryUtil.memAllocInt(1);
        IntBuffer height = MemoryUtil.memAllocInt(1);

        while(!glfwWindowShouldClose(window)){
            double time = glfwGetTime();

            float ratio;

            /* Get width and height to calcualte the ratio */
            glfwGetFramebufferSize(window, width, height);
            ratio = width.get() / (float) height.get();

            /* Rewind buffers for next get */
            width.rewind();
            height.rewind();

            /* Set viewport and clear screen */
            glViewport(0, 0, width.get(), height.get());
            glClear(GL_COLOR_BUFFER_BIT);

            /* Set ortographic projection */
            glMatrixMode(GL_PROJECTION);
            glLoadIdentity();
            glOrtho(-ratio, ratio, -1f, 1f, 1f, -1f);
            glMatrixMode(GL_MODELVIEW);

            /* Rotate matrix */
            glLoadIdentity();
            glRotatef((float) glfwGetTime() * 50f, 0f, 0f, 1f);

            /* Render triangle */
            glBegin(GL_TRIANGLES);
            glColor3f(1f, 0f, 0f);
            glVertex3f(-0.6f, -0.4f, 0f);
            glColor3f(0f, 1f, 0f);
            glVertex3f(0.6f, -0.4f, 0f);
            glColor3f(0f, 0f, 1f);
            glVertex3f(0f, 0.6f, 0f);
            glEnd();



            glfwSwapBuffers(window);
            glfwPollEvents();

            width.flip();
            height.flip();
        }

        glfwDestroyWindow(window);
        keyCallback.free();
        glfwTerminate();
        errorCallback.free();
    }


    public static void main(String[] args) {
        new Hearthstone().start();
    }

}
