package b;

import java.util.Scanner;

public class Skew {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			String input = scanner.next();
			int toSub = getSum(input);
			long sum = getBinSum(input);
			System.out.println(sum -toSub);
		}
		scanner.close();

	}

	public static long getBinSum(String input) {
		int length = input.length();
		long sum = 0;
		for (int i = 0; i < length; i++) {
			int currentInt = Character.getNumericValue(input.charAt(i));
			sum = sum + (long) Math.pow(2, length - i) * currentInt;
		}
		return sum;
	}

	public static int getSum(String input) {
		int sum = 0;
		for (int i = 0; i < input.length(); i++) {
			char toDealChar = input.charAt(i);
			int charValue = Character.getNumericValue(toDealChar);
			sum += charValue;
		}
		return sum;
	}

}
