package a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Palindromic implements Solution {

	long input;
	long radix;
	Boolean equal = true;
	String reverseString;

	@Override
	public void input() {
		input = scanner.nextLong();
		radix = scanner.nextLong();
	}

	public String getByRadix(long input) {
		if (input == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		do {
			long i = input % radix;
			sb.append(i + " ");
			input = input / radix;
		} while (input > radix);

		sb.append(input);
		return sb.toString();
	}

	private String reverse(String input) {
		String[] inputs = input.split(" ");
		List<String> inputArray = Arrays.asList(inputs);
		Collections.reverse(inputArray);
		return printArrayWithSpace(inputArray);

	}

	private String printArrayWithSpace(List<?> list) {
		StringBuilder resultStringBuilder = new StringBuilder();
		for (Object object : list) {
			resultStringBuilder.append(object + " ");
		}
		if (resultStringBuilder.length() != 0) {
			return resultStringBuilder.substring(0,
					resultStringBuilder.length() - 1);

		} else {
			return "";
		}
	}

	@Override
	public void deal() {
		String inputByRadix = getByRadix(input);
		reverseString = reverse(inputByRadix);
		equal = reverseString.equals(inputByRadix);

	}

	@Override
	public void output() {
		System.out.println(equal ? "Yes" : "No");
		System.out.println(reverseString);

	}
	// 609468183 236
	//
	// 对应输出应该为:
	// No
	// 46 86 180 71
}
