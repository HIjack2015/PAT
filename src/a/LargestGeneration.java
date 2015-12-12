package a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LargestGeneration implements Solution {

	public static HashMap<Integer, Node> relation = new HashMap<Integer, Node>();
	int maxLevel = 0;
	List<String> inputLineList;

	@Override
	public void input() {

		scanner.nextInt();
		int nonLeafNodeCount = scanner.nextInt();
		scanner.nextLine();
		inputLineList = new ArrayList<String>(nonLeafNodeCount);
		for (int i = nonLeafNodeCount; i > 0; i--) {
			String nextLine = scanner.nextLine();
			inputLineList.add(nextLine);
		}
	}

	@Override
	public void deal() {
		// Collections.sort(inputLineList);
		while (inputLineList.size() > 0) {
			for (int i = 0; i < inputLineList.size(); i++) {
				String nextLine = inputLineList.get(i);
				String[] inputs = nextLine.split(" ");
				Node thisNode = relation.get(Integer.valueOf(inputs[0]));

				if (thisNode == null) {
					int thisValue = Integer.valueOf(inputs[0]);
					if (thisValue != 1) {
						continue;
					}
					thisNode = new Node();
					thisNode.level = 1;
					relation.put(thisValue, thisNode);
				}
				int level = thisNode.level + 1;
				if (level > maxLevel) {
					maxLevel = level;
				}
				for (int j = 2; j < inputs.length; j++) {
					Integer thisValue = Integer.valueOf(inputs[j]);
					Node n = new Node(thisValue, level);
					// thisNode.childs.add(n);
					relation.put(thisValue, n);
				}
				inputLineList.remove(i);

			}

		}

		int[] levelCountArray = new int[maxLevel + 1];

		for (Node node : relation.values()) {
			levelCountArray[node.level]++;
		}
		int maxCount = 0;
		int maxLevel = 0;
		for (int i = 0; i < levelCountArray.length; i++) {
			int count = levelCountArray[i];
			if (count > maxCount) {
				maxLevel = i;
				maxCount = count;
			}

		}

		System.out.println(maxCount + " " + maxLevel);
	}

	@Override
	public void output() {
		// TODO Auto-generated method stub

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
}
