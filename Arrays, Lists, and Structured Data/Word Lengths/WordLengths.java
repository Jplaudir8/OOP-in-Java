
/**
 * Write a description of WordLengths here.
 * 
 * @author Joan Perez Lozano
 */

import edu.duke.*;

public class WordLengths {
    
    public void countWordLengths (FileResource resource, int[] counts){
        for(String word: resource.words()) {
            word = word.toLowerCase();
            int wordLength = word.length();
            int characters = 0;
            // Finding out the length of word based on constraints like: "" ,
            for (int i = 0; i < wordLength; i++) {
                if (Character.isLetter(word.charAt(i))) characters += 1;
            }
            
            if (characters <= counts.length & characters != 0) counts[characters-1] ++;

        }
    }
    
    
    
}
