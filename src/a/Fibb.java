package a;

import java.util.Stack;

public class Fibb {

	public static void main(String[] args) {
		System.out.println(fibbUseRecursion(10));
	}

	public static int fibbUseRecursion(int i) {

		if (i == 0) {
			return 0;
		}
		return fibbUseRecursion(i - 1) + 1;
	}

	public static void fibbUseStack(int i) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(i);
		while (!stack.isEmpty()) {
			
		}
	}
}
