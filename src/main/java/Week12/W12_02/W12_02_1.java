package Week12.W12_02;

import java.util.Scanner;

public class W12_02_1 {

	//Version 1 : pre-conditon 체크
	private static int whoswin(String com, String you) {
        assert you.equals("가위") || you.equals("바위") || you.equals("보") : "잘못된 입력입니다.";

        if (you.equals("가위")) {
            if (com.equals("가위")) {
                return 0; // 비김
            } else if (com.equals("바위")) {
                return -1; // 짐
            } else if (com.equals("보")) {
                return 1; // 이김
            }
        } else if (you.equals("바위")) {
            if (com.equals("가위")) {
                return 1; // 이김
            } else if (com.equals("바위")) {
                return 0; // 비김
            } else if (com.equals("보")) {
                return -1; // 짐
            }
        } else if (you.equals("보")) {
            if (com.equals("가위")) {
                return -1; // 짐
            } else if (com.equals("바위")) {
                return 1; // 이김
            } else if (com.equals("보")) {
                return 0; // 비김
            }
        }
        return 0; // 기본적으로 비김
    }

    private static String getInput(Scanner s) {
        String input = s.nextLine();
        return input;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] choices = {"가위", "바위", "보"};
        String com = choices[(int) (Math.random() * 3)]; // 컴퓨터의 선택
        String you;

        System.out.println("컴퓨터의 생성: " + com);
        System.out.print("당신의 입력: ");
        you = getInput(scanner);
        int result = whoswin(com, you);
        if (result == 1) {
            System.out.println("당신이 이겼습니다.");
        } else if (result == 0) {
            System.out.println("비겼습니다.");
        } else {
            System.out.println("당신이 졌습니다.");
        }
    }

}
