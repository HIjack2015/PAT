package a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListGrades {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int studentNumber = scan.nextInt();
		List<Student> grades = new ArrayList<Student>(studentNumber);

		while (studentNumber > 0) {
			String input = scan.nextLine();
			if (input.length() == 0) {
				continue;
			}
			Student s = new Student(input);
			grades.add(s);
			studentNumber--;
		}
		int min = scan.nextInt();
		int max = scan.nextInt();
		Collections.sort(grades);
		Collections.reverse(grades);
		boolean hasPrint = false;
		for (Student student : grades) {
			if (student.grade >= min && student.grade <= max) {
				student.print();
				hasPrint = true;
			}
		}
		//myShapesCollection.stream()
		//.filter(e -> e.getColor() == Color.RED)
		//.forEach(e -> System.out.println(e.getName()));
		
		grades.stream().filter(e-> e.grade>=min).forEach(e->e.print());
		
		if (!hasPrint) {
			System.out.println("NONE");
		}

		scan.close();
	}
}

class Student implements Comparable<Student> {
	String name;
	String studentNo;
	int grade;

	public Student(String info) {

		String[] infos = info.split(" ");

		this.name = infos[0];
		this.studentNo = infos[1];
		this.grade = Integer.valueOf(infos[2]);
	}




	public void print() {
		System.out.println(name + " " + studentNo);
	}

	@Override
	public int compareTo(Student o) {

		return grade - o.grade;
	}

}
