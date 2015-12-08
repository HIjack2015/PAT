package b;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	// 效率虽然不高,但是可读性非常好..
	int row, col, time;
	int[][] farmLand;
	ArrayList<PeaNut> peaNutList;

	
	int getMaxCanGet() {
		int maxCanGet = 0;
		int listPosition = 0;
		int leaveTime = time;
		PeaNut curNut = new PeaNut(-1, peaNutList.get(0).col, 0);
		while (leaveTime > 0) {
			PeaNut nextPeaNutToGo = peaNutList.get(listPosition);
			int timeCostToGetNext = nextPeaNutToGo.distance(curNut) + 1;
			int timeToReturn = nextPeaNutToGo.row;
			if (timeCostToGetNext + timeToReturn > time) {
				return maxCanGet;
			}
			leaveTime -= timeCostToGetNext;
			leaveTime--;
			maxCanGet += nextPeaNutToGo.number;
			listPosition++;
		}

		return maxCanGet;
	}

	public void getInput() {
		Scanner scanner = new Scanner(System.in);

		row = scanner.nextInt();
		col = scanner.nextInt();
		time = scanner.nextInt();

		farmLand = new int[row][col];
		peaNutList = new ArrayList<Solution.PeaNut>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				farmLand[i][j] = scanner.nextInt();
				peaNutList.add(new PeaNut(i, j, farmLand[i][j]));
			}

		}
		scanner.close();

	}

	class PeaNut implements Comparable<PeaNut> {
		int row, col;
		int number;

		int distance(PeaNut peaNut) {
			return Math.abs(peaNut.row - row) + Math.abs(peaNut.col - col);
		}

		public PeaNut(int row, int col, int number) {
			super();
			this.row = row;
			this.col = col;
			this.number = number;
		}

		@Override
		public int compareTo(PeaNut o) {

			return number - o.number;
		}

		public String toString() {
			return row + " " + col + " " + number;
		}
	}

}
