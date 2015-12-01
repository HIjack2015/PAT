package a;
import java.util.Scanner;

public class FormatAPlusB {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			dealIt(row, col);
		}
		scanner.close();
	}

	public static void dealIt(int first, int second) {
		int result = first + second;
		String toDeal = String.valueOf(result);
		boolean needFu = false;
		if (toDeal.charAt(0) == '-') {
			needFu = true;
			toDeal = toDeal.substring(1);
		}
		StringBuilder resultString = new StringBuilder();
		int j = 1;
		for (int i = toDeal.length() - 1; i >= 0; i--) {
			char toDealChar = toDeal.charAt(i);
			int toDealInt = Character.getNumericValue(toDealChar);
			resultString.insert(0, toDealInt);
			if (j % 3 == 0) {
				if (i != 0) {
					resultString.insert(0, ",");
				}

			}
			j++;
		}
		if (needFu) {
			resultString.insert(0, "-");
		}
		System.out.println(resultString);
	}
}
