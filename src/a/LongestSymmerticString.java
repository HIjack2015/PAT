package a;

import java.util.ArrayList;
import java.util.List;

public class LongestSymmerticString extends MiddleSolution {
	String input;
	int maxLength = 1;

	@Override
	public void input() {
		input = scanner.nextLine();

	}

	@Override
	public void deal() {
		int length = input.length();

		for (int i = length; i > 0; i--) {
			for (int j = 0; j <= length - i; j++) {
				String aChild = input.substring(j, j + i);
				if (isReverse(aChild)) {
					maxLength = aChild.length();
					return;
				}

			}
		}

	}

	public List<String> getAllChildString(String input) {
		int length = input.length();
		int childCount = length * (length + 1) / 2;
		List<String> childs = new ArrayList<String>(childCount);
		for (int i = 1; i <= length; i++) {
			for (int j = 0; j <= length - i; j++) {
				childs.add(input.substring(j, j + i));
			}
		}
		return childs;
	}

	private boolean isReverse(String input) {
		for (int i = 0, j = input.length() - 1; i <= j; i++, j--) {
			char char1 = input.charAt(i);
			char char2 = input.charAt(j);
			if (char1 != char2) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void output() {
		System.out.println(maxLength);
	}

}
