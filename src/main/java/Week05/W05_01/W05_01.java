package Week05.W05_01;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class W05_01 {
	public static void main(String[] args) throws NoSuchAlgorithmException{
		String plainText = "The Road Not Taken by Robert Frost";
        byte[] plainTextBytes = plainText.getBytes(StandardCharsets.UTF_8);

        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        byte[] hash = sha1.digest(plainTextBytes);

        System.out.println("SHA-1 Hash Value: " + Arrays.toString(hash));
        System.out.println("Hash Value Length: " + hash.length);

        // 같은 입력 값에 대해서는 항상 같은 값이 출력되는가?
        byte[] hash2 = sha1.digest(plainTextBytes);
        System.out.println("SHA-1 Hash Value (Same Input): " + Arrays.toString(hash2));
        System.out.println("Hash Value Length (Same Input): " + hash2.length);

        // 데이터에서 1글자 혹은 1단어가 달라지는 경우, 해시 값은 얼마나 영향을 받는가?
        String plainText2 = "The Road Not Taken by Robert Frost.";
        byte[] plainTextBytes2 = plainText2.getBytes(StandardCharsets.UTF_8);
        byte[] hash3 = sha1.digest(plainTextBytes2);
        System.out.println("SHA-1 Hash Value (One Character Difference): " + Arrays.toString(hash3));
        System.out.println("Hash Value Length (One Character Difference): " + hash3.length);

        // 바이트 배열로 반환되는 해시 값이 얼마나 다른지 퍼센트 값을 계산하여 분석
        byte[] plainTextBytes3 = plainText.getBytes(StandardCharsets.UTF_8);
        byte[] hash4 = sha1.digest(plainTextBytes3);
        byte[] hash5 = sha1.digest(plainTextBytes2);
        int count = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash4[i] != hash5[i]) {
                count++;
            }
        }
        double diffPercent = (double) count / hash.length * 100;
        System.out.println("Percentage Difference (One Character Difference): " + diffPercent);

        // 데이터가 달라지는 위치는 결과 해시 값의 위치에 영향을 주는가?
        byte[] plainTextBytes4 = plainText.getBytes(StandardCharsets.UTF_8);
        plainTextBytes4[0] = 't';
        byte[] hash6 = sha1.digest(plainTextBytes4);
        System.out.println("SHA-1 Hash Value (Changed First Character): " + Arrays.toString(hash6));
        System.out.println("Hash Value Length (Changed First Character): " + hash6.length);
    }
}
