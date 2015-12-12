package a;

import java.math.BigInteger;
import java.util.Arrays;

public class HaveFunWithNumbers implements Solution {

	BigInteger input;
	Boolean equal = true;
	BigInteger doubleInput;

	@Override
	public void input() {
		input = scanner.nextBigInteger();
	}

	@Override
	public void deal() {
		char[] inputArray = String.valueOf(input).toCharArray();
		Arrays.sort(inputArray);
		doubleInput = input.multiply(BigInteger.valueOf(2L));
		char[] doubleArray = String.valueOf(doubleInput).toCharArray();
		Arrays.sort(doubleArray);

		for (int i = 0; i < inputArray.length; i++) {
			if (doubleArray[i] != inputArray[i]) {
				equal = false;
			}
		}

	}

	@Override
	public void output() {
		System.out.println(equal ? "Yes" : "No");
		System.out.println(doubleInput);
	}

}
