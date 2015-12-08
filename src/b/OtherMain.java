package b;

import java.util.Scanner;

public class OtherMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			System.out.println(scan.nextInt() % 4 == 2 ? "Yes" : "No");
		}
		scan.close();

	}
}
