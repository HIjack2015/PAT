package b;

import java.math.BigDecimal;
import java.util.Scanner;

public class DivideAccurcy {
	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			BigDecimal man = scanner.nextBigDecimal();
			BigDecimal woman = scanner.nextBigDecimal();
			int accurency = scanner.nextInt();
		
			man= man.divide(woman,accurency,BigDecimal.ROUND_DOWN);
			System.out.println(man);

		}
		scanner.close();
	}

}