package a;

import java.util.List;

public abstract class MiddleSolution implements Solution {
	public int[] getIntArray(int count) {
		int[] inputArray = new int[count];
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = scanner.nextInt();
		}
		return inputArray;
	}

	public String printListWithSpace(List<?> list) {
		StringBuilder resultStringBuilder = new StringBuilder();
		for (Object object : list) {
			resultStringBuilder.append(object + " ");
		}
		if (resultStringBuilder.length() != 0) {

			return resultStringBuilder.substring(0,
					resultStringBuilder.length() - 1);

		} else {
			return "";
		}
	}

	public static String printArrayWithSpace(int[] arr) {
		StringBuilder resultStringBuilder = new StringBuilder();
		for (int object : arr) {
			resultStringBuilder.append(object + " ");
		}
		if (resultStringBuilder.length() != 0) {

			return resultStringBuilder.substring(0,
					resultStringBuilder.length() - 1);
		} else {
			return "";
		}
	}

	public String[] getStringWithSpaceArray(int count) {
		String[] inputArray = new String[count];
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = scanner.nextLine();
		}
		return inputArray;
	}

	@Override
	public void initial() {
		// TODO Auto-generated method stub

	}

}
