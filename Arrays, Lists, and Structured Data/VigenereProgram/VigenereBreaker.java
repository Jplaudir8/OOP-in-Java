import java.util.*;
import edu.duke.*;
import java.io.*;

public class VigenereBreaker {
    
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder slicedString = new StringBuilder();
        for(int i = whichSlice; i < message.length(); i+=totalSlices) {
            slicedString.append(message.charAt(i));
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
        // FileResource encrypted = new FileResource();
        // String encryptedStr = encrypted.asString();
        // int[] keys = tryKeyLength(encryptedStr, 4, 'e');
        // VigenereCipher vc = new VigenereCipher(keys);
        
        // String decryptedMsg = vc.decrypt(encryptedStr);
        // System.out.println("Array of Keys: ");
        // for(int key : keys) System.out.println(key);
        // System.out.println("Decrypted Message: \n" + decryptedMsg);
        
       HashMap<String, HashSet<String>> dictionaries = new HashMap<String, HashSet<String>>();
       File folder = new File("dictionaries/");
       File[] fileList = folder.listFiles();
       for (int i = 0; i < fileList.length; i++) {
           if (fileList[i].isFile()) {
               FileResource dictionaryFile = new FileResource(fileList[i]);
               HashSet<String> dictionary = readDictionary(dictionaryFile);
               dictionaries.put(fileList[i].getName(), dictionary);
               System.out.println("Reading in " + fileList[i] + " dictionary...");
           }
       }
       FileResource encryptedFile = new FileResource();
       breakForAllLangs(encryptedFile.asString(),dictionaries);
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
            if(dictionary.contains(word.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    public String breakForLanguage(String encrypted, HashSet<String> dictionary) {
        String decrypted = "";
        int maxOcurrences = 0;
        int legitKeyLength = 0;
        
        for (int i = 1; i < 100; i++) {
            char commonChar = mostCommonCharIn(dictionary);
            int[] currentKeys = tryKeyLength(encrypted, i, commonChar);
            VigenereCipher vc = new VigenereCipher(currentKeys);
            String message = vc.decrypt(encrypted);
            int currentWordCount = countWords(message, dictionary);
            
            if (currentWordCount > maxOcurrences) {
                maxOcurrences = currentWordCount;
                legitKeyLength = i;
                decrypted = message;
            }
        }
        
        System.out.println("Key Length: " + legitKeyLength);
        System.out.println("Number of valid words: "+ maxOcurrences);

        return decrypted;
    }
    
    public char mostCommonCharIn(HashSet<String> dictionary) {
        HashMap<Character,Integer> characterCounter = new HashMap<Character,Integer>();
        for (String word : dictionary) {
            char[] letters = word.toCharArray();
            for (int i = 0 ; i < letters.length; i++) {
                if (!characterCounter.containsKey(letters[i])) {
                    characterCounter.put(letters[i],1);
                } else {
                    characterCounter.replace(letters[i], characterCounter.get(letters[i]) + 1);
                }
            }
        }
        int highestCount = 0;
        char mostUsedChar = ' ';
        for (Character character : characterCounter.keySet()) {
            if (characterCounter.get(character) > highestCount) {
                highestCount = characterCounter.get(character);
                mostUsedChar = character;
            }
        }
        return mostUsedChar;
    }
    
    public void breakForAllLangs(String encrypted, HashMap<String, HashSet<String>> languages) {
        int currentHigh = 0;
        String decryptedMessage = "";
        String usedLanguage = "";
        for (String language : languages.keySet()) {
            String message = breakForLanguage(encrypted, languages.get(language));
            int currentWordCount = countWords(message, languages.get(language));
            if (currentWordCount > currentHigh) {
                currentHigh = currentWordCount;
                decryptedMessage = message;
                usedLanguage = language;
            }
        }
        System.out.println(decryptedMessage);
        System.out.println("Language Used: " + usedLanguage);
    }











}
