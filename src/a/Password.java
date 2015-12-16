package a;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Password {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		int tempCount = count;
		List<String> unPuzzleList = new ArrayList<String>(count / 4);
		while (count > 0) {

			String[] inputs = scanner.nextLine().split(" ");
			if (inputs.length <= 1) {
				continue;
			}
			String unPuzzlePassword = getUnPazzlePassword(inputs[1]);
			if (unPuzzlePassword.equals(inputs[1])) {
				count--;
				continue;
			} else {
				unPuzzleList.add(inputs[0] + " " + unPuzzlePassword);
			}
			count--;
		}
		if (tempCount == 1 && unPuzzleList.size() == 0) {
			System.out.println("There is 1 account and no account is modified");
		} else if (unPuzzleList.size() == 0) {
			System.out.println("There are " + tempCount
					+ " account and no account is modified");
		} else {
			System.out.println(unPuzzleList.size());
			for (String string : unPuzzleList) {
				System.out.println(string);
			}
		}
		scanner.close();
	}

	public static String getUnPazzlePassword(String input) {

		return input.replace('1', '@').replace('0', '%').replace('l', 'L')
				.replace('O', 'o');

	}

}
