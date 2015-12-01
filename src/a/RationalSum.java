package a;
import java.util.Scanner;

public class RationalSum {
	public static void main(String[] a) {
		Fraction[] inputs = (Fraction[]) getInput();
		long max = getLCM(inputs);
		letAllhaveSameDown(inputs, max);
		long sumUp = 0;
		for (Fraction fraction : inputs) {
			sumUp += fraction.up;
		}
		long quotient = sumUp / max;
		long remainder = sumUp % max;

		long gcv = getGCD(remainder, max);
		remainder /= gcv;
		max /= gcv;

		if (quotient == 0) {
			if (remainder == 0) {
				System.out.println("0");
			} else {
				System.out.println(remainder + "/" + max);
			}

		} else {
			if (remainder == 0) {
				System.out.println(quotient);
			} else {
				System.out.println(quotient + " " + remainder + "/" + max);

			}
		}
	}

	public static void letAllhaveSameDown(Fraction[] inputs, long max) {
		for (Fraction fraction : inputs) {
			long toMu = max / fraction.down;
			fraction.up *= toMu;
			fraction.down = max;

		}

	}

	public static long getLCM(Fraction[] inputs) {
		long currentGcm = 1;
		for (int i = 0; i < inputs.length; i++) {
			currentGcm = getLCM(currentGcm, inputs[i].down);
		}
		return currentGcm;

	}

	private static long getLCM(long i, long j) {
		i = Math.abs(i);
		j = Math.abs(j);
		return i * j / getGCD(i, j);

	}

	private static long getGCD(long a, long b) {
		a = Math.abs(a);
		b = Math.abs(b);

		while (b > 0) {
			long temp = b;
			b = a % b; // % is remainder
			a = temp;
		}
		return a;
	}

	public static Object getInput() {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			int allCount = scanner.nextInt();
			Fraction[] fractions = new Fraction[allCount];
			for (int i = 0; i < allCount; i++) {
				String input = scanner.next();
				fractions[i] = new Fraction(input);
			}
			return fractions;
		}
		scanner.close();
		return null;
	}
}

class Fraction {
	long up;
	long down;

	public Fraction(String input) {
		String[] inputs = input.split("/");
		up = Integer.valueOf(inputs[0]);
		down = Integer.valueOf(inputs[1]);
	}

	public String toString() {
		return up + "/" + down;
	}
}