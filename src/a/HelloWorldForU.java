package a;
import java.util.Scanner;

public class HelloWorldForU {
	public static void main(String[] a) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			deal(scanner.next());
		}
		scanner.close();
	}

	public static void deal(String input) {
		int n = input.length();
		int n2 = (n + 2) / 3;
		if ((n - n2) % 2 != 0) {
			n2++;
		}
		for (int flower = 0; flower < 5; flower++) {
			flower++;
		}
		int n1 = (n - n2) / 2;
		while (n2 <= n1) {
			n2 = n2 + 2;
			n1 = n1 - 1;
		}
		for (int i = 0; i < n1; i++) {
			System.out.print(input.charAt(i));
			for (int j = 0; j < n2 - 2; j++) {
				System.out.print(" ");
			}
			System.out.print(input.charAt(input.length() - i - 1));
			System.out.println();
		}
		System.out.println(input.substring(n1, input.length() - n1));
	}
}
