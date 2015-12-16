package a;

import java.util.Arrays;

public class CompleteBinaryTree extends MiddleSolution {
	int eleCount;
	int[] eleArray;
	int[] outArray;

	@Override
	public void input() {
		eleCount = scanner.nextInt();
		eleArray = getIntArray(eleCount);
	}

	int index = 0;

	@Override
	public void deal() {
		Arrays.sort(eleArray);
		outArray = new int[eleCount];
		dfs(1);
	}

	public void dfs(int node) {
		if (node > eleCount) {
			return;
		}
		dfs(node * 2);
		outArray[node - 1] = eleArray[index++];
		dfs((node * 2) + 1);
	}

	@Override
	public void output() {
		System.out.println(printArrayWithSpace(outArray));
	}

}
