
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
    
    /**
     * Print codons according to the range or limits provided.
     * 
     * @param  start    lowest limit of ocurrences.
     * @param  end      highest limit of ocurrences.
     */
    public void printCodonCounts(int start, int end) {
        //System.out.println("Codons which ocurrences are between " + start + " and " + end + " inclusive:");
        for(String s : codonMap.keySet()){
            if(codonMap.get(s) >= start && codonMap.get(s) <= end) {
                System.out.println(s + " " + codonMap.get(s));
            }
        }
    }
    
    public void tester() {
        FileResource dna = new FileResource("dnaMystery2.txt");
        // We trimmed dna.asString as the convention for text files is
        // to end with a line break, hence our computation may interpret
        // our string variable with an extra space.
        String dnaString = dna.asString().trim();
        // Codon limits for printing out
        int start = 1;
        int end = 8;
        for(int i = 0; i <= 2; i++) {
            buildCodonMap(i, dnaString);
            System.out.println("Reading frame starting with " +i+" results in " + codonMap.size() +" unique codons");
            System.out.println("and most common codon is " + getMostCommonCodon() + " with count " + codonMap.get(getMostCommonCodon()));
            System.out.println("Counts of codons between " + start +" and " + end + " are: ");
            printCodonCounts(start, end);
        }
    }

}
