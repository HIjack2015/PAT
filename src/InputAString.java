import java.util.Scanner;

public class InputAString {
	public static void main(String[] a) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			deal(scanner.next());
		}
		scanner.close();
	}

	public static void deal(String input) {
		int i = 0;
		for (; i < input.length(); i++) {
			char toDeal = input.charAt(i);
			if (toDeal == 'P') {
				break;
			}
		}
		long countP = 0L;
		long countPA = 0L;
		long countPAT = 0L;
		for (; i < input.length(); i++) {
			char toDeal = input.charAt(i);
			if (toDeal == 'P') {
				countP++;
				countP %= 1000000007;
			}
			if (toDeal == 'A') {
				countPA = countP + countPA;
				countPA %= 1000000007;
			}
			if (toDeal == 'T') {
				countPAT = countPA + countPAT;
				countPAT %= 1000000007;
			}
		}
		System.out.println(countPAT % 1000000007L);
	}
}
