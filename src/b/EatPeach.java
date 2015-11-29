package b;

import java.util.Scanner;

public class EatPeach {
	public static void main(String[] args) {	
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			if (n<=0) {
				continue;
			}
			System.out.println((int)Math.pow(2, n-1)*3-2);
		}
		scanner.close();
	
	}

	
}
