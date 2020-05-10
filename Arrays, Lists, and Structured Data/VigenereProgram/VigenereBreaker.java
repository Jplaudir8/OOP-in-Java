import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder slicedString = new StringBuilder();
        for(int i = whichSlice; i < message.length(); i+=totalSlices) {
            slicedString.append(message.substring(i, i + 1));
        }
        return slicedString.toString();
    }
    
    /**
     *  Find the shift for each index in the key.
     */
    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] keys = new int[klength];
        CaesarCracker ccrack = new CaesarCracker(mostCommon);
        for(int i = 0; i < klength; i++) {
            // Extracts all characters that are in the same key
            String wordKey = sliceString(encrypted, i, klength);
            keys[i] = ccrack.getKey(wordKey);
        }
        return keys;
    }
    
    public void breakVigenere () {
        FileResource encrypted = new FileResource();
        String encryptedStr = encrypted.asString();
        int[] keys = tryKeyLength(encryptedStr, 4, 'e');
        VigenereCipher vc = new VigenereCipher(keys);
        
        String decryptedMsg = vc.decrypt(encryptedStr);
        System.out.println("Array of Keys: ");
        for(int key : keys) System.out.println(key);
        System.out.println("Decrypted Message: \n" + decryptedMsg);
    }
    
    /**
     * Read list of words from a FileResource file.
     * 
     * @param   fr      file that will be read. Should have one words per line.
     * @return          HashSet of words that have been read from the file,
     *                  also making sure that every word is in lowercase.
     */
    public HashSet<String> readDictionary(FileResource fr) {
        HashSet<String> words = new HashSet<String>();
        for(String word : fr.lines()){
            word = word.toLowerCase();
            words.add(word);
        }
        return words;
    }
    
    /**
     * Count how many of these possible words are contained in the dictionary.
     * 
     * @param   message
     */
    public int countWords(String message, HashSet<String> dictionary) {
        int count = 0;
        String[] words = message.split("\\W");

        for(String word : words){
            if(dictionary.contains(word)) {
                count++;
            }
        }
        return count;
    }

    public String breakForLanguage(String encrypted, HashSet<String> dictionary) {
        String decrypted = "";
        int maxOcurrences = 0;
        int legitKeyLength = 0;
        int[] currentKeys = null;
        
        for (int i = 1; i < 100; i++) {
            currentKeys = tryKeyLength(encrypted, i, 'e');
            VigenereCipher vc = new VigenereCipher(currentKeys);
            String message = vc.decrypt(encrypted);
            int currentWordCount = countWords(message, dictionary);
            
            if (currentWordCount > maxOcurrences) {
                maxOcurrences = currentWordCount;
                legitKeyLength = i;
                decrypted = message;
            }
        }
        
        System.out.println("Key Length: " + currentKeys.length);
        System.out.println("Keys Used to decrypt message: \n");
        
        // Printing Keys Found
        for(int key : currentKeys) System.out.println(key);
        
        return decrypted;
    }
    
    











}
