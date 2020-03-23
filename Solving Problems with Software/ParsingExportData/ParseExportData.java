
/**
 * Write a description of ParseExportData here.
 * 
 * @author Joan Perez Lozano
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class ParseExportData {
    
    public String countryInfo(CSVParser parser, String country){
        for(CSVRecord r: parser){
            if(r.get("Country").contains(country)){
                return r.get("Country") + ": " + r.get("Exports") + ": " +r.get("Value (dollars)");
            } 
        }
        return "NOT FOUND";
    }
    
    public void listExportersTwoProducts(CSVParser parser, 
                                         String exportItem1, 
                                         String exportItem2){
        for(CSVRecord r: parser){
            if(r.get("Exports").contains(exportItem1) && r.get("Exports").contains(exportItem2)){
                System.out.println(r.get("Country"));
            }
        }
    }
    
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //System.out.println(countryInfo(parser, "Germany"));
        listExportersTwoProducts(parser, "gold", "diamonds");
    }
}
