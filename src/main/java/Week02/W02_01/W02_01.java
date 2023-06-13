package Week02.W02_01;

public class W02_01 {
	public static void calcSum(int... nums) {
	    int sum = 0;
	    for (int num : nums) {
	        sum += num;
	    }
	    System.out.println(sum);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calcSum(10, 20);
		calcSum(10,20,30);
		calcSum(10,20,30,40, 50);
	}
}
