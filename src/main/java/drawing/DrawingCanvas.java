package drawing;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import java.awt.*;

public class DrawingCanvas implements GLEventListener {

    FPSAnimator mAnimator;

    GLCanvas mCanvas;

    GLEventListener mGLEventListener;

    private GL2 gl;

    double x,y;

    double x_t,y_t;

    double draw_x,draw_y;

    double red = 0, green = 1, blue = 1;

    double a,b,c,d;

    private int ITERATIONS = 100;

    private double mColorIncrement = 0.001;

    public DrawingCanvas() {
        mGLEventListener = this;
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        mCanvas = new GLCanvas(capabilities);
        mCanvas.addGLEventListener(mGLEventListener);
        mAnimator = new FPSAnimator(mCanvas,300,true);
        x = 0;
        y = 0;
    }

    public GLCanvas getCanvas() {
        return mCanvas;
    }

    public FPSAnimator getAnimator() {
        return mAnimator;
    }

    public void setIterations(int itr) {
        ITERATIONS = itr;
    }

    public void setVariables(double[] variables) {
        a = variables[0];
        b = variables[1];
        c = variables[2];
        d = variables[3];
    }

    private void addPoint() {
        x_t = x;
        y_t = y;
        x = Math.sin(a * y_t) - Math.cos(b * x_t);
        y = Math.sin(c * x_t) - Math.cos(d * y_t);
        transform();
        setColor();
        gl.glBegin(GL2.GL_POINTS);
        gl.glVertex3d(draw_x,draw_y,0);
        gl.glEnd();
    }

    private void transform() {
        draw_x = x / 2.0;
        draw_y = y / 2.0;
    }

    private void setColor() {
        gl.glColor3d(red,green,blue);
    }

    /////////////////////////////////////GL code/////////////////////////////////////
    public void init(GLAutoDrawable glAutoDrawable) {

    }

    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    public void display(GLAutoDrawable glAutoDrawable) {
        gl = glAutoDrawable.getGL().getGL2();
        gl.glClearColor(1,1,1,1);
        gl.glClear(gl.GL_DEPTH_BUFFER_BIT|gl.GL_COLOR_BUFFER_BIT);
        gl.glLoadIdentity();

        for(int i=0; i<ITERATIONS; i++) {
            addPoint();
        }
    }

    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
    /////////////////////////////////////GL code/////////////////////////////////////
}
