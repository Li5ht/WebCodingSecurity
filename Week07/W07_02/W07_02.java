package W07_02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import javax.crypto.Cipher;


public class W07_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String originalFilePath = "original.txt";
        String encryptedFilePath = "encrypted.txt";
        String publicKeyFilePath = "publicKey.txt";

        // Generate key pair
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(1024);
        KeyPair keyPair = kpg.generateKeyPair();
        Key publicKey = keyPair.getPublic();
        Key privateKey = keyPair.getPrivate();

        // Save public key to file
        FileOutputStream fos = new FileOutputStream(publicKeyFilePath);
        fos.write(publicKey.getEncoded());
        fos.close();

        // Encrypt file using public key
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        FileInputStream fis = new FileInputStream(originalFilePath);
        FileOutputStream fos2 = new FileOutputStream(encryptedFilePath);
        byte[] buffer = new byte[117];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            byte[] output = cipher.update(buffer, 0, bytesRead);
            if (output != null) {
                fos2.write(output);
            }
        }
        byte[] output = cipher.doFinal();
        if (output != null) {
            fos2.write(output);
        }
        fis.close();
        fos2.flush();
        fos2.close();

        System.out.println("File encrypted successfully.");
        
        String decryptedFilePath = "decrypted.txt";
        String privateKeyFilePath = "privateKey.txt";
        /*
     // Load private key from file
        File privateKeyFile = new File(privateKeyFilePath);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(privateKeyFile));
        byte[] privateKeyBytes = new byte[(int) privateKeyFile.length()];
        ois.readFully(privateKeyBytes);
        ois.close();
        Key privateKey = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));

        // Decrypt file using private key
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        FileInputStream fis = new FileInputStream(encryptedFilePath);
        FileOutputStream fos = new FileOutputStream(decryptedFilePath);
        byte[] buffer = new byte[128];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            byte[] output = cipher.update(buffer, 0, bytesRead);
            if (output != null) {
                fos.write(output);
            }
        }
        byte[] output = cipher.doFinal();
        if (output != null) {
            fos.write(output);
        }
        fis.close();
        fos.flush();
        fos.close();

        System.out.println("File decrypted successfully.");*/
	
	

	}

}
