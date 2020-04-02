import edu.duke.*;

/**
 * Write a description of GrayScaleConverter here.
 * 
 * @author Joan Perez Lozano
 */
public class GrayScaleConverter {
    public ImageResource makeGray(ImageResource inImage) {
    
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for(Pixel pixel: outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            
            int average = (inPixel.getRed()+inPixel.getGreen()+inPixel.getBlue())/3;
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
            
        }
        return outImage;
    }
}
