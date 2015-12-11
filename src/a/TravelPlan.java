package a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TravelPlan {
	static int toCity;
	static int currentMinLength = Integer.MAX_VALUE;
	static int currentMinCost = Integer.MAX_VALUE;
	static HashMap<Integer, List<Line>> lineMap;
	static String minLine = "";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cityCount = scanner.nextInt();
		int lineCount = scanner.nextInt();
		int fromCity = scanner.nextInt();

		toCity = scanner.nextInt();
		int useCityCount = toCity - fromCity + 1;
		CostAndLength[][] arr = new CostAndLength[useCityCount][useCityCount];
		for (int i = lineCount; i > 0;) {
			String input = scanner.nextLine();
			if (input.length() < 2) {
				continue;
			}
			Line line = new Line(input);
			arr[line.from][line.to] = new CostAndLength(line.length, line.cost);
			i--;
		}
		CostAndLength minLength = new CostAndLength(100000, 100000);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == null) {
					arr[i][j] = minLength;
				}
				if (i == j) {
					arr[i][j].length = 0;
				}
			}
		}
		scanner.close();

		List<CostAndLength> costAndLengths = new ArrayList<CostAndLength>(
				useCityCount);
		List<Integer> unArriveCityIntegers = new ArrayList<Integer>();
		for (int i = fromCity + 1; i <= toCity; i++) {
			unArriveCityIntegers.add(i);
		}
		for (int i = fromCity; i <= toCity; i++) {
			CostAndLength costAndLength = arr[fromCity][i];
			costAndLength.cityList.add(i);
			costAndLengths.add(costAndLength);

		}

		int currentCity = fromCity;
		while (!(currentCity == toCity)) {
			for (int i = currentCity + 1; i <= toCity; i++) {

				int thisLength = arr[currentCity][i].length
						+ costAndLengths.get(currentCity).length;
				if (thisLength <= costAndLengths.get(i).length) {
					costAndLengths.get(i).length = thisLength;
					costAndLengths.get(i).cityList = new ArrayList<Integer>(
							costAndLengths.get(currentCity).cityList);
					costAndLengths.get(i).cityList.add(i);
				}

			}
			for (Integer integer : unArriveCityIntegers) {
				if (costAndLengths.get(integer - fromCity).length <= minLength.length) {
					minLength = costAndLengths.get(integer - fromCity);
				}
			}
			List<Integer> tempCityList = minLength.cityList;
			Integer cityToAdd = tempCityList.get(tempCityList.size() - 1);
			currentCity = cityToAdd;

		}
		System.out.println(costAndLengths.get(3).cityList);
		;

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
}
