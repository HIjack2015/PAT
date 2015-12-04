package a;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TravelPlan {
	static int toCity;
	static int currentMinLength = Integer.MAX_VALUE;
	static int currentMinCost = Integer.MAX_VALUE;
	static HashMap<Integer, List<Line>> lineMap;
	static String minLine = "";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cityCount = scanner.nextInt();
		int lineCount = scanner.nextInt();
		int fromCity = scanner.nextInt();
		toCity = scanner.nextInt();
		lineMap = new HashMap<Integer, List<Line>>();
		for (int i = lineCount; i > 0;) {
			String input = scanner.nextLine();
			if (input.length() < 2) {
				continue;
			}
			Line line = new Line(input);
			List<Line> list = lineMap.get(line.from);
			if (list == null) {
				list = new LinkedList<Line>();
				lineMap.put(line.from, list);
			}
			list.add(line);
			i--;
		}

		// getLengthAndCost(0, 0, fromCity, "0 ");

		// System.out.println(minLine + currentMinLength + " " +
		// currentMinCost);
		useStack();
	}

	public static void useStack() {

		Stack<Line> stack = new Stack<Line>();
		stack.add(new Line("0 0 0 0"));
		do {
			Line currentPosition = stack.pop();
			List<Line> list = lineMap.get(currentPosition.from);
			for (Line line : list) {
				List<Line> list2 = lineMap.get(currentPosition.to);
				for (Line line2 : list2) {
					stack.add(line2);
				}
			}

		} while (!stack.isEmpty());
		System.out.println("i will end");
	}

	public static void getLengthAndCost(int currentLength, int currentCost,
			int currentPosition, String luXian) {
		if (currentLength > currentMinLength) {
			return;
		}
		if (currentPosition == toCity) {
			if (currentLength > currentMinLength) {
				return;
			} else if (currentLength == currentMinLength) {
				if (currentCost < currentMinCost) {
					minLine = luXian.toString();
				}
				currentMinCost = Math.min(currentMinCost, currentCost);
			} else {
				currentMinCost = currentCost;
				currentMinLength = currentLength;
				minLine = luXian.toString();
			}

			return;
		}
		List<Line> list = lineMap.get(currentPosition);
		for (Line line : list) {
			getLengthAndCost(currentLength + line.length, currentCost
					+ line.cost, line.to, luXian + line.to + " ");
		}

	}
}

class Line {
	int from;
	int to;
	int length;
	int cost;

	public Line(String input) {
		String[] inputs = input.split(" ");
		from = Integer.valueOf(inputs[0]);
		to = Integer.valueOf(inputs[1]);
		length = Integer.valueOf(inputs[2]);
		cost = Integer.valueOf(inputs[3]);
	}
}
