import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Solution solution = new ShortestDistance();
		solution.input();

		solution.deal();

		solution.output();
	}
}

class ShortestDistance extends MiddleSolution {
	int count;
	int arr[];
	int totalCost;

	@Override
	public void input() throws Exception {
		count = scanner.nextInt();
		arr = getIntArray(count);
		int toQueryCount = scanner.nextInt();
		initial();
		while (toQueryCount > 0) {
			int from = scanner.nextInt();
			int to = scanner.nextInt();

			deal(from, to);
			toQueryCount--;
		}
	}

	@Override
	public void initial() {
		for (int i : arr) {
			totalCost += i;
		}
	}

	@Override
	public void deal() throws Exception {

	}

	public void deal(int from, int to) throws Exception {
		int lengthDirect, lengthCircle;
		if (from > to) {
			int temp = to;
			to = from;
			from = temp;
		}
		lengthDirect = 0;
		for (int i = from; i < to; i++) {
			lengthDirect = lengthDirect + arr[i - 1];
		}
		lengthCircle = totalCost - lengthDirect;
		System.out.println(Math.min(lengthCircle, lengthDirect));
	}

	@Override
	public void output() {
		// TODO Auto-generated method stub

	}

}

interface Solution {
	Scanner scanner = new Scanner(System.in);

	public void input() throws Exception;

	public void initial();

	public void deal() throws Exception;

	public void output();

}

abstract class MiddleSolution implements Solution {
	public int[] getIntArray(int count) {
		int[] inputArray = new int[count];
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = scanner.nextInt();
		}
		return inputArray;
	}

	public String[] getStringWithSpaceArray(int count) {
		String[] inputArray = new String[count];
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = scanner.nextLine();
		}
		return inputArray;
	}

	public String printListWithSpace(List<?> list) {
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

	public static String printArrayWithSpace(int[] arr) {
		StringBuilder resultStringBuilder = new StringBuilder();
		for (int object : arr) {
			resultStringBuilder.append(object + " ");
		}
		if (resultStringBuilder.length() != 0) {

			return resultStringBuilder.substring(0,
					resultStringBuilder.length() - 1);
		} else {
			return "";
		}
	}

	public void initial() {

	}
}
