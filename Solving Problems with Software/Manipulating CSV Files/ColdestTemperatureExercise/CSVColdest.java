
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
                if(lowestSoFar == null){
                    lowestSoFar = currentRow;
                } else {
                    double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                    double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
                    if(currentTemp < lowestTemp){
                        lowestSoFar = currentRow;
                    }
                }
            }
        }
        return lowestSoFar;
    }
    
    public void testColdestHourInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowest = coldestHourInFile(parser);
        System.out.println("coldest temperature was " + lowest.get("TemperatureF") +
                            " at " + lowest.get("TimeEST"));
    }
    
    public String fileWithColdestTemperature() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestSoFar = null;
        String filename = "";
        
        for(File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());

            if(lowestSoFar == null){
                lowestSoFar = currentRow;
            } else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
                if(currentTemp < lowestTemp){
                    lowestSoFar = currentRow;
                    filename = f.getName();
                }
            }
        }
        return filename;
    }
    
    public void testFileWithColdestTemperature() {
        System.out.print("Coldest day was in file " + fileWithColdestTemperature() + ", ");
        System.out.println("select this file for more info");
        
        FileResource fr = new FileResource();
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.print("Coldest temperature on that way was ");
        System.out.println(coldest.get("TemperatureF"));
        System.out.println("All the temperatures on the coldest day were:");
        for (CSVRecord record:fr.getCSVParser()) {
            System.out.print(record.get("DateUTC"));
            System.out.print("  ");
            System.out.println(record.get("TemperatureF"));
        }
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestSoFar = null;
        for(CSVRecord currentRow: parser){
            if(!currentRow.get("Humidity").equals("N/A")){
                if(lowestSoFar == null){
                    lowestSoFar = currentRow;
                } else {
                    double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
                    double lowestTemp = Double.parseDouble(lowestSoFar.get("Humidity"));
                    if(currentTemp < lowestTemp){
                        lowestSoFar = currentRow;
                    }
                }
            }
        }
        return lowestSoFar;
    }
    
    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + 
                           " at " + csv.get("DateUTC"));
    }
    
    public CSVRecord lowestHumidityInManyFiles() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestSoFar = null;
        
        for(File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            
            if(lowestSoFar == null){
                lowestSoFar = currentRow;
            } else {
                int currentTemp = Integer.parseInt(currentRow.get("Humidity"));
                int lowestTemp = Integer.parseInt(lowestSoFar.get("Humidity"));
                if(currentTemp < lowestTemp){
                    lowestSoFar = currentRow;
                }
            }
        }
        return lowestSoFar;
    }
    
    public void testlowestHumidityInManyFiles() {
        CSVRecord lowestH = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was: " + lowestH.get("Humidity") +
                            " at " + lowestH.get("DateUTC"));
    }
    

}