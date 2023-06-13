package Week03.W03_01;

import java.util.Scanner;

public class W03_01 {
	public enum Game { ROCK, PAPER, SCISSORS, ERRORS; }
    public enum Score { WIN, LOSE, EQUAL, ERRORS; }

    public static Game encode(String str) {
    	switch (str) {
        case "가위":
            return Game.SCISSORS;
        case "바위":
            return Game.ROCK;
        case "보":
            return Game.PAPER;
        default:
            return Game.ERRORS;
    	}
    }

    public static Score whoswin(Game com, Game you) {
    	if (com == Game.ROCK && you == Game.SCISSORS ||
                com == Game.SCISSORS && you == Game.PAPER ||
                com == Game.PAPER && you == Game.ROCK) {
                return Score.LOSE;
            } else if (com == you) {
                return Score.EQUAL;
            } else if (com != Game.ERRORS && you != Game.ERRORS) {
                return Score.WIN;
            } else {
                return Score.ERRORS;
            }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("컴퓨터의 입력: ");
	        String comInput = scanner.nextLine();
	        Game com = encode(comInput);
	        
	        System.out.print("당신의 입력: ");
	        String youInput = scanner.nextLine();
	        Game you = encode(youInput);
	        
	        Score result = whoswin(com, you);
	        switch (result) {
	            case WIN:
	                System.out.println("당신이 이겼습니다.");
	                break;
	            case LOSE:
	                System.out.println("컴퓨터가 이겼습니다.");
	                break;
	            case EQUAL:
	                System.out.println("비겼습니다.");
	                break;
	            default:
            }
            scanner.close();
        }
    }
