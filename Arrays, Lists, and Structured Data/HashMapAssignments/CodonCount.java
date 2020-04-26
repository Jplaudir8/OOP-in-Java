
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
        int codons = (dna.length()-start)/3;
        String currentCodon;
        for (int i = 0; i <= codons-1; i++) {
            currentCodon = dna.substring((i*3) + start, (i*3)+start+3);
            if(!map.containsKey(currentCodon)) {
                map.put(currentCodon, 1);
            } else {
                map.put(currentCodon, map.get(currentCodon) + 1);
            }
        }
        
        System.out.println("Codons in list");
        for(String s : map.keySet()){
            System.out.println(s + " " + map.get(s));
        }
        System.out.println(map.size());
    }
    
    
    
    
    
    
    
}
