
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
    
    public String findGene(String dna, int where){
        int startIndex = dna.indexOf("ATG", where);
        
        // 1st occurence of ATG, if not found then return ""
        if (startIndex == -1) return ""; 
        
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
        
        // If there is no stopCodon return ""
        if(minIndex == -1 || minIndex == dna.length()) return ""; 
        
        return dna.substring(startIndex, minIndex + 3); // Returning the gene formed
    }
    
    public void testFindGene(){
        String case1 = "XXXYYYZZZTAA";
        String result1 = findGene(case1, 0);
        System.out.println("DNA Strand 1: " + case1);
        System.out.println("Result: " + result1);
        
        case1 = "ATGXXXYYYZZZTAA";
        result1 = findGene(case1, 0);
        System.out.println("DNA Strand 2: " + case1);
        System.out.println("Result: " + result1);
        
        case1 = "ATGXXXYYYZZZTGAXXXTAAYYYTAG";
        result1 = findGene(case1, 0);
        System.out.println("DNA Strand 3: " + case1);
        System.out.println("Result: " + result1);
        
        case1 = "ATGXXXYYYZZZTAG";
        result1 = findGene(case1, 0);
        System.out.println("DNA Strand 4: " + case1);
        System.out.println("Result: " + result1);
        
        case1 = "ATGXXXYYYZZZ";
        result1 = findGene(case1, 0);
        System.out.println("DNA Strand 5: " + case1);
        System.out.println("Result: " + result1);
    }
    
    public void printAllGenes(String dna){
        int startIndex = 0;
        while(true){
            String currentGene = findGene(dna, startIndex);
            if(currentGene.isEmpty()) break;
            
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
    }
}
