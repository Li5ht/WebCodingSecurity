package Week02.W02_03;

public class Student implements Comparable<Student>{

	String subject;
    int id;
    String surname;

    public Student(String subject, int id, String surname) {
        this.subject = subject;
        this.id = id;
        this.surname = surname;
    }

    public String toString() {
        return subject + "/" + id + "/" + surname;
    }

    public int compareTo(Student other) {
        return this.subject.compareTo(other.subject);
    }
    
}
