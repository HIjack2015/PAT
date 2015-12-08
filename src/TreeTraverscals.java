import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TreeTraverscals {
	static Scanner scanner = new Scanner(System.in);
	static StringBuilder reStringBuilder = new StringBuilder();

	public static void main(String[] args) {

		int count = Integer.valueOf(scanner.nextLine());
		Integer[] postOrder = getNextintArray(); // 后 根// 2 3 1 5 7 6 4
		Integer[] inOrder = getNextintArray(); // 中根// 1 2 3 4 5 6 7
		List<Integer> postList = Arrays.asList(postOrder);
		List<Integer> inList = Arrays.asList(inOrder);

		TreeNode rootNode = new TreeNode(postList, inList);
		StringBuilder reStringBuilder = new StringBuilder();
		inList = rootNode.getAllElement(TreeNode.GetTreeMethod.up);
	
		for (Integer integer : inList) {
			if (integer != null) {
				reStringBuilder.append(integer + " ");
			}
		}
		System.out.println(reStringBuilder.substring(0,
				reStringBuilder.length() - 1));
		scanner.close();
	}

	public static Integer[] getNextintArray() {
		String[] inputs = scanner.nextLine().split(" ");
		if (inputs.length < 1) {
			return null;
		}
		Integer[] intInput = new Integer[inputs.length];
		for (int i = 0; i < intInput.length; i++) {
			intInput[i] = Integer.valueOf(inputs[i]);

		}
		return intInput;
	}

}

class TreeNode {

	enum GetTreeMethod {
		left, right, middle, up;
	}

	public TreeNode leftNode;
	public TreeNode rightNode;
	public Integer val;

	public TreeNode(List<Integer> post, List<Integer> in) {
		if (post == null || post.size() == 0 || in == null || in.size() == 0) {
			return;
		}
		val = post.get(post.size() - 1);
		int rootPositionInMiddle = in.indexOf(val);

		int leftSize = rootPositionInMiddle;
		int rightSize = in.size() - rootPositionInMiddle;
		if (leftSize != 0) {
			List<Integer> inLeft = in.subList(0, rootPositionInMiddle);
			List<Integer> postLeft = post.subList(0, leftSize);
			leftNode = new TreeNode(postLeft, inLeft);

		}
		if (rightSize != 0) {
			List<Integer> inRight = in.subList(rootPositionInMiddle + 1,
					in.size());
			List<Integer> postRight = post.subList(leftSize, post.size() - 1);
			rightNode = new TreeNode(postRight, inRight);
		}

	}

	public List<Integer> getAllElement(GetTreeMethod method) {

		List<Integer> resultList = new ArrayList<Integer>();

		switch (method) {
		case left:
			resultList.add(val);
			if (leftNode != null) {
				resultList.addAll(leftNode.getAllElement(GetTreeMethod.left));
			}
			if (rightNode != null) {
				resultList.addAll(rightNode.getAllElement(GetTreeMethod.left));
			}
			break;
		case middle:
			if (leftNode != null) {
				resultList.addAll(leftNode.getAllElement(GetTreeMethod.middle));
			}
			resultList.add(val);
			if (rightNode != null) {
				resultList
						.addAll(rightNode.getAllElement(GetTreeMethod.middle));
			}
			break;
		case right:
			if (leftNode != null) {
				resultList.addAll(leftNode.getAllElement(GetTreeMethod.right));
			}
			if (rightNode != null) {
				resultList.addAll(rightNode.getAllElement(GetTreeMethod.right));
			}
			resultList.add(val);
			break;
		case up:
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(this);
			while (!queue.isEmpty()) {
				TreeNode currentNode = queue.poll();
				resultList.add(currentNode.val);
				if (currentNode.leftNode != null) {
					queue.add(currentNode.leftNode);
				}
				if (currentNode.rightNode != null) {
					queue.add(currentNode.rightNode);
				}
			}
		default:

			break;

		}

		return resultList;
	}
}