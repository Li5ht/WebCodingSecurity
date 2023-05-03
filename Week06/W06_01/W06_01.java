package W06_01;

import java.io.*;
import java.security.*;
import javax.crypto.*;
import java.util.*;

public class W06_01 {
	// 비밀키를 생성하고 파일에 저장하는 메소드
    public static void saveSecretKey(String fileName) throws NoSuchAlgorithmException, IOException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(secretKey);
        out.close();
        System.out.println("Generated secret key and saved to file: " + fileName);
    }

    // 파일에서 비밀키를 읽어서 SecretKey 객체를 반환하는 메소드
    public static SecretKey loadSecretKey(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        SecretKey secretKey = (SecretKey) in.readObject();
        in.close();
        return secretKey;
    }

    public static void main(String[] args) {
    	
    	String ALGORITHM = "AES";
        int KEY_SIZE = 128;
        
    	Scanner sc = new Scanner(System.in);
         
        try {
            // 키를 저장하는 모드
            
            System.out.println("암호화  알고리즘: " + ALGORITHM);
            System.out.println("키의 길이 (bytes): " + KEY_SIZE);
            System.out.print("비밀키를 저장할 파일 이름: " );
            String file = sc.next();
            saveSecretKey(file);
            
            //키를 읽어오는 모드
            FileInputStream fis = new FileInputStream(file);
            
            System.out.print("비밀키를 저장할 파일 이름: " + file );
            System.out.println("암호화  알고리즘: " + ALGORITHM);
            System.out.println("키의 길이 (bytes): " + KEY_SIZE);
      
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
