import edu.duke.*;

/**
 * Write a description of CaesarCipher here.
 * 
 * @author Joan Perez Lozano
 */

public class CaesarCipher {
    
    public String encrypt(String input, int key) {
        // Using the upper case version of the input to make the comparison of indexes.
        String upperInput = input.toUpperCase();
        StringBuilder encrypted = new StringBuilder(upperInput);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // Computing the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        
        // System.out.println(alphabet);
        // System.out.println(shiftedAlphabet);
        
        for (int i = 0; i < encrypted.length(); i++) {
            // Look at the ith character of encrypted
            char currChar = encrypted.charAt(i);
            // Find the index of currcChar in the alphabet
            int idx = alphabet.indexOf(currChar);
            // If currChar is in the alphabet
            if(idx != -1) {
                char newChar = shiftedAlphabet.charAt(idx);
                
                // If the character of input is in upper case, we directly replace with an upper case character
                // Otherwise, it should be an upper case version.
                if(Character.isUpperCase(input.charAt(i))) {
                    encrypted.setCharAt(i, newChar);
                } else {
                    newChar = Character.toLowerCase(newChar);
                    encrypted.setCharAt(i, newChar);
                }
                
            }
        }
        
        return encrypted.toString();
    }
    
    public void testEncrypt() {
        // int key = 17;
        // FileResource fr = new FileResource();
        // String message = fr.asString();
        int key = 15;
        String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        System.out.println("Message: " + message);
        System.out.println("key is " + key);
        
        String encrypted = encrypt(message, key);
        System.out.println("Encrypted: \n" + encrypted);
        
        // System.out.println("Decrypted:");
        // String decrypted = encrypt(encrypted, 26 - key);
        // System.out.println(decrypted);
    }
        
    public String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0; i < input.length(); i++) {
            String ch = encrypted.charAt(i)+"";
            if(i % 2 == 0) {
                encrypted.setCharAt(i, encrypt(ch, key1).charAt(0));
            } else {
                encrypted.setCharAt(i, encrypt(ch, key2).charAt(0));
            }
        }
        
        return encrypted.toString();
    }
    
    public void testEncryptTwoKeys() {
        int key1 = 8;
        int key2 = 21;
        String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        System.out.println("Message: " + message);
        System.out.println("key1: " + key1 + "\nKey2: " + key2);
        
        String encrypted = encryptTwoKeys(message, key1, key2);
        System.out.println("Encrypted: \n" + encrypted);
    }

}
