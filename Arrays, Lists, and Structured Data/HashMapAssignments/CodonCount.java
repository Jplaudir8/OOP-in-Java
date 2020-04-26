
/**
 * Write a description of CodonCount here.
 * 
 * @author Joan Perez Lozano
 */
import edu.duke.*;
import java.util.*;

public class CodonCount {
    private HashMap<String, Integer> map;
    
    public CodonCount() {
        map = new HashMap<String, Integer>();
    }
    
    public void buildCodonMap(int start, String dna){
        map.clear();
        int iterations = (dna.length() - start)/3;
        //System.out.println("Number of iterations: " + iterations);
        for(int i = 0; i <= iterations*3-3; i += 3) {
            String currentCodon = dna.substring(i, i + 3);
            // System.out.println("Codon found: "+ i +" "+ currentCodon);
            if(!map.containsKey(currentCodon)) {
                map.put(currentCodon, 1);
            } else {
                map.put(currentCodon, map.get(currentCodon) + 1);
            }
        }
        // System.out.println("Codons in list");
        // for(String s : map.keySet()){
            // System.out.println(s + " " + map.get(s));
        // }
        // System.out.println(map.size());
    }
    
    
    
    
    
    
    
}
