package Week04_02;

import java.io.*;
import java.util.*;

public class Student {
	 private String sid;
	    private String name;
	    private String major;

	    // 생성자
	    public Student(String sid, String name, String major) {
	        this.sid = sid;
	        this.name = name;
	        this.major = major;
	    }

	    // getter 메소드
	    public String getSid() {
	        return sid;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getMajor() {
	        return major;
	    }

	    // setter 메소드
	    public void setSid(String sid) {
	        this.sid = sid;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public void setMajor(String major) {
	        this.major = major;
	    }

	    // 파일로부터 학생 정보를 읽어와서 객체 생성 및 반환
	    public static Student readFromFile(String fname) {
	        try {
	            File file = new File(fname);
	            Scanner scanner = new Scanner(file);
	            String sid = scanner.next();
	            String name = scanner.next();
	            String major = scanner.next();
	            scanner.close();
	            return new Student(sid, name, major);
	        } catch (FileNotFoundException e) {
	            System.out.println("파일을 찾을 수 없습니다.");
	            return null;
	        }
	    }

	    // 학생 정보를 파일에 저장
	    public boolean writeToFile(String fname) {
	        try {
	            FileWriter writer = new FileWriter(fname);
	            writer.write(sid + " " + name + " " + major);
	            writer.close();
	            return true;
	        } catch (IOException e) {
	            System.out.println("파일을 저장할 수 없습니다.");
	            return false;
	        }
	    }

	    // toString 메소드 오버라이딩
	    @Override
	    public String toString() {
	        return "Student[" + name + ", " + sid + ", " + major + "]";
	    }

}
