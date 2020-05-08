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
        int[] keys = tryKeyLength(encryptedStr, 5, 'e');
        VigenereCipher vc = new VigenereCipher(keys);
        String decryptedMsg = vc.decrypt(encryptedStr);
        System.out.println(decryptedMsg);
    }
}
