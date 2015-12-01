package a;
import java.util.Scanner;

public class ReadNumberInChinese {
	static String[] PinYinArray = { "", "yi", "er", "san", "si", "wu", "liu",
			"qi", "ba", "jiu" };

	public static void main(String[] a) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String toDeal = scanner.next();
			boolean needFu = false;
			if (toDeal.charAt(0) == '-') {
				needFu = true;
				toDeal = toDeal.substring(1);

			}
			int j = 0;
			String[] High = { "", "Wan ", "Yi " };
			StringBuilder resultBuilder = new StringBuilder();
			for (int i = toDeal.length(); i > 0; i = i - 4) {
				String part;
				if (i - 4 < 0) {
					part = toDeal.substring(0, i);
					;
				} else {
					part = toDeal.substring(i - 4, i);
				}

				resultBuilder.insert(0, dealfour(part, High[j++]));
			}
			if (resultBuilder.length() == 0) {
				resultBuilder.append("ling ");
			}
			if (needFu) {
				resultBuilder.insert(0, "Fu ");
			}
			String result = resultBuilder.substring(0,
					resultBuilder.length() - 1);

			result = result.replaceAll("(ling )+", "ling ");
			System.out.println(result);

		}
		scanner.close();

	}

	static boolean needAllTo0 = false;

	public static String dealfour(String input, String suffix) {
		boolean needSuffix = true;
		StringBuilder reStringBuilder = new StringBuilder();
		String Wei[] = { "", "Shi ", "Bai ", "Qian " };
		if (Integer.valueOf(input) == 0) {
			needSuffix = false;
			if (suffix.equals("Wan ")) {
				if (needAllTo0) {
					return "";
				} else {
					return "ling ";
				}

			}
			if (suffix.equals("")) {
				needAllTo0 = true;
				return "";
			}
		}
		if (input.length() > 4) {
			System.err.println("error in deal four");
		}

		int j = 0;
		boolean needAdd0 = false;
		for (int i = input.length() - 1; i >= 0; i--) {
			char toDealChar = input.charAt(i);

			int toDealInt = Character.getNumericValue(toDealChar);
			if (toDealInt != 0) {
				needAdd0 = true;

				reStringBuilder.insert(0, Wei[j]);
				reStringBuilder.insert(0, PinYinArray[toDealInt] + " ");

			} else {
				if (needAdd0) {
					needAdd0 = false;
					reStringBuilder.insert(0, "ling ");

				}
			}
			j++;
		}
		if (needSuffix) {
			reStringBuilder.append(suffix);
		}
		return reStringBuilder.toString();

	}
}
