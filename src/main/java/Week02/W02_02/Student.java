package Week02.W02_02;

public class Student implements Comparable<Student>{
	 private String subject;
	    private int id;
	    private String surname;

	    public Student(String subject, int id, String surname) {
	        this.subject = subject;
	        this.id = id;
	        this.surname = surname;
	    }

	    public String toString() {
	        return subject + "/" + id + "/" + surname;
	    }

	    public String getSubject() {
	        return subject;
	    }

	    public void setSubject(String subject) {
	        this.subject = subject;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getSurname() {
	        return surname;
	    }

	    public void setSurname(String surname) {
	        this.surname = surname;
	    }

	    public int compareTo(Student other) {
	        return this.subject.compareTo(other.subject);
	    }

}
