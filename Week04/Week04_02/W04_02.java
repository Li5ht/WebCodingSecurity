package Week04_02;

import java.util.Scanner;

import Week04_01.Student;

public class W04_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
        System.out.print("학생 정보를 입력하세요: ");
        String sid = scanner.next();
        String name = scanner.next();
        String major = scanner.next();
        
        Student student1 = new Student(sid, name, major);
        
        System.out.println("생성된 학생 객체의 정보입니다.");
        System.out.println(student1);
        System.out.print("정보를 저장할 파일 이름을 입력하세요: ");
        
        String fname1 = scanner.next();
        if (student1.writeToFile(fname1)) {
            System.out.println("정보가 파일에 저장되었습니다.");
        }
        System.out.println("프로그램을 종료합니다.");
        
        System.out.print("정보를 읽어올 파일 이름을 입력하세요: ");
        String fname2 = scanner.next();
        Student student2 = Student.readFromFile(fname2);
        if (student2 != null) {
            System.out.println("생성된 학생 객체의 정보입니다.");
            System.out.println(student2);
        }
        
        scanner.close();
	}

}
