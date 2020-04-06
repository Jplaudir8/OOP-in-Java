import edu.duke.*;

/**
 * Write a description of CaesarCipher here.
 * 
 * @author Joan Perez Lozano
 */

public class CaesarCipher {
    
    public String encrypt(String input, int key) {
        input = input.toUpperCase();
        StringBuilder encrypted = new StringBuilder(input);
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
                encrypted.setCharAt(i, newChar);
            }
        }
        
        return encrypted.toString();
    }
    
    public void testCaesar() {
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        
        String encrypted = encrypt(message, key);
        System.out.print(encrypted);
        
        String decrypted = encrypt(encrypted, 26 - key);
        System.out.print(decrypted);
    }
}
