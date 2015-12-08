package b;

import java.util.Calendar;
import java.util.Scanner;

public class UnLuckDay {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			System.out.println(getUnLuckDay(scan.nextInt()));
		}
		scan.close();
	}

	static public String getUnLuckDay(int year) {
		Calendar calendar = Calendar.getInstance();

		StringBuilder resultString = new StringBuilder();
		for (int month = 0; month < 12; month++) {
			calendar.set(year, month, 13);
			if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
				resultString.append(calendar.get(Calendar.MONTH) + 1).append(
						" ");

			}
		}

		if (resultString.length() == 0) {
			return "Luck";
		} else {
			return resultString.substring(0, resultString.length() - 1)
					.toString();
		}

	}

}
