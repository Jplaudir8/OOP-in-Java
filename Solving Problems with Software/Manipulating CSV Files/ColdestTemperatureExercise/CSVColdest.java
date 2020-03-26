
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
                lowestSoFar = getLowestSoFar(currentRow, lowestSoFar);
            }
        }
        return null;
    }
    
    public CSVRecord getLowestSoFar(CSVRecord currentRow, CSVRecord lowestSoFar) {
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
    
    public void testColdestHourInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowest = coldestHourInFile(parser);
        System.out.println("hottest temperature was " + lowest.get("TemperatureF") +
                            " at " + lowest.get("TimeEST"));
    }
    
    
}


