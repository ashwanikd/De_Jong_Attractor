package packagemain;

import drawing.DrawingFrame;

public class Main {
    public static void main(String args[]) {
        DrawingFrame frame = new DrawingFrame();
        frame.setFrameSize();
        double[] variables = {2, -2.5, -3.2, -1};
        frame.setVariables(variables);
        frame.setIterations(1000000);
        frame.showFrame();
    }
}
