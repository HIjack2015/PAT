package a;

import java.util.ArrayList;
import java.util.List;

public class TravelPlan implements Solution {
	int fromCity;
	int toCity;
	int cityCount;

	List<CostAndLength> costAndLengths;
	CostAndLength[][] arr;
	List<Integer> unArriveCitys;

	CostAndLength minLength;

	@Override
	public void input() {

		cityCount = scanner.nextInt();
		int lineCount = scanner.nextInt();
		fromCity = scanner.nextInt();
		toCity = scanner.nextInt();

		arr = new CostAndLength[cityCount][cityCount];
		for (int i = lineCount; i > 0;) {
			String input = scanner.nextLine();
			if (input.length() < 2) {
				continue;
			}
			Line line = new Line(input);
			arr[line.from][line.to] = new CostAndLength(line.length, line.cost);
			i--;
		}

		scanner.close();

	}

	public void initial() {
		// 填充数组中空白元素
		CostAndLength maxLength = new CostAndLength(100000, 100000);
		CostAndLength minLength = new CostAndLength(0, 0);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == null) {
					arr[i][j] = maxLength;
				}
				if (i == j) {
					arr[i][j] = minLength;
				}
			}
		}
		// 初始化 costAndLength
		costAndLengths = new ArrayList<CostAndLength>(cityCount);
		unArriveCitys = new ArrayList<Integer>();
		for (int i = fromCity + 1; i <= toCity; i++) {
			unArriveCitys.add(i);
		}

		for (int i = fromCity; i <= toCity; i++) {
			CostAndLength costAndLength = arr[fromCity][i];
			costAndLength.cityList.add(i);
			costAndLengths.add(costAndLength);

		}
	}

	@Override
	public void deal() {
		initial();

		int currentCity = fromCity;
		while (true) {
			for (int i = 0; i < unArriveCitys.size(); i++) {
				int nextCity = unArriveCitys.get(i);

				int thisLength = arr[currentCity][nextCity].length
						+ costAndLengths.get(currentCity).length;
				int thisCost = arr[currentCity][nextCity].cost
						+ costAndLengths.get(currentCity).cost;
				CostAndLength currentCost = costAndLengths.get(nextCity);
				if (thisLength < currentCost.length
						|| (thisLength == currentCost.length && thisCost < currentCost.cost)) {
					currentCost.length = thisLength;
					currentCost.cost = thisCost;

					currentCost.cityList = new ArrayList<Integer>(
							costAndLengths.get(currentCity).cityList);
					currentCost.cityList.add(nextCity);
				}

			}
			minLength = new CostAndLength(200000, 10);
			Integer minCity = 0;
			for (Integer city : unArriveCitys) {
				if (costAndLengths.get(city).littleThan(minLength)) { // 此处应该选cost最小的
					minLength = costAndLengths.get(city);
					minCity = city;
				}
			}
			currentCity = minCity;
			unArriveCitys.remove(minCity);
			if (currentCity == toCity) {
				break;
			}
		}
	}

	@Override
	public void output() {
		System.out.print(fromCity + " ");
		for (Integer city : minLength.cityList) {
			System.out.print(city + " ");
		}
		System.out.print(minLength.length + " " + minLength.cost);
	}
}

class Line {
	int from;
	int to;
	int length;
	int cost;

	public Line(String input) {
		String[] inputs = input.split(" ");
		from = Integer.valueOf(inputs[0]);
		to = Integer.valueOf(inputs[1]);
		length = Integer.valueOf(inputs[2]);
		cost = Integer.valueOf(inputs[3]);
	}
}

class CostAndLength {
	int length;
	int cost;
	List<Integer> cityList = new ArrayList<Integer>();

	public CostAndLength(int length, int cost) {
		super();
		this.length = length;
		this.cost = cost;
	}

	public String toString() {
		return "length " + length + " cost " + cost;
	}

	public boolean littleThan(CostAndLength c) {
		if (length < c.length || (length == c.length && cost < c.cost)) {
			return true;

		}
		return false;
	}

}
