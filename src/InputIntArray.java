import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InputIntArray {
	public static void main(String[] a) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int all = scanner.nextInt();
			List<Integer> keyList = new LinkedList<Integer>();
			for (int i = 0; i < all; i++) {
				keyList.add(scanner.nextInt());
			}
			List<Integer> cloneList=new LinkedList<Integer>();
			cloneList.addAll(keyList);
			
			for (int i = 0; i < cloneList.size(); i++) {
				int j = cloneList.get(i);
				while (j != 1) {
					if (j % 2 == 0) {
						j = j / 2;
					} else {
						j = (3 * j + 1) / 2;
					}
					if (keyList.contains(j)) {
						keyList.remove((Integer) j);
					}

				}
			}
			Collections.sort(keyList);
			Collections.reverse(keyList);
			StringBuilder resultStringBuilder = new StringBuilder();
			for (int i = 0; i < keyList.size(); i++) {
				resultStringBuilder.append(keyList.get(i) + " ");
			}
			System.out.println(resultStringBuilder.substring(0,
					resultStringBuilder.length() - 1));
		}

		scanner.close();
	}

}
