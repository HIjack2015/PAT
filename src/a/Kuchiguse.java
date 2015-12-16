package a;


public class Kuchiguse extends MiddleSolution {
	int count;
	String[] eA;
	int sameLength = 0;

	@Override
	public void input() {
		count = scanner.nextInt();
		scanner.nextLine();
		eA = getStringWithSpaceArray(count);
	}

	@Override
	public void deal() {
		int minLength = Integer.MAX_VALUE;
		for (int i = 0; i < eA.length; i++) {
			eA[i] = new StringBuilder(eA[i]).reverse().toString();
			int length = eA[i].length();
			if (length < minLength) {
				minLength = length;
			}

		}
		for (int i = 0; i < minLength; i++) {
			char toCompareChar = eA[0].charAt(i);
			for (int j = 0; j < eA.length; j++) {
				String toDeal = eA[j];
				if (toDeal.charAt(i) != toCompareChar) {
					return;
				}
			}
			sameLength++;
		}

	}

	@Override
	public void output() {
		if (sameLength == 0) {
			System.out.println("nai");
			return;
		}
		String toOutPut = new StringBuilder(eA[0].substring(0, sameLength))
				.reverse().toString();
		System.out.println(toOutPut);

	}
}
