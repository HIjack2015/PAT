package a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CountingLeaves {

	public static HashMap<Integer, Node> relation = new HashMap<Integer, Node>();
	static int maxLevel = 0;

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int allNodes = scanner.nextInt();
		int nonLeafNodeCount = scanner.nextInt();
		for (int i = nonLeafNodeCount; i > 0; i--) {
			String nextLine = scanner.nextLine();
			if (nextLine.length() <= 1) {
				i++;
				continue;
			}
			dealOneLine(nextLine);
		}
		int[] result = new int[maxLevel + 1];
		for (Node node : relation.values()) {
			if (node.isLeaf()) {
				result[node.level]++;
			}
		}
		StringBuffer resultBuffer = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			resultBuffer.append(result[i] + " ");
		}
		System.out
				.println(resultBuffer.substring(0, resultBuffer.length() - 1));
	}

	public static void dealOneLine(String input) {
		String[] inputs = input.split(" ");
		Node thisNode = CountingLeaves.relation.get(Integer.valueOf(inputs[0]));
		if (thisNode == null) {
			thisNode = new Node();
			thisNode.level = 0;
			relation.put(Integer.valueOf(inputs[0]), thisNode);
		}
		int level = thisNode.level + 1;
		if (level > maxLevel) {
			maxLevel = level;
		}
		for (int i = 2; i < inputs.length; i++) {
			Integer thisValue = Integer.valueOf(inputs[i]);
			Node n = new Node(thisValue, level);
			thisNode.childs.add(n);
			relation.put(thisValue, n);

		}
	}
}

class Node {
	int thisValue;
	int level;
	List<Node> childs;

	public Node() {
		childs = new ArrayList<Node>();
	}

	public Node(int value, int level) {
		thisValue = value;
		this.level = level;
		childs = new ArrayList<Node>();
	}

	public boolean isLeaf() {
		if (childs != null && childs.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
