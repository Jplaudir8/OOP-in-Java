
/**
 * This class has the same functionality as the "CaesarCipher" class, 
 * but it takes a different approach by making use of encapsuation,
 * giving a better implementation design.
 * 
 * @author Joan Perez Lozano
 */
public class CaesarCipherEncapsulated {
    /**
    * These fields or instance variables will serve us to store the 
    * alphabet and a shifted alphabet based upon the creation of the 
    * encryption key.
    */
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    /**
     * Initialize the alphabet and
     * shiftedAlphabet variables.
     * 
     * @param key   the encryption key
     */
    public CaesarCipherEncapsulated(int key) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // Computing the shifted alphabet
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        mainKey = key;
    }
    
    /**
     * Encrypt the message using the initialized key. 
     * 
     * @param input   message to be encrypted
     * @return        the encrypted message
     */
    public String encrypt(String input) {
        // Using the upper case version of the input to make the comparison of indexes.
        String upperInput = input.toUpperCase();
        StringBuilder encrypted = new StringBuilder(upperInput);

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
    
    /**
     * Test driver for encrypt method.
     */
    public void testEncrypt() {
        // int key = 17;
        // FileResource fr = new FileResource();
        // String message = fr.asString();
        int key = 15;
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        System.out.println("Message: " + message);
        System.out.println("key is " + key);

        String encrypted = encrypt(message);
        System.out.println("Encrypted: \n" + encrypted);

        // System.out.println("Decrypted:");
        // String decrypted = encrypt(encrypted, 26 - key);
        // System.out.println(decrypted);
    }
    
    /**
     * Encrypt message using two keys, the first key used for every other
     * character of the input starting from index 0, the second key for
     * every other character of the input starting from index 1.
     * 
     * @param  input    message to be encrypted.
     * @param  key1     encryption key.
     * @param  key2     encryption key.
     * @return          the encrypted message
     */
    public String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0; i < input.length(); i++) {
            String ch = encrypted.charAt(i)+"";
            if(i % 2 == 0) {
                encrypted.setCharAt(i, encrypt(ch).charAt(0));
            } else {
                encrypted.setCharAt(i, encrypt(ch).charAt(0));
            }
        }

        return encrypted.toString();
    }
    
    /**
     * Test driver for encryptTwoKeys method.
     */
    public void testEncryptTwoKeys() {
        int key1 = 21;
        int key2 = 8;
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        System.out.println("Message: " + message);
        System.out.println("key1: " + key1 + "\nKey2: " + key2);

        String encrypted = encryptTwoKeys(message, key1, key2);
        System.out.println("Encrypted: \n" + encrypted);
    }
    
    /**
     * Decrypt message by using mainKey.
     * 
     * @param input     Message to be decrypted.
     */
    public String decrypt(String input) {
        CaesarCipherEncapsulated cc = new CaesarCipherEncapsulated(26 - mainKey);
        return cc.encrypt(input);
    }
    
}