
/**
 * Write a description of Part1 here.
 * 
 * @author Joan Perez Lozano
 */
public class Part1 {
    public String findSimpleGene(String dna) {
        int startCodon = dna.indexOf("ATG");
        if(startCodon == -1)return "";
        
        int stopCodon = dna.indexOf("TAA", startCodon + 3);
        if(stopCodon == -1) return "";
        
        int strandLength = stopCodon - startCodon;
        
        if(strandLength % 3 == 0) return dna.substring(startCodon, stopCodon + 3);
        return "";
    }
    
    public void testSimpleGene() {
        
        // DNA with no ATG
        // DNA with no TAA
        // DNA with no ATG or TAA
        // DNA with ATG, TAA and the substring between them multiple of 3
        // DNA with ATG, TAA and the substring between them not multiple of 3
        
        String dna = "ATTGAAGGGTAGTAACGTAA";
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is: " + gene);

        dna = "ATGGACCGGTAGTCACGTAG";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is: " + gene);
        
        dna = "ATCGACCGGTAGTCACGTAC";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is: " + gene);
        
        dna = "CGTGAAATGCGTASTGTTAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is: " + gene);
        
        dna = "CGTGAATGCCGTGASTGTAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is: " + gene);
        
        System.out.println("------------------");
    }
}
