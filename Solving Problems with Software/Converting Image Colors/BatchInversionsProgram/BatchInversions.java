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
            
            outPixel.setRed(255 - inPixel.getRed());
            outPixel.setGreen(255 - inPixel.getGreen());
            outPixel.setBlue(255 - inPixel.getBlue());
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
