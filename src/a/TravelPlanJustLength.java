package a;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TravelPlanJustLength {
	static int toCity = 3;
	static int fromCity = 0;
	static int arr[][] = { { 0, 1, 2, 5 }, { 0, 0, 100, 2 }, { 0, 0, 0, 1 },
			{ 0, 0, 0, 0 } };
	static int minLength[] = new int[4];

	static List<Integer> unArriveCitys = new LinkedList<Integer>();
	static {
		minLength[0] = 100;
		minLength[1] = 1;
		minLength[2] = 2;
		minLength[3] = 5;
		unArriveCitys.add(1);
		unArriveCitys.add(2);
		unArriveCitys.add(3);
	}
	static int currentCity = fromCity;

	public static void main(String[] args) {

		while (true) {
			for (int i = 0; i < unArriveCitys.size(); i++) {
				int city = unArriveCitys.get(i);

				int length = arr[currentCity][city];
				int toCurrentLength = minLength[currentCity];
				int thisLength = length + toCurrentLength;

				if (thisLength < minLength[city]) {
					minLength[city] = thisLength;
				}

			}
			Integer thisCity = getMinCity(minLength);
			if (thisCity == toCity) {
				System.out.println(minLength[thisCity]);
				return;
			}
			currentCity = thisCity;
			unArriveCitys.remove(thisCity);

		}

	}

	static int getMinCity(int[] minLengths) {
		int minCity = 100;
		int minLength = Integer.MAX_VALUE;
		for (int i = 0; i < minLengths.length; i++) {
			if (unArriveCitys.contains(i)) {
				if (minLengths[i] < minLength) {
					minCity = i;
					minLength = minLengths[i];
				}
			}
		}
		return minCity;
	}
}
