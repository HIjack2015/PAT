package b;

import java.util.HashSet;
import java.util.Scanner;

public class YinShuFenJie {

	static int[] primeArray = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
			43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109,
			113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181,
			191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257,
			263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, };

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int input = scanner.nextInt();
			int n = getEleCount(input);
			System.out.println(n);

		}
		scanner.close();

	}

	static int getEleCount(int input) {
	
		int i = 0;
		HashSet<Integer> hashSet=new HashSet<Integer>();
		while (i < primeArray.length) {
			if (input % primeArray[i] == 0) {
				input = input / primeArray[i];
				hashSet.add(primeArray[i]);
			} else {
				i++;
			}

		}
		if (input!=1) {
			hashSet.add(input);
		}
		
		return hashSet.size();
	}

}