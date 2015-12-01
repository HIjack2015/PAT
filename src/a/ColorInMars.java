package a;
import java.util.Scanner;

public class ColorInMars {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int c1 = scanner.nextInt();
			int c2 = scanner.nextInt();
			int c3 = scanner.nextInt();
			System.out.println("#" + get13(c1) + get13(c2) + get13(c3));
		}

		scanner.close();
	}

	public static String get13(int input) {

		String resString = Integer.toString(input, 13).toUpperCase();
		if (resString.length() == 1) {
			resString = "0" + resString;
		}
		return resString;
	}
}
