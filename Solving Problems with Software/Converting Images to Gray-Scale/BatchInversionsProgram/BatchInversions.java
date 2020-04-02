import edu.duke.*;
import java.io.File;

/**
 * Write a description of BatchInversions here.
 * 
 * @author Joan Perez Lozano
 */

public class BatchInversions {
    public ImageResource makeInversion(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for(Pixel pixel: outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            
            int invertedRed = 255 - inPixel.getRed();
            int invertedGreen = 255 - inPixel.getGreen();
            int invertedBlue = 255 - inPixel.getBlue();
            
            inPixel.setRed(invertedRed);
            inPixel.setGreen(invertedGreen);
            inPixel.setBlue(invertedBlue);
        }
        return outImage;
    }
    
    public
}
