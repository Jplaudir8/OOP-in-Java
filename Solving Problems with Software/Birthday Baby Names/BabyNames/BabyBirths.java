
import edu.duke.*;
import org.apache.commons.csv.*;

/**
 * Write a description of BabyBirths here.
 * 
 * @author Joan Perez Lozano
 */

public class BabyBirths {
    public void printNames() {
        FileResource fr = new FileResource();
        
        // Sending false to getCSVParser() means there is no header row.
        for(CSVRecord rec: fr.getCSVParser(false)){ 
            int numBorn = Integer.parseInt(rec.get(2));
            if(numBorn <= 100){
                System.out.println("Name " + rec.get(0) + 
                                " Gender " + rec.get(1) + 
                                    " Num Born " + rec.get(2));
            }
        }
        
    }
    
    
}
