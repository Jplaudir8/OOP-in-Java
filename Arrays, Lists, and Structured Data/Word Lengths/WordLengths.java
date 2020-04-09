
/**
 * Write a description of WordLengths here.
 * 
 * @author Joan Perez Lozano
 */

import edu.duke.*;

public class WordLengths {
    
    public void countWordLengths (FileResource resource, int[] counts){
            
        for(String word : resource.words()){
            word = word.toLowerCase();			
            int wordlength = word.length();
            
            if (!Character.isLetter(word.charAt(word.length()-1))){
		wordlength --;
            }
            
            // if wordlength is greater than or equal to the length of
            // the array, just add 1 to the highest length in the array
            if (wordlength >= counts.length) {  	    	   
          	wordlength = counts.length - 1;  	  	
            } 
            
	    if (wordlength > 0 ) {  	   	   
		counts[wordlength] ++;  	  	
     	    }
     	    
	}

    }
    
    public int indexOfMax(int[] values) {
        
        int maxValue = 0;
        
        for(int i = 0; i < values.length; i++){
            if(values[i] > maxValue) {
                maxValue = values[i];
            }
        }
        
        return maxValue;
    }
    
    public void testCountWordLengths() {
        FileResource fr = new FileResource();
        int[] counts = new int[31];
        
        countWordLengths(fr, counts);
        int mostFrequent = indexOfMax(counts);
        
        for(int i = 0; i < counts.length; i++) {
            System.out.println(counts[i] + " words of length " + i);
        }
        System.out.println("The greatest frequency is : " + mostFrequent);
    }
    

    
    
    
    
    
    
    
    
    
    
    
}
