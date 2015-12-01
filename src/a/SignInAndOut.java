package a;
import java.util.Scanner;

public class SignInAndOut {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();

		Record minIn = new Record("CS301111 24:59:59 17:00:10");
		Record maxOut = new Record("CS301111 15:30:28 00:00:00");

		while (count > 0) {

			String element = scan.nextLine();
			if (element.length() <= 1) {
				continue;
			}
			Record record = new Record(element);
			if (record.inTime <= minIn.inTime) {
				minIn = record;
			}
			if (record.outTime >= maxOut.outTime) {
				maxOut = record;
			}
			count--;
		}
		scan.close();
		System.out.println(minIn.peopleNo + " " + maxOut.peopleNo);
	}
}

class Record {
	String peopleNo;
	int inTime;
	int outTime;

	public Record(String input) {
		String[] inputs = input.split(" ");
		peopleNo = inputs[0];
		inTime = Integer.valueOf(inputs[1].replace(':', '0'));
		outTime = Integer.valueOf(inputs[2].replace(':', '0'));

	}
}