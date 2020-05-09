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
        // Here we are just testing a range from 1 to 100 as possible values
        // for the keyLength. There is nothing special about 100, we could
        // also iterate until encrypted.length()
        HashMap<int[], Integer> mapKeysOcurrences = new HashMap<int[], Integer>();
        
        for(int i = 1; i <= 100; i++) {
            int[] keys = tryKeyLength(encrypted, i, 'e');
            VigenereCipher vc = new VigenereCipher(keys);
            String decrypted = vc.decrypt(encrypted);
            FileResource dictionaryFile = new FileResource("dictionaries/english");
            HashSet<String> dictionarySet = readDictionary(dictionaryFile);
            int ocurrencesKey = countWords(decrypted, dictionarySet);
            mapKeysOcurrences.put(keys, ocurrencesKey);
        }
        
        int maxOcurrences = 0;
        int[] decisiveKeys = null;
        
        for(int[] keys : mapKeysOcurrences.keySet()) {
            if(mapKeysOcurrences.get(keys) > maxOcurrences) {
                maxOcurrences = mapKeysOcurrences.get(keys);
                decisiveKeys = keys;
            }
        }
        
        VigenereCipher vc = new VigenereCipher(decisiveKeys);
        String decrypted = vc.decrypt(encrypted);
        
        return decrypted;
    }    
    












}
