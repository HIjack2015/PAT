package b;

import java.util.HashMap;
import java.util.Scanner;

public class PingPang {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {

			String longString = scan.next();
			String wantString = scan.next();
			boolean haveEnough = true;

			haveEnough = isEnough(longString, wantString);

			if (haveEnough) {

				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
		scan.close();
	}

	static boolean isEnough(String longString, String wantString) {

		HashMap<Character, Integer> longMap = countChar(longString);
		HashMap<Character, Integer> wantMap = countChar(wantString);
		for (Character charToDeal : wantMap.keySet()) {
			Integer longCharCount=longMap.get(charToDeal);
			if(longCharCount==null) {
				return false;
			}
			
			if (wantMap.get(charToDeal)>longMap.get(charToDeal)) {
				
				return false;
			}
		}
		return true;
	}

	static HashMap<Character, Integer> countChar(String input) {
		HashMap<Character, Integer> countHashMap = new HashMap<Character, Integer>();
		for (int i = 0; i < input.length(); i++) {
			Character dealChar = input.charAt(i);

			if (countHashMap.containsKey(dealChar)) {
				countHashMap.put(dealChar, countHashMap.get(dealChar) + 1);
			} else {
				countHashMap.put(dealChar, 1);
			}

		}
		return countHashMap;
	}
}