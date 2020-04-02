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
        for(Pixel outPixel: outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(outPixel.getX(), outPixel.getY());
            
            int invertedRed = 255 - inPixel.getRed();
            int invertedGreen = 255 - inPixel.getGreen();
            int invertedBlue = 255 - inPixel.getBlue();
            
            outPixel.setRed(invertedRed);
            outPixel.setGreen(invertedGreen);
            outPixel.setBlue(invertedBlue);
        }
        return outImage;
    }
    
    public void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource invertedImage = makeInversion(inImage);
            String name = inImage.getFileName();
            String newName = "inverted-" + name;
            invertedImage.setFileName(newName);
            invertedImage.save();
        }
        
    }
    
    
    
    
    
}
