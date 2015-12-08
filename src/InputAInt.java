import java.util.Scanner;

public class InputAInt {
	public static void main(String [] a) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			dealInt(scanner.nextInt());
		}
		scanner.close();
	}

	public static void dealInt(int input) {
		StringBuilder reStringBuilder = new StringBuilder();
		int b3 = input / 100;
		int b2 = (input % 100) / 10;
		int b1 = input % 10;
		while (b3 > 0) {
			reStringBuilder.append("B");
			b3--;
		}
		while (b2 > 0) {
			reStringBuilder.append("S");
			b2--;
		}
		for (int i = 1; i <=b1; i++) {
			reStringBuilder.append(i);
		}
		System.out.println(reStringBuilder);

	}

}
