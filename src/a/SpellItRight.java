package a;
import java.util.Scanner;

public class SpellItRight {
	public static final String[] digit = new String[] { "zero", "one", "two",
			"three", "four", "five", "six", "seven", "eight", "nine" };

	public static void main(String[] a) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			dealInt(scanner.next());
		}
		scanner.close();
	}

	public static void dealInt(String input) {
		String toDeal = String.valueOf(input);
		int sum = 0;
		for (int i = toDeal.length() - 1; i >= 0; i--) {
			char toDealChar = toDeal.charAt(i);
			int toDealInt = Character.getNumericValue(toDealChar);
			sum += toDealInt;
		}
		printIntInEngLish(sum);

	}

	public static void printIntInEngLish(int input) {
		String toDeal = String.valueOf(input);
		StringBuilder resuBuilder = new StringBuilder();
		for (int i = 0; i < toDeal.length(); i++) {
			char toDealChar = toDeal.charAt(i);
			int toDealInt = Character.getNumericValue(toDealChar);
			resuBuilder.append(digit[toDealInt] + " ");

		}
		String resultString = resuBuilder
				.substring(0, resuBuilder.length() - 1).toString();
		System.out.println(resultString);

	}
}
