package b;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class SongWaiMai {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			BigInteger row = scanner.nextBigInteger();
			BigInteger col = scanner.nextBigInteger();

			System.out.printf("%.2f", getResult(row, col));
			
		}

		scanner.close();
	}

	static BigDecimal getResult(BigInteger row, BigInteger col) {
		BigInteger b2 = BigInteger.valueOf(2l);

		if (row.remainder(b2).intValue() == 0
				|| col.remainder(b2).intValue() == 0) {
			return new BigDecimal(row.multiply(col));
		} else {
			return new BigDecimal(row.multiply(col)).add(new BigDecimal(
					0.414));
		}
	}

}
