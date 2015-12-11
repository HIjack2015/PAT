package a;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		WaitingInLine2 waitingInLine = new WaitingInLine2();
		waitingInLine.input();
		waitingInLine.deal();
		waitingInLine.print();
	}

}

class WaitingInLine2 {

	static HourMinute endTime = new HourMinute(17, 00);

	int windowCount;
	int yellowLineContains;
	int customerCount;
	int queryCount;

	Queue<Request> requestList;
	List<Request> requestCopy;
	List<Integer> queryList;
	List<Queue<Request>> windowList;

	HourMinute nowTime = new HourMinute(8, 0);

	public void print() {
		for (Integer customNo : queryList) {
			Request request = requestCopy.get(customNo - 1);
			if (request.canService) {
				System.out.println(request.endTime);
			} else {
				System.out.println("Sorry");
			}
		}
	}

	public void printAll() {
		for (Request request : requestCopy) {
			if (request.canService) {
				System.out.println(request.endTime);
			} else {
				System.out.println("Sorry");
			}

		}
	}

	public boolean input() {
		Scanner scanner = new Scanner(System.in);
		windowCount = scanner.nextInt();
		yellowLineContains = scanner.nextInt();
		customerCount = scanner.nextInt();
		queryCount = scanner.nextInt();

		requestList = new ArrayDeque<Request>();

		queryList = new ArrayList<Integer>();
		windowList = new ArrayList<Queue<Request>>(windowCount);

		for (int i = 0; i < windowCount; i++) {
			windowList.add(new LinkedList<Request>());
		}
		for (int i = 0; i < customerCount; i++) {
			Request request = new Request(i, scanner.nextInt());
			requestList.add(request);
		}
		requestCopy = new ArrayList<Request>();
		requestCopy.addAll(requestList);

		for (int i = 0; i < queryCount; i++) {
			queryList.add(scanner.nextInt());
		}
		scanner.close();
		return true;
	}

	public void deal() {

		while (!nowTime.after(endTime)) {
			Request request = requestList.poll();
			if (request == null) {
				return;
			}
			boolean canAdd = false;
			Queue<Request> toInsertQueue = new LinkedList<Request>();
			int maxNow = yellowLineContains;
			for (Queue<Request> queue : windowList) {
				if (queue.size() < maxNow) {
					canAdd = true;
					maxNow = queue.size();
					toInsertQueue = queue;
				}
			}
			if (!canAdd) {
				toInsertQueue = dealARequest();
			}
			Request before = toInsertQueue.peek();
			HourMinute currentEndTime = new HourMinute(0, 0);
			if (before == null) {
				currentEndTime = nowTime.clone();
			} else {
				currentEndTime = before.endTime.clone();
			}

			if (!currentEndTime.before(endTime)) {

			} else {
				request.canService = true;
				currentEndTime.addMinute(request.useTime);
				request.endTime = currentEndTime;

			}
			toInsertQueue.add(request);
		}

	}

	private Queue<Request> dealARequest() {
		Queue<Request> toSubQueue = new LinkedList<Request>();
		HourMinute minCost = new HourMinute(Integer.MAX_VALUE, 00);

		for (int i = 0; i < windowList.size(); i++) {
			Queue<Request> thisQueue = windowList.get(i);
			Request request = thisQueue.peek();
			if (!request.endTime.after(minCost)) { // 不能用小于等于
				minCost = request.endTime;
				toSubQueue = thisQueue;
			}
		}
		Request toSubRequest = toSubQueue.poll();
		nowTime = toSubRequest.endTime.clone();
		return toSubQueue;
	}

}

class Request {
	int customNo;
	int useTime;
	boolean canService = false;
	HourMinute endTime;

	public Request(int customNo, int useTime) {
		super();
		this.customNo = customNo;
		this.useTime = useTime;
	}

}

class HourMinute implements Cloneable {
	public int hour;
	public int minute;

	public void addMinute(int addMinute) {
		int addHour = (addMinute + this.minute) / 60;
		this.minute = (addMinute + this.minute) % 60;
		this.hour = hour + addHour;
	}

	public HourMinute clone() {
		return new HourMinute(hour, minute);
	}

	public HourMinute(int hour, int minute) {
		super();
		this.hour = hour;
		this.minute = minute;
	}

	public String toString() {

		String hourStr = String.valueOf(hour);
		String minuteStr = String.valueOf(minute);
		if (hour < 10) {
			hourStr = "0" + String.valueOf(hour);
		}
		if (minute < 10) {
			minuteStr = "0" + String.valueOf(minute);
		}
		return hourStr + ":" + minuteStr;
	}

	public boolean after(HourMinute hourMinute) {
		if (hour > hourMinute.hour) {
			return true;
		} else if (hour == hourMinute.hour) {
			if (minute > hourMinute.minute) {
				return true;
			}
		}
		return false;
	}

	public boolean before(HourMinute hourMinute) {
		if (hour < hourMinute.hour) {
			return true;
		} else if (hour == hourMinute.hour) {
			if (minute < hourMinute.minute) {
				return true;
			}
		}
		return false;
	}
}
