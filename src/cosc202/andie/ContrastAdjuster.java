package cosc202.andie;

import java.awt.image.*;

public class ContrastAdjuster implements ImageOperation, java.io.Serializable{

    private double contrastPercent;
    private double brightPercent;
    /**
     * Default Constructor
     */
    public ContrastAdjuster(){

    }
    /**
     * Constructor
     * @param contrastPercent = percentage that user inputs for desired change
     * @param brightPercent = percentage that user inputs for desired change
     */
    public ContrastAdjuster(double contrastPercent, double brightPercent){
        this.contrastPercent = contrastPercent;
        this.brightPercent = brightPercent;
    }

    /**
     * @param input The image to be converted to adjusted
     * @return The resulting adjusted image.
     */
    public BufferedImage apply(BufferedImage input) {
        
        // Loop through image pixel by pixel and finds argb values at (x, y)
        for (int y = 0; y < input.getHeight(); ++y) {
            for (int x = 0; x < input.getWidth(); ++x) {
                int argb = input.getRGB(x, y);
                int a = (argb & 0xFF000000) >> 24;
                int r = (argb & 0x00FF0000) >> 16;
                int g = (argb & 0x0000FF00) >> 8;
                int b = (argb & 0x000000FF);

                // Adjusting rgb values according to formula given
                double contrastAdjuster = (1 + (contrastPercent / 100));
                double brightAdjuster = (1 + (brightPercent / 100));
                double newR = r - 127.5;
                double newG = g - 127.5;
                double newB = b - 127.5;
                r = (int) Math.round((contrastAdjuster * newR) + (127.5 * brightAdjuster));
                g = (int) Math.round((contrastAdjuster * newG) + (127.5 * brightAdjuster));
                b = (int) Math.round((contrastAdjuster * newB) + (127.5 * brightAdjuster));

                // Clip RGB values to range [0, 255]
                r = Math.min(Math.max(r, 0), 255);
                g = Math.min(Math.max(g, 0), 255);
                b = Math.min(Math.max(b, 0), 255);

                // Setting pixel to new rgb values
                argb = (a << 24) | (r << 16) | (g << 8) | b;
                input.setRGB(x, y, argb);
            }
        }

        return input;
    };
    
}