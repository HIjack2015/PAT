package b;

import java.math.BigInteger;
import java.util.Scanner;

public class CreateTriangle {
	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			BigInteger a = scanner.nextBigInteger();
			BigInteger b = scanner.nextBigInteger();
			BigInteger c = scanner.nextBigInteger();

			if (a.add(b).compareTo(c) <= 0 || a.subtract(b).abs().compareTo(c) >= 0) {
				System.out.println("No");
			} else {
				System.out.println("Yes");
			}
		}

		scanner.close();

	}

}		