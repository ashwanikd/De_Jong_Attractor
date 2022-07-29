package packagemain;

import drawing.DrawingFrame;

public class Main {
    public static void main(String args[]) {
        DrawingFrame frame = new DrawingFrame();
        frame.setFrameSize();
        double[] variables = {2, -2, -1.2, 2};
        frame.setVariables(variables);
        frame.setIterations(100000);
        frame.setSpeed(0.08);
        frame.showFrame();
        frame.startAnimation();
    }
}
