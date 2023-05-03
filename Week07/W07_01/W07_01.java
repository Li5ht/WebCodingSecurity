package W07_01;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;

public class W07_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 try {
	            // RSA key-pair 생성
	            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
	            keyGen.initialize(1024); // 키 길이는 1024비트로 설정
	            KeyPair keyPair = keyGen.generateKeyPair();

	            // 생성된 키 저장
	            ObjectOutputStream publicKeyFile = new ObjectOutputStream(new FileOutputStream("publicKey.ser"));
	            publicKeyFile.writeObject(keyPair.getPublic());
	            publicKeyFile.close();

	            ObjectOutputStream privateKeyFile = new ObjectOutputStream(new FileOutputStream("privateKey.ser"));
	            privateKeyFile.writeObject(keyPair.getPrivate());
	            privateKeyFile.close();

	            System.out.println("RSA key-pair 생성 완료");

	        } catch (NoSuchAlgorithmException | IOException e) {
	            e.printStackTrace();
	        }
		 
		 try {
	            // 공개키 및 개인키 파일에서 읽어오기
	            ObjectInputStream publicKeyFile = new ObjectInputStream(new FileInputStream("publicKey.ser"));
	            PublicKey publicKey = (PublicKey) publicKeyFile.readObject();
	            publicKeyFile.close();

	            ObjectInputStream privateKeyFile = new ObjectInputStream(new FileInputStream("privateKey.ser"));
	            PrivateKey privateKey = (PrivateKey) privateKeyFile.readObject();
	            privateKeyFile.close();

	            // 데이터 암호화
	            String message = "안녕하세요";
	            Cipher cipher = Cipher.getInstance("RSA");
	            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
	            byte[] encryptedMessage = cipher.doFinal(message.getBytes());

	            // 암호문 출력
	            System.out.println("암호문: " + new String(encryptedMessage));

	            // 데이터 복호화
	            cipher.init(Cipher.DECRYPT_MODE, privateKey);
	            byte[] decryptedMessage = cipher.doFinal(encryptedMessage);

	            // 복호화된 평문 출력
	            System.out.println("복호화된 평문: " + new String(decryptedMessage));

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 
		 

	}

}
