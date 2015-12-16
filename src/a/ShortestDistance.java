package a;


public class ShortestDistance extends MiddleSolution {
	int count;
	int arr[];
	int totalCost;

	@Override
	public void input() throws Exception {
		count = scanner.nextInt();
		arr = getIntArray(count);
		int toQueryCount = scanner.nextInt();
		initial();
		while (toQueryCount > 0) {
			int from = scanner.nextInt();
			int to = scanner.nextInt();

			deal(from, to);
			toQueryCount--;
		}
	}

	@Override
	public void initial() {
		for (int i : arr) {
			totalCost += i;
		}
	}

	@Override
	public void deal() throws Exception {

	}

	public void deal(int from, int to) throws Exception {
		int lengthDirect, lengthCircle;
		if (from > to) {
			int temp = to;
			to = from;
			from = temp;
		}
		lengthDirect = 0;
		for (int i = from; i < to; i++) {
			lengthDirect = lengthDirect + arr[i - 1];
		}
		lengthCircle = totalCost - lengthDirect;
		System.out.println(Math.min(lengthCircle, lengthDirect));
	}

	@Override
	public void output() {
		// TODO Auto-generated method stub

	}

}

