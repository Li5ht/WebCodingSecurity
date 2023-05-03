import java.util.ArrayList;
import java.util.Collections;


public class W02_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> sarray = new ArrayList<Student>();
		
		sarray.add(new Student("computer", 20191234, "kim"));
		sarray.add(new Student("computer", 20153456, "yi"));
		sarray.add(new Student("business", 20182468, "lee"));
		sarray.add(new Student("music", 20192468, "park"));
		sarray.add(new Student("business", 20143456, "han"));
		
		System.out.println(sarray);
		
		Collections.sort(sarray, new SortByNumDesc());
		System.out.println(sarray);
		
		Collections.sort(sarray, new SortByMajorNum());
		System.out.println(sarray);
	}
}


