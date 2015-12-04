package a;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Medain {
	static Scanner scanner = new Scanner(System.in);;

	static List<Long> list1, list2;
	static int size1, size2;

	public static void main(String[] args) {

		size1 = scanner.nextInt();
		list1 = getOtherElement(size1);
		size2 = scanner.nextInt();
		list2 = getOtherElement(size2);
		System.out.println(getMedain());

	}

	public static Long getMedain() {

		while (size1 + size2 > 4) {

			Long list1Mid = getMedain(list1);
			Long list2Mid = getMedain(list2);

			if (list1Mid == list2Mid) {
				return list1Mid;
			}

			if (list1Mid > list2Mid) {

				list1 = list1.subList(0, (size1 + 1) / 2);
				list2 = list2.subList((size2 - 1) / 2, size2);
				int shouldAdd = getleft(size2) - getRight(size1);
				reduce(shouldAdd);

			} else {
				List<Long> temp = list1;
				list1 = list2;
				list2 = temp;
			}
			size2 = list2.size();
			size1 = list1.size();

		}
		list1.addAll(list2);
		Collections.sort(list1);
		return getMedain(list1);

	}

	public static void reduce(int shouldReduce) {

		if (shouldReduce > 0) {
			int list1ShouldRemove = 0;
			int list2ShouldRemove = 0;
			while (shouldReduce > 0) { // 需要在右边剔除一些元素
				if (list1.get(list1.size() - 1) > list2.get(list2.size() - 1)) {
					list1ShouldRemove++;
				} else {
					list2ShouldRemove++;
				}
				shouldReduce--;
			}
			list1 = list1.subList(0, list1.size() - list1ShouldRemove);
			list2 = list2.subList(0, list2.size() - list2ShouldRemove);

		} else if (shouldReduce < 0) {
			int list1ShouldRemove = 0;
			int list2ShouldRemove = 0;
			while (shouldReduce < 0) { // 需要在右边剔除一些元素
				if (list1.get(0) < list2.get(0)) {
					list1ShouldRemove++;
				} else {
					list2ShouldRemove++;
				}
				shouldReduce++;
			}
			list1 = list1.subList(list1ShouldRemove, list1.size());
			list2 = list2.subList(list2ShouldRemove, list2.size());

		}
	}

	public static Long getMedain(List<Long> list) {
		return list.get((list.size() - 1) / 2);
	}

	public static int getleft(int size) {
		int mid = (size - 1) / 2;
		return mid;

	}

	public static int getRight(int size) {
		int mid = (size - 1) / 2;
		return size - mid - 1;

	}

	public static List<Long> getOtherElement(int elementCount) {
		List<Long> result = new LinkedList<Long>();
		while (elementCount > 0) {
			result.add(scanner.nextLong());
			elementCount--;
		}
		return result;
	}
}
