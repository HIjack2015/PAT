package b;

import java.util.Scanner;

public class PATRight {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testNumber = scanner.nextInt();
		for (int i = 0; i < testNumber; i++) {
			String input = scanner.next();
			boolean isRight = isPat(input);
			if (isRight) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
		scanner.close();
	}

	static boolean isPat(String input) {

		int countBeforeP = 0;
		int countAfterT = 0;
		int countBetweenA = 0;
		boolean haveSeenP = false;
		boolean haveSeenT = false;

		for (int i = 0; i < input.length(); i++) {
			char charToDeal = input.charAt(i);
			if (charToDeal != 'P' && charToDeal != 'A' && charToDeal != 'T') {
				return false;
			}
			if (charToDeal == 'A') {
				if (haveSeenP == false) {
					countBeforeP++;
				} else if (haveSeenP == true && !haveSeenT) {
					countBetweenA++;
				} else {
					countAfterT++;
				}
			}
			if (charToDeal == 'P') {
				if (haveSeenT) {
					return false;
				}
				if (haveSeenP) {
					return false;
				} else {
					haveSeenP = true;
				}

			}
			if (charToDeal == 'T') {
				if (haveSeenT) {
					return false;
				} else {
					haveSeenT = true;
				}
			}
		}
		if (!haveSeenP || !haveSeenT) {
			return false;
		}
		if (countBetweenA == 0) {
			return false;
		}
		int addCount = countBetweenA - 1;

		int addCount2;
		if (countBeforeP == 0) {
			if (countAfterT == 0) {
				addCount2 = 0;
			} else {
				return false;
			}
		} else {
			if (countAfterT % countBeforeP != 0) {
				return false;
			}
			addCount2 = countAfterT / countBeforeP-1;
		}

		if (addCount == 0) {
			if (addCount2 == 0 || addCount2 == 1) {
				return true;
			} else {
				return false;
			}

		}
		if (addCount < 0) {
			return false;
		}
		if (addCount2 < addCount && addCount2 == 0) {
			return true;
		}
		if (addCount2 < addCount || addCount2 != addCount) {
			return false;
		}
		return true;
	}
}
