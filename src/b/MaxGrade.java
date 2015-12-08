package b;

import java.util.Scanner;

public class MaxGrade {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int studentNumber = scan.nextInt();
		Student minStudent = new Student("", "", Integer.MAX_VALUE);
		Student maxStudent = new Student("", "", Integer.MIN_VALUE);
		while (studentNumber > 0) {
			String input = scan.nextLine();
			if (input.length()==0) {
				continue;
			}
			Student s = new Student(input);
			if (s.grade > maxStudent.grade) {
				maxStudent = s;
			}
			if (s.grade < minStudent.grade) {
				minStudent = s;
			}

			studentNumber--;
		}
		maxStudent.print();
		minStudent.print();
		scan.close();
	}

}

class Student {
	String name;
	String studentNo;
	int grade;

	public Student(String info) {

		String[] infos = info.split(" ");

		this.name = infos[0];
		this.studentNo = infos[1];
		this.grade = Integer.valueOf(infos[2]);
	}

	public Student(String name, String studentNo, int grade) {
		super();
		this.name = name;
		this.studentNo = studentNo;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void print() {
		System.out.println(name+" "+studentNo);
	}
}
