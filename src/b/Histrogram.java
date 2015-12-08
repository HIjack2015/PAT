package b;

import java.util.Scanner;

public class Histrogram {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			printHistigram(scan.next());
		}
		scan.close();
	}

	public static void printHistigram(String input) {
		int[] countChar = new int[10];
		for (int i = 0; i < input.length(); i++) {
			char toDeal = input.charAt(i);
			countChar[toDeal - '0']++;
		}
		int maxHigh = 0;
		for (int i = 0; i < countChar.length; i++) {
			if (countChar[i] > maxHigh) {
				maxHigh = countChar[i];
			}
		}
		for (int i = maxHigh; i > 0; i--) {
			for (int j = 0; j < countChar.length; j++) {
				if (i<=countChar[j]) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
			
		}
		for (int i = 0; i < countChar.length; i++) {
			System.out.print(i);
		}
		System.out.println();
	}
}
