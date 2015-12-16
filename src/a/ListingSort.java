package a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ListingSort {
	static int sortBy;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int studentNumber = scan.nextInt();
		sortBy = scan.nextInt();

		List<Student3> student3s = new ArrayList<Student3>(studentNumber);
		while (studentNumber > 0) {
			String input = scan.nextLine();
			if (input.length() <= 1) {
				continue;
			}
			student3s.add(new Student3(input, sortBy - 1));
			studentNumber--;
		}
		Collections.sort(student3s);
		for (Student3 student3 : student3s) {
			student3.print();
		}
		scan.close();
	}

	static Comparator<Student3> comparatorByGrade = new Comparator<Student3>() {

		@Override
		public int compare(Student3 o1, Student3 o2) {
			// TODO Auto-generated method stub
			return o1.grade - o2.grade;
		}
	};

}

class Student3 implements Comparable<Student3> {
	String name;
	String studentNo;
	int grade;

	String[] infos;
	int sortBy;

	public Student3(String info, int sortBy) {

		infos = info.split(" ");

		this.name = infos[1];
		this.studentNo = infos[0];
		this.grade = Integer.valueOf(infos[2]);
		this.sortBy = sortBy;

	}

	public void print() {
		System.out.println(studentNo + " " + name + " " + grade);
	}

	@Override
	public int compareTo(Student3 o) {
		if (infos[sortBy].compareTo(o.infos[sortBy]) == 0) {
			return studentNo.compareTo(o.studentNo);
		}
		return infos[sortBy].compareTo(o.infos[sortBy]);
	}

}
