package Week02.W02_03;

import java.util.Comparator;

public class SortByMajorNum implements Comparator<Student> {
    public int compare( Student s1, Student s2) {
    	int majorCompare = s1.subject.compareTo(s2.subject);
        if (majorCompare == 0) {
            return s1.id - s2.id;
        } else {
            return majorCompare;
        }
    }
}
