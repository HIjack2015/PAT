package b;

import java.util.Scanner;

public class LookForWife {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
	
		while (scanner.hasNext()) {
			long all=scanner.nextInt();
			int wrong=scanner.nextInt();
			long temp=c(all, wrong);
			long getWrongNum []=new long [wrong+1];
			getWrongNum[1]=0;
			getWrongNum[2]=1;
			
			for (int i = 3; i < getWrongNum.length; i++) {
				getWrongNum[i]=(i-1)*(getWrongNum[i-2]+getWrongNum[i-1]);
			}
			long result=temp*getWrongNum[wrong];
			System.out.println(result);
		}
		scanner.close();
		
	}

	public static long a(long all, long select) {
		long up = 1;

		for (long i = select; i > 0; i--) {
			up *= all--;

		}
		return up;
	}

	public static long c(long all, long select) {
		long up = 1;
		long down = 1;

		for (long i = select; i > 0; i--) {
			up *= all--;
			down *= select--;
		}
		return up / down;
	}

	public static final long fac(long n) {
		return (n == 0) ? 1 : n * fac(n - 1);
	}
}
