package b;

import java.util.Scanner;

public class YueSeFu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			Integer n = scanner.nextInt();
			Integer m = scanner.nextInt();
	
				System.out.println(getSelect(n, m));
			
		}

		scanner.close();
	}

	public static int getSelect(int n, int m) {
		if (n == 1) {
			return 1;
		}
		int result=(getSelect(n - 1, m) + m) % n;
		if(result==0)
			result=n;
		return  result;
	}
}
