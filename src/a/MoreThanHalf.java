package a;

import java.util.Scanner;

public class MoreThanHalf {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int row = scanner.nextInt();
			int col = scanner.nextInt();

			int count = 0;
			int result = -1;

			for (int i = 0; i < row * col; i++) {
				Integer input = scanner.nextInt();
				if (result == input) {
					count++;
				} else {
					count--;
				}
				if (count <= 0) {
					result = input;
					count = 1;
				}

			}
			System.out.println(result);
		}

		scanner.close();
	}

}
