package a;

import java.util.Scanner;

public class BoyVSGirl {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int studentNumber = scan.nextInt();

		Student2 minMan = new Student2("Joe M Math990112 10086"); // 一个足够大的数字
		Student2 maxWoman = new Student2();
		boolean meetMan = false;
		boolean meetWoman = false;
		while (studentNumber > 0) {
			String input = scan.nextLine();
			if (input.length() == 0) {
				continue;
			}
			Student2 s = new Student2(input);

			if (s.isMan) {
				meetMan = true;
				if (s.grade < minMan.grade) {
					minMan = s;
				}
			} else {
				meetWoman = true;
				if (s.grade > maxWoman.grade) {
					maxWoman = s;
				}
			}
			studentNumber--;
		}
		if (!meetMan || !meetWoman) {
			if (!meetWoman) {
				System.out.println("Absent");
			} else {
				maxWoman.print();
			}
			if (!meetMan) {
				System.out.println("Absent");
			} else {
				minMan.print();
			}
			System.out.println("NA");
		} else {
			maxWoman.print();
			minMan.print();
			System.out.println(maxWoman.grade - minMan.grade);
		}

		scan.close();
	}
}

class Student2 implements Comparable<Student2> {
	public String name;
	public String studentNo;
	public boolean isMan;
	public int grade;

	public Student2() {

	}

	public Student2(String info) {

		String[] infos = info.split(" ");

		this.name = infos[0];
		this.isMan = infos[1].equals("M") ? true : false;
		this.studentNo = infos[2];

		this.grade = Integer.valueOf(infos[3]);
	}

	public void print() {
		System.out.println(name + " " + studentNo);
	}

	@Override
	public int compareTo(Student2 o) {

		return grade - o.grade;
	}

}
