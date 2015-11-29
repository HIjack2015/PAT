package b;

import java.util.Scanner;

public class WrongEmail {
	public static void main(String args []) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			int wrong = scanner.nextInt();

			long getWrongNum[] = new long[wrong + 1];
			getWrongNum[1] = 0;
			getWrongNum[2] = 1;

			for (int i = 3; i < getWrongNum.length; i++) {
				getWrongNum[i] = (i - 1)
						* (getWrongNum[i - 2] + getWrongNum[i - 1]);
			}
			long result = getWrongNum[wrong];
			long all=fac(wrong);
			
			System.out.printf("%.2f",(double)result/all*100);
			System.out.println("%");
		}
		scanner.close();

	}
	public static final long fac(long n) {
		return (n == 0) ? 1 : n * fac(n - 1);
	}
}
