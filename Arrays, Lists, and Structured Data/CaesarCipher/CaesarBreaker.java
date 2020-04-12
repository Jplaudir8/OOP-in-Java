
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author Joan Perez Lozano
 */

import edu.duke.*;

public class CaesarBreaker {
    public int[] countLetters(String message) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] counts = new int[26];
        for(int i = 0; i < message.length(); i++){
            char ch = Character.toUpperCase(message.charAt(i));
            int idx = alphabet.indexOf(ch);
            if (idx != -1) {
                counts[idx]++;
            }
        }
        return counts;
    }
    
    public int maxIndex(int[] values){
        int maxIdx = 0;
        for(int i = 0; i < values.length; i++){
            if(values[i] > values[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    
    public String decrypt(String encrypted) {
        
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted); 
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        
        if(maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        
        String message = cc.encrypt(encrypted, 26 - dkey); 
        return message;
    }
    
    public void testDecrypt() {
        String message = "Hello my";
        CaesarCipher cc = new CaesarCipher();
        
        String encrypted = cc.encrypt(message, 4);
        System.out.println("The encrypted message is: " + encrypted);
        
        String decrypted = decrypt(encrypted);
        System.out.println("The decryped message is: " + decrypted);
    }
    
    public String halfOfString(String message, int start) {
        StringBuilder sb = new StringBuilder();
        for(int i = start; i < message.length(); i+=2) {
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }
    
    public int getKey(String s) {
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        return 26 - dkey;
    }
    
    public String decryptTwoKeys(String encrypted) {
        String firstHalf = halfOfString(encrypted, 0);
        String secondHalf = halfOfString(encrypted, 1);
        int key1 = getKey(firstHalf);
        System.out.println("Keys used to encrypt the message");
        System.out.println("key 1: " + (26 - key1));
        int key2 = getKey(secondHalf);
        System.out.println("key 2: " + (26 - key2));
        CaesarCipher cc = new CaesarCipher();
        
        return cc.encryptTwoKeys(encrypted, key1, key2);
    } 
    
    public void testDecryptTwoKeys() {
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        System.out.println("Encrypted message: " + encrypted);
        System.out.println("Decrypted message:" + decryptTwoKeys(encrypted));
    
        // String encrypted = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
        // System.out.println("Encrypted message: " + encrypted);
        // System.out.println("Decrypted message:" + decryptTwoKeys(encrypted));
    }
    
}
