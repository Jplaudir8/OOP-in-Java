
/**
 * Write a description of CSVColdest here.
 * 
 * @author Joan Perez Lozano
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVColdest {
    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord lowestSoFar = null;
        for(CSVRecord currentRow: parser){
            if(Double.parseDouble(currentRow.get("TemperatureF")) != -9999 ){
                lowestSoFar = getLowestOfTwo(currentRow, lowestSoFar);
            }
        }
        return null;
    }
    
    public CSVRecord getLowestOfTwo(CSVRecord currentRow, CSVRecord lowestSoFar) {
        if(lowestSoFar == null){
            lowestSoFar = currentRow;
        } else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
            if(currentTemp > lowestTemp){
                lowestSoFar = currentRow;
            }
        }
        return lowestSoFar;
    }
    
    public String fileWithColdestTemperature() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestSoFar = null;
        for(File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            lowestSoFar = getLowestOfTwo(currentRow, lowestSoFar);
        }
        
        return "";
    }
    
    public void testFileWithColdestTemperature() {
        // Use coldestHourInFile() after determining the file, to see the temp in that file.
    }
    
    public void testColdestHourInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowest = coldestHourInFile(parser);
        System.out.println("hottest temperature was " + lowest.get("TemperatureF") +
                            " at " + lowest.get("TimeEST"));
    }
    
    
}


