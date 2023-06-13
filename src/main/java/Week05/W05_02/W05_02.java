package Week05.W05_02;

import java.io.*;
import java.security.*;

public class W05_02 {

	private static final String HASH_FILE_EXTENSION = ".bin";

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        if (args.length < 1) {
            System.out.println("사용법: java FileHashManager <filename>");
            System.exit(1);
        }

        String fileName = args[0];
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("입력 파일이 존재하지 않습니다.");
            System.exit(1);
        }

        String hashFileName = fileName + HASH_FILE_EXTENSION;

        byte[] hashValue = calculateHash(fileName);
        System.out.println("계산된 해시값: " + bytesToHex(hashValue));

        saveHashToFile(hashFileName, hashValue);

        byte[] savedHashValue = loadHashFromFile(hashFileName);

        System.out.println("저장된 해시값: " + bytesToHex(savedHashValue));

        System.out.println("두 해시값 비교 결과: " + MessageDigest.isEqual(hashValue, savedHashValue));
    }

    public static byte[] calculateHash(String fileName) throws NoSuchAlgorithmException, IOException {
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        FileInputStream fis = new FileInputStream(fileName);
        byte[] buffer = new byte[1024];
        int nread = 0;
        while ((nread = fis.read(buffer)) != -1) {
            sha1.update(buffer, 0, nread);
        }
        fis.close();
        return sha1.digest();
    }

    public static void saveHashToFile(String fileName, byte[] hashValue) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(hashValue);
        fos.close();
    }

    public static byte[] loadHashFromFile(String fileName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        byte[] buffer = new byte[20];
        fis.read(buffer);
        fis.close();
        return buffer;
    }

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            hexChars[i * 2] = HEX_ARRAY[v >>> 4];
            hexChars[i * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }


}
