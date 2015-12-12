package a;

import java.math.BigInteger;

public class Palindromic25 implements Solution {
	BigInteger input;
	int step;
	int useStep;

	@Override
	public void input() {
		input = scanner.nextBigInteger();
		step = scanner.nextInt();

	}

	@Override
	public void deal() {
		for (int i = 0; i < step; i++) {
			if (isReverse(input)) {
				useStep = i;
				System.out.println(input);
				System.out.println(i);
				return;
			} else {
				input = input.add(reverse(input));
			}
		}
		System.out.println(input);
		System.out.println(step);
	}

	private boolean isReverse(BigInteger input) {
		if (input.equals(reverse(input))) {
			return true;
		} else {
			return false;
		}

	}

	private BigInteger reverse(BigInteger input) {
		String reverseString = new StringBuilder(String.valueOf(input))
				.reverse().toString();
		return new BigInteger(reverseString);
	}

	@Override
	public void output() {

	}

}
