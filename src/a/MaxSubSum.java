package a;

import java.util.Scanner;

public class MaxSubSum {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int arrayLength = scanner.nextInt();
		int[] array = new int[arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			array[i] = scanner.nextInt();

		}
		scanner.close();
		// 开始处理
		int maxSum = Integer.MIN_VALUE; // 之前最大
		int sum = 0; // 连上这个最大

		int start = 0;
		int end = 0;

		int maxStart = 0;
		int maxEnd = 0;

		int flag = 1;
		for (int i = 0; i < array.length; i++) {
			int currentElement = array[i];
			sum += currentElement;
			if (flag == 1) {
				start = currentElement;
				flag = 0;
			}
			if (sum < 0) {
				sum = 0;
				flag = 1;
			} else if (sum > maxSum) {
				end =currentElement;
				maxSum = sum;
				maxStart = start;
				maxEnd = end;
			}

		}

		if (maxSum < 0) {
			System.out
					.println("0 " + array[0] + " " + array[array.length - 1]);
		} else {
			System.out.println(maxSum + " " + maxStart + " " + maxEnd);
		}
	}
}
