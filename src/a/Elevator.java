package a;
import java.util.Scanner;

public class Elevator {
	public static void main(String[] a) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String intString = scanner.nextLine();
			int[] result = parseIntArray(intString);
			dealIntArray(result);
		}
		scanner.close();
	}

	public static void dealIntArray(int[] inputArray) {
		int second = 0;
		int currentFloor = 0;
		for (int i = 1; i < inputArray.length; i++) {
			int intToDeal = inputArray[i];
			int sub = intToDeal - currentFloor;
			if (sub > 0) {
				second = second + sub * 6;
			} else {
				second = second - sub * 4;
			}
			currentFloor = intToDeal;
		}
		second = second + (inputArray.length - 1) * 5;
		System.out.println(second);
	}

	public static int[] parseIntArray(String input) {
		String[] inputs = input.split(" ");
		int[] intArray = new int[inputs.length];
		int i = 0;
		for (String string : inputs) {
			intArray[i++] = Integer.valueOf(string);
		}
		return intArray;
	}
}
