
/**
 * Write a description of Part1 here.
 * 
 * @author Joan Perez Lozano 
 */
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while(currIndex != -1){
            int diff = currIndex - startIndex;
            if(diff % 3 == 0){
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }
        return dna.length();
    }
    
    public void testFindStopCodon(){
        String case1 = "ATGXXXYYYZZZTAA"; // Contains Gene at 1st Iteration
        String case2 = "ATGXXXYYZZZTGAXXXXTAA"; // Contains Gene at 2nd Iteration
        String case3 = "ATGXXXYYZZZTGAXXXXTTA"; // Does not contain any gene
        
        findStopCodon(case1, 0, "TAA");
        findStopCodon(case2, 0, "TAA");
        findStopCodon(case3, 0, "TAA");
        
    }
    
    public String findGene(String dna){
        return "";
    }
    
    public void testFindGene(){
    }
    
    public void printAllGenes(String dna){}
}
