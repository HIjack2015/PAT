package b;

import java.util.Scanner;

public class ArrayRotation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			Integer n = scanner.nextInt();
			Integer m = scanner.nextInt();
			int [] arrayToRoate=new int[n];
			for (int i = 0; i < n; i++) {
				arrayToRoate[i]=scanner.nextInt();
			}
			System.out.println(getSelect(arrayToRoate, m));
			
		}

		scanner.close();
	}

	public static String getSelect(int n [], int rotateCount) {
		rotateCount=rotateCount%n.length;
		
		StringBuilder result =new StringBuilder();
		
		for (int i = n.length-rotateCount; i<n.length; i++) {
			result.append(n[i]+" ");
		}
		for (int i = 0; i < n.length-rotateCount; i++) {
			result.append(n[i]+" ");
			
		}
		return  result.substring(0, result.length()-1).toString();
	}
	public static void rotate(int [] arrayToRoate,int from,int end) {
		
	}
}
