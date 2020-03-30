
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
    
    public void totalBirths(FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int boyNames = 0;
        int girlNames = 0;
        int totalNames = 0;
        
        for(CSVRecord rec: fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if(rec.get(1).equals("M")) {
                totalBoys += numBorn;
                boyNames++;
            } else {
                totalGirls += numBorn;
                girlNames++;
            }
        }
        
        totalNames = boyNames + girlNames;
        
        System.out.println("total births = " + totalBirths);
        System.out.println("total girls = " + totalGirls);
        System.out.println("total boys = " + totalBoys);
        System.out.println("There are " + totalNames + " different names in total.");
        System.out.println("There are " + girlNames + " different girl names in total.");
        System.out.println("There are " + boyNames + " different boy names in total.");
    }
    
    public void testTotalBirths() {
        FileResource fr = new FileResource("data/us_babynames_test/yob2012short.csv");
        totalBirths(fr);
    }
    
    public int getRank(int year, String name, String gender) {
        int rank = 0;
        
        FileResource fr = new FileResource("data/us_babynames_by_year/yob"+year+".csv");
        CSVParser parser = fr.getCSVParser(false);
        
        for(CSVRecord r: parser) {
            if(r.get(1).equals(gender)) {
                rank++;
                if(r.get(0).equals(name)){
                    return rank;
                } 
            }
        }
        return -1;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
