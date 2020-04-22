
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author Joan Perez Lozano
 */
import java.util.*;
import edu.duke.*;

public class CharactersInPlay {
    /**
     * These fields or instance variables will serve us to store the names of
     * characters that have been found in "characters" and the number of 
     * ocurrences of them, stored in "characterFreqs".
     */
    private ArrayList<String> characters;
    private ArrayList<Integer> characterFreqs;
    
    /**
     * Initialize instance variables.
     */
    public CharactersInPlay() {
        characters = new ArrayList<String>();
        characterFreqs = new ArrayList<Integer>();
    }
    
    /**
     * Update both instance variables according to the counting of 
     * character names.
     * 
     * @param   person  name of the character.
     */
    public void update(String person) {
        person = person.toLowerCase();
        for(int i = 0; i < characters.size(); i++){
            int index = characters.indexOf(person);
            if (index == -1){
                characters.add(person);
                characterFreqs.add(1);
            } else {
                int freq = characterFreqs.get(index);
                characterFreqs.set(index, freq + 1);
            }
        }
    }
    
    /**
     * Look up for the possible characters names
     */
    public void findAllCharacters() {
        characters.clear();
        characterFreqs.clear();
        FileResource resource = new FileResource();
        
        for(String s: resource.words()) {
            int idx = s.indexOf(".");
            // If there is a period found, Update with the strand of 
            // characters before the period.
            if(idx != -1) {
                update(s.substring(0, idx));
            }  
        }
    }
    
    public void tester() { 
 
    }
    
    public void charactersWithNumParts(int num1, int num2) {
    
    }
    
    
}
