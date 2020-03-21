
/**
 * Write a description of Part2 here.
 * 
 * @author Joan Perez Lozano
 */
public class Part2 {
    public double cgRatio(String dna){
        float cgCount = 0;
        int index = 0;
        int startIndex = 0;
        
        dna = dna.toLowerCase();
        
        while(true) {
            int pos = dna.indexOf("c", startIndex);
            if (pos == -1) {
                startIndex = 0;
                break;
            }
            cgCount++;
            startIndex = pos + 1;
        }
        
        while(true) {
            int pos = dna.indexOf("g", startIndex);
            if (pos == -1) {
                startIndex = 0;
                break;
            }
            cgCount++;
            startIndex = pos + 1;
        }
        
        return (double) cgCount/dna.length();
    }
    
    // public void testCgRatio(){
        
        // String case1 = "ATGCCATAG";
        // System.out.println("The Ratio is: " + cgRatio(case1));
    // }
    
    public int countCTG(String dna) {
        dna = dna.toLowerCase();
        int startIndex = 0;
        int countCTG = 0;
        
        while(true) {
            int pos = dna.indexOf("ctg", startIndex);
            if(pos == -1) break;
            countCTG++;
            startIndex = pos + 1;
        }
        
        return countCTG;
    }
}
