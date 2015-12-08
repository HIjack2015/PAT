package b;

import java.util.Scanner;

public class SayReverseString {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			System.out.println(getReverse(scanner.nextLine()));
		}
		scanner.close();
		
		
	}
	public static String getReverse(String input) {
		String [] inputs=	input.split(" ");
		StringBuilder resBuilder=new StringBuilder();
		for (int i = inputs.length-1; i >=0; i--) {
			resBuilder.append(inputs[i]).append(" ");
		}
		return resBuilder.substring(0,resBuilder.length()-1).toString();
		
	}

}
