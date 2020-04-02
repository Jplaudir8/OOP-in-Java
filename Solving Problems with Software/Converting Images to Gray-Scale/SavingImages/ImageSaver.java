import edu.duke.*;
import java.io.File;

/**
 * Write a description of ImageSaver here.
 * 
 * @author Joan Perez Lozano
 */

public class ImageSaver {
    public void doSave() {
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()) {
            ImageResource image = new ImageResource(f);
            String fname = image.getFileName();
            String newName = "copy-" + fname;
            image.setFileName(newName);
            image.draw();
            image.save();
        }
    }
}
