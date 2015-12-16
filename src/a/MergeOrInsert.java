package a;

import java.util.Arrays;

public class MergeOrInsert extends MiddleSolution{
	int elementCount;
	int[] rawArr;
	int[] middleArr;
	boolean isInsert = false;
	int[] rawArrClone;

	@Override
	public void input() {
		elementCount = scanner.nextInt();
		rawArr = new int[elementCount];
		for (int i = 0; i < rawArr.length; i++) {
			rawArr[i] = scanner.nextInt();
		}
		middleArr = new int[elementCount];
		for (int i = 0; i < middleArr.length; i++) {
			middleArr[i] = scanner.nextInt();
		}
		rawArrClone = rawArr.clone();
	}

	@Override
	public void deal() {

		boolean needStep = true;
		for (int i = 0; i < rawArrClone.length; i++) {
			int j = i;
			int temp = rawArrClone[i];
			for (; j > 0 && temp < rawArrClone[j - 1]; j--) {
				rawArrClone[j] = rawArrClone[j - 1];
			}
			rawArrClone[j] = temp;
			if (equal(rawArrClone, middleArr)) {
				isInsert = true;

			}
			if (isInsert && needStep) {
				needStep = false;
				rawArr = rawArrClone.clone();
				continue;
			} else if (isInsert && !needStep) {
				if (equal(rawArr, rawArrClone)) {
					continue;
				}
				rawArr = rawArrClone;
				break;
			}
		}
		if (!isInsert) {
			mergeNext();

		}

	}

	public void mergeNext() {
		boolean needStep = true;
		boolean find = false;

		for (int i = 2; i <= elementCount; i *= 2) {
			if (i > elementCount) {
				i = elementCount;
			}
			for (int j = 0; j < elementCount; j = j + i) {
				int end = j + i;
				if (end > elementCount) {
					end = elementCount;
				}
				Arrays.sort(rawArr, j, end);
			}
			if (equal(rawArr, middleArr)) {
				find = true;
			}
			if (find && needStep) {
				rawArrClone = rawArr.clone();
				needStep = false;
			} else if (find && !needStep) {
				if (equal(rawArr, rawArrClone)) {
					continue;
				}
				return;
			}

		}
	}

	public static boolean equal(int[] a1, int[] a2) {
		for (int i = 0; i < a2.length; i++) {
			if (a1[i] != a2[i]) {
				return false;
			}
		}
		return true;
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

	@Override
	public void output() {
		System.out.println(isInsert ? "Insertion Sort" : "Merge Sort");
		System.out.println(printArrayWithSpace(rawArr));
	}

}
