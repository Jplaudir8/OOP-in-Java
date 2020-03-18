
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
        
        int result1 = findStopCodon(case1, 0, "TAA");
        int result2 = findStopCodon(case2, 0, "TAA");
        int result3 = findStopCodon(case3, 0, "TAA");
        
        System.out.println("Strand: " + case1);
        System.out.println(result1);
        System.out.println("Strand: " + case2);
        System.out.println(result2);
        System.out.println("Strand: " + case3);
        System.out.println(result3); 
    }
    
    public String findGene(String dna){
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) return ""; // 1st occurence of ATG, if not then return ""
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int temp = Math.min(taaIndex, tagIndex);
        int minIndex = Math.min(temp, tgaIndex);
        
        if(taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
            minIndex = tgaIndex;
        } else {
            minIndex = taaIndex;
        }
        
        if(minIndex == -1 || (tgaIndex != -1 && tagIndex < minIndex)) minIndex = tagIndex;
        
        if(minIndex == -1) return ""; // If there is no stopCodon return ""
        
        return dna.substring(startIndex, minIndex + 3); // Returning the gene formed
    }
    
    public void testFindGene(){
    }
    
    public void printAllGenes(String dna){}
}
