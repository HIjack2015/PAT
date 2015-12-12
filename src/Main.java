import java.util.Scanner;

import a.AvlTree;

public class Main {

	public static void main(String[] args) {
		AvlTree avlTree = new AvlTree();
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		while (count > 0) {
			int ele = scanner.nextInt();
			avlTree.insert(ele);
			count--;
		}
		System.out.println(avlTree.root);
		scanner.close();

	}
}

interface Solution {
	Scanner scanner = new Scanner(System.in);

	public void input();

	public void deal();

	public void output();

}
