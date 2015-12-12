package a;


public class HogWarts implements Solution {

	@Override
	public void input() {
		String inputs[] = scanner.nextLine().split(" ");
		Score s1 = new Score(inputs[0]);
		s1.add(new Score(inputs[1]));
		System.out.println(s1);
	}

	@Override
	public void deal() {
		// TODO Auto-generated method stub

	}

	@Override
	public void output() {

	}

	class Score {
		int g;
		int s;
		int k;

		public Score(String input) {
			String[] inputs = input.split("\\.");
			g = Integer.valueOf(inputs[0]);
			s = Integer.valueOf(inputs[1]);
			k = Integer.valueOf(inputs[2]);
		}

		public void add(Score score) {
			int addk = (k + score.k) / 29;
			k = (k + score.k) % 29;
			int adds = (this.s + score.s + addk) / 17;
			s = (s + score.s + addk) % 17;
			g = score.g + g + adds;
		}

		public String toString() {
			return g + "." + s + "." + k;
		}
	}
}
