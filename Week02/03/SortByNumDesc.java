import java.util.Comparator;

public class SortByNumDesc implements Comparator<Student>{
	public int compare(Student s1, Student s2) {
        if (s1.id < s2.id) {
            return 1;
        } else if (s1.id > s2.id) {
            return -1;
        } else {
            return 0;
        }
    }
}
