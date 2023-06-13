package Week03.W03_02;

import java.util.Scanner;

public class W03_02 {

	public enum Game { 
		ROCK(0, "바위"), PAPER(1, "보"), SCISSORS(2, "가위");
		
		public int value;
	    public String name;
	    
	    private Game(int value, String name) {
	        this.value = value;
	        this.name = name;
	    }

		public int getValue() {
	        return value;
	    }

	    public String getName() {
	        return name;
	    }
		
	}
	
	public static Game encode(String str) {
    	switch (str) {
        case "가위":
            return Game.SCISSORS;
        case "바위":
            return Game.ROCK;
        case "보":
            return Game.PAPER;
        default:
            return null;
    	}
	}
	
    public enum Score { 
    	WIN, LOSE, EQUAL, ERRORS; 
    	 public static String print(Score score) {
    	        switch (score) {
    	            case WIN:
    	                return "당신이 이겼습니다.";
    	            case LOSE:
    	                return "컴퓨터가 이겼습니다.";
    	            case EQUAL:
    	                return "비겼습니다.";
    	            default:
    	                return "에러 발생";
    	        }
    	    }
    	
    }
    
    public static Score whoswin(Game com, Game you) {
        int comValue = com.getValue();
        int youValue = you.getValue();
        return scoreBoard[comValue][youValue];
    }
    
    static Score[][] scoreBoard ={
    		{Score.EQUAL, Score.LOSE, Score.WIN},
    		{Score.WIN, Score.EQUAL, Score.LOSE},
    		{Score.LOSE, Score.WIN, Score.EQUAL}
    };


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        System.out.print("컴퓨터의 입력: ");
        String comInput = scanner.nextLine();
        Game com = encode(comInput);
        
        System.out.print("당신의 입력: ");
        String youInput = scanner.nextLine();
        Game you = encode(youInput);
        
        Score rslt = whoswin(you, com);
        System.out.println(Score.print(rslt));
        scanner.close();

    }

}
