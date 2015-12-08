import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TreeTraverscal {
	static TreeNode currentNode;
	static Stack<Integer> stack = new Stack<Integer>();
	static Stack<Integer> hashCodeStack = new Stack<Integer>();

	static List<Integer> hashCodeList = new LinkedList<Integer>();
	static List<Integer> list = new LinkedList<Integer>();
	static Integer current = -1;
	int currentPosition;
	static boolean isFirstMiss = true;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nodeCount = scanner.nextInt();
		int strCount = nodeCount * 2;

		while (strCount > 0) {
			String inputString = scanner.nextLine();
			if (inputString.length() < 2) {
				continue;
			}
			dealThisLine(inputString);
			strCount--;
		}
		printArrayWithSpace(list);

		scanner.close();
	}

	static void dealThisLine(String line) {

		String[] inputs = line.split(" ");
		switch (inputs[0]) {
		case "Push":
			Integer toPush = new Integer(Integer.valueOf(inputs[1]));
			stack.push(toPush);
			hashCodeStack.push(System.identityHashCode(toPush));

			int indexInlist = hashCodeList.indexOf(System.identityHashCode(current));

			if (indexInlist == -1) {
				if (isFirstMiss) {
					indexInlist = 0;
					isFirstMiss = false;
				} else {
					System.out.println("error");
				}
			}
			list.add(indexInlist, toPush);
			hashCodeList.add(indexInlist, System.identityHashCode(toPush));
			current = toPush;
			break;
		case "Pop":
			current = stack.pop();
			break;
		default:
			System.out.println("input is not push or pop");
			break;
		}

	}

	public static void printArrayWithSpace(List<?> list) {
		StringBuilder resultStringBuilder = new StringBuilder();
		for (Object object : list) {
			resultStringBuilder.append(object + " ");
		}
		if (resultStringBuilder.length() != 0) {
			System.out.println(resultStringBuilder.substring(0,
					resultStringBuilder.length() - 1));
		} else {
			System.out.println("need to print if 0");
		}
	}
}
// 12 7 17 8 18 4 6 14 11 2 12 11 4 12 7 16 11 11 4