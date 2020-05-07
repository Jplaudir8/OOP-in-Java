
/**
 * Write a description of Tester here.
 * 
 * @author Joan Perez Lozano
 */
import edu.duke.*;

public class Tester {
    
    public void caesarCipherTester() {
        FileResource message = new FileResource("data/titus-small.txt");
        String messageStr = message.asString();
        CaesarCipher cc = new CaesarCipher(6);
        String encrypted = cc.encrypt(messageStr);
        String decrypted = cc.decrypt(encrypted);
        System.out.println("Message encrypted: \n" + encrypted);
        System.out.println("Message decrypted: \n" + decrypted);
    }
}
