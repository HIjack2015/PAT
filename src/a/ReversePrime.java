package a;


public class ReversePrime extends MiddleSolution {

	@Override
	public void input() {
		while (true) {
			int element = scanner.nextInt();
			if (element < 0) {
				break;
			}
			int radix = scanner.nextInt();

			String eleString = Integer.toString(element, radix);
			String revrese = new StringBuilder(eleString).reverse().toString();
			int reverseInt = Integer.valueOf(revrese, radix);
			if (isPrime(reverseInt) && isPrime(element)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}

	@Override
	public void deal() {
		// TODO Auto-generated method stub

	}

	@Override
	public void output() {
		// TODO Auto-generated method stub

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
