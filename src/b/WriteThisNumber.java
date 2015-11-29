package b;

import java.util.Scanner;

public class WriteThisNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()) {
			String input=scanner.next();
			int sum=0;
			for(int i=0;i<input.length();i++) {
				char toDealChar=input.charAt(i);
				int charValue=Character.getNumericValue(toDealChar);
				sum+=charValue;
			}
			printByPinYin(sum);
		
		}
		scanner.close();
	}
	static void printByPinYin(int sum) {
	
		String [] PinYinArray={"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
		String sumString =String.valueOf(sum);
		StringBuilder resultString =new StringBuilder();
		for(int i=0;i<sumString.length();i++) {
			resultString.append(PinYinArray[Character.getNumericValue(sumString.charAt(i))]).append(" ");
		}
		;
		System.out.println(resultString.substring(0, resultString.length()-1));
	}

}
