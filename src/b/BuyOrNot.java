package b;

import java.util.Scanner;

public class BuyOrNot {
	public static void main(String args []) {
		Scanner scan = new Scanner(System.in);

			String longString=scan.next();
			String wantString=scan.next();
			System.out.println(longString.length());
			boolean haveEnough=true;
			int need=0;
			for (int i = 0; i < wantString.length(); i++) {
				char wantChar=wantString.charAt(i);
				int index=longString.indexOf(wantChar);
				if (index>=0) {
					longString=longString.substring(0,index)+" "+longString.substring(index+1,longString.length());
				} else {
					haveEnough=false;
					need++;
				}
			}
			System.out.println(longString.length());
			if (haveEnough) {
				int more =longString.length()-wantString.length();		
				System.out.println("Yes"+" "+more);
			} else {
				System.out.println("No"+" "+need);	
			}
		
		scan.close();
	}
}
