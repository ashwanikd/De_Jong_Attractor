package drawing;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DrawingFrame extends Frame {

    DrawingFrame mInstance;

    DrawingCanvas mCanvas;

    public DrawingFrame() {
        mCanvas = new DrawingCanvas();
        mInstance = this;
        mInstance.add(mCanvas.getCanvas());
        mInstance.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                mCanvas.getAnimator().stop();
                System.exit(0);
            }
        });
    }

    public void setFrameSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (screenSize.width < screenSize.height) {
            mInstance.setSize(screenSize.width, screenSize.width);
        } else {
            mInstance.setSize(screenSize.height - 200, screenSize.height - 200);
        }
    }

    public void setFrameSize(int width, int height) {
        mInstance.setSize(width,height);
    }

    public DrawingFrame showFrame() {
        mInstance.setVisible(true);
        return mInstance;
    }

    public void startAnimation() {
        mCanvas.getAnimator().start();
    }

    public void setVariables(double[] variables) {
        mCanvas.setVariables(variables);
    }

    public void setIterations(int itr) {
        mCanvas.setIterations(itr);
    }

    public DrawingFrame hideFrame() {
        mInstance.setVisible(false);
        return mInstance;
    }
}
