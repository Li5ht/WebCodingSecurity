package W06_02;

import java.io.*;
import java.nio.file.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class W06_02 {
	//암호화
	public static void main(String[] args) throws Exception {
        // 비밀키 파일에서 읽어오기
        SecretKeySpec keySpec = readKeyFromFile("skey.bin");

        // 입력 파일, 출력 파일, 버퍼 크기 설정
        Path inputPath = Paths.get("data.txt");
        Path outputPath = Paths.get("data.enc");
        int bufferSize = 16; // AES 블록 크기

        // 암호화 처리
        encryptFile(keySpec, inputPath, outputPath, bufferSize);

        System.out.println("암호화 완료");
    }

    private static SecretKeySpec readKeyFromFile(String filename) throws Exception {
        // 파일에서 비밀키 객체 읽어오기
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (SecretKeySpec)in.readObject();
        }
    }

    private static void encryptFile(SecretKeySpec keySpec, Path inputPath, Path outputPath, int bufferSize) throws Exception {
        // 암호화 알고리즘 생성 및 초기화
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);

        // 입력 파일, 출력 파일, 버퍼 생성
        byte[] input = Files.readAllBytes(inputPath);
        byte[] output = new byte[cipher.getOutputSize(input.length)];
        byte[] buffer = new byte[bufferSize];

        // 암호화
        int outputPos = 0;
        for (int inputPos = 0; inputPos < input.length; inputPos += bufferSize) {
            int length = Math.min(bufferSize, input.length - inputPos);
            System.arraycopy(input, inputPos, buffer, 0, length);
            int nBytes = cipher.update(buffer, 0, length, output, outputPos);
            outputPos += nBytes;
        }
        outputPos += cipher.doFinal(output, outputPos);

        // 출력 파일에 저장
        try (OutputStream out = new FileOutputStream(outputPath.toFile())) {
            out.write(output, 0, outputPos);
        }
        
     /*// 비밀키 파일에서 읽어오기
        SecretKeySpec keySpec = readKeyFromFile("skey.bin");

        // 입력 파일, 출력 파일, 버퍼 크기 설정
        Path inputPath = Paths.get("data.enc");
        int bufferSize = 16; // AES 블록 크기

        // 복호화 처리
        byte[] decrypted = decryptFile(keySpec, inputPath, bufferSize);

        // 복호화된 데이터 출력
        System.out.println(new String(decrypted));

        // 암호화 전의 데이터 파일과 내용이 같은지 확인
        byte[] original = Files.readAllBytes(Paths.get("data.txt"));
        if (MessageDigest.isEqual(original, decrypted)) {
            System.out.println("복호화된 내용과 원본 내용이 일치합니다.");
        } else {
            System.out.println("복호화된 내용과 원본 내용이 일치하지 않습니다.");
        }*/
    }

}
