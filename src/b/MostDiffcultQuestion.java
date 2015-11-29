package b;

import java.util.Scanner;

public class MostDiffcultQuestion {

	static int[] relation = { 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E',
			'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			System.out.println(getEncript(scan.nextLine()));
		}
		scan.close();
	}

	public static String getEncript(String toEncript) {
		StringBuilder reStringBuilder = new StringBuilder();
		for (int i = 0; i < toEncript.length(); i++) {
			char toDeal = toEncript.charAt(i);
			if (toDeal == ' ') {
				reStringBuilder.append((char) toDeal);
			} else {
				reStringBuilder.append((char) relation[toDeal - 'A']);
			}
		}
		return reStringBuilder.toString();
	}
}
