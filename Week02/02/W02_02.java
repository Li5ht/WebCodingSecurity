import java.util.ArrayList;
import java.util.Collections;

public class W02_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> sarray = new ArrayList<Student>();
		
		sarray.add(new Student("computer", 20191234, "kim"));
		sarray.add(new Student("business", 20182468, "lee"));
		sarray.add(new Student("music", 20192468, "park"));
		
		System.out.println(sarray);
		
		Collections.sort(sarray);
		System.out.println(sarray);
	}

}
