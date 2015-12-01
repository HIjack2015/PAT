package wrong;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class VerifyIdCard {

	static int[] weight = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
	static char[] replace = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3',
			'2' };

	public static void main(String[] a) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int idCardCount = scanner.nextInt();
			List<String> wrongNoList = new LinkedList<String>();
			while (idCardCount > 0) {
				String aIdNo = scanner.next();
				if (aIdNo.length() < 15) {
					continue;
				}

				if (!isAIdNo(aIdNo)) {
					wrongNoList.add(aIdNo);
				}
				idCardCount--;
			}
			if (wrongNoList.size() == 0) {
				System.out.println("All passed");
			} else {
				for (String string : wrongNoList) {
					System.out.println(string);
				}
			}

		}
		scanner.close();
	}

	public static boolean isAIdNo(String input) {
		try {
			int sum = 0;
			for (int i = 0; i < input.length() - 1; i++) {
				int toDeal = Character.getNumericValue(input.charAt(i));
				sum = sum + toDeal * weight[i];
			}
			char lastChar = replace[sum % 11];
			if (lastChar == input.charAt(input.length() - 1)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}
}
