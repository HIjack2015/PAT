package b;

import java.util.Scanner;

public class PrimeNumber {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			Integer n = scanner.nextInt();
			int currentPrime=-4;
			int countResult=0;
			for (int i = 1; i <= n; i++) {
					if (isPrime(i)) {
						if (i-currentPrime==2) {
							countResult++;
						}
						currentPrime=i;
					}
			}
			System.out.println(countResult);
		}
		scanner.close();
	}

	public static boolean isPrime(long n) {
		if (n <= 3) {
			return n > 1;
		}
		if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}

		for (int i = 5; i * i <= n; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}
}
