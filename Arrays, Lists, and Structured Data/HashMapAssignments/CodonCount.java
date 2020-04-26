
/**
 * Write a description of CodonCount here.
 * 
 * @author Joan Perez Lozano
 */
import edu.duke.*;
import java.util.*;

public class CodonCount {
    /**
     * These field or instance variable is a HashMap that will 
     * store all codons and their ocurrences found in a strand of DNA.
     */
    private HashMap<String, Integer> codonMap;
    
    /**
     * Initialize codonMap
     */
    public CodonCount() {
        codonMap = new HashMap<String, Integer>();
    }
    
    /**
     * Register all codons found and their ocurrences in the HashMap.
     * 
     * @param  start    the index at which the function starts reading
     *                  for the codons.
     * @param  dna      the strand of DNA that will be read.
     */
    public void buildCodonMap(int start, String dna){
        codonMap.clear();
        dna = dna.toUpperCase();
        int codons = (dna.length()-start)/3;
        String currentCodon;
        for (int i = 0; i <= codons-1; i++) {
            currentCodon = dna.substring((i*3)+start, (i*3)+start + 3);
            if(!codonMap.containsKey(currentCodon)) {
                codonMap.put(currentCodon, 1);
            } else {
                codonMap.put(currentCodon, codonMap.get(currentCodon) + 1);
            }
        }
    }
    
    /**
     * Compute the codon that has the most ocurrences and return it. 
     * If more than one has the same ocurrences, return any.
     * 
     * @return  the codon found.
     */
    public String getMostCommonCodon() {
        String mostCodon = "";
        int mostOcurrence = 0; // Most occurrence of variable 'mostCodon'
        for(String s : codonMap.keySet()) {
            
            if(mostCodon.length() == 0){
                mostCodon = s;
            }
            
            if(codonMap.get(mostCodon) < codonMap.get(s)){
                mostOcurrence = codonMap.get(s);
                mostCodon = s;
            }
        }
        return mostCodon;
    }
    
    public void printCodonCounts(int start, int end) {
        System.out.println("Codons which ocurrences are between " + start + " and " + end + " inclusive:");
        for(String s : codonMap.keySet()){
            if(codonMap.get(s) >= start && codonMap.get(s) <= end) {
                System.out.println(s + " " + codonMap.get(s));
            }
        }
        System.out.println(codonMap.size());
    }
    
    
    
    
    
    
    
    
}
