

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class WaitingInLine {

	static Calendar endTime;
	static {
		endTime = Calendar.getInstance();
		endTime.set(Calendar.HOUR_OF_DAY, 17);
		endTime.set(Calendar.MINUTE, 01);
	}

	int windowCount;
	int yellowLineContains;
	int customerCount;
	int queryCount;

	Queue<Request> requestList;
	List<Request> requestCopy;
	List<Integer> queryList;
	List<Queue<Request>> windowList;

	Calendar calendar = Calendar.getInstance();
	{
		calendar.set(Calendar.AM_PM, Calendar.AM);
		calendar.set(Calendar.HOUR, 8);
		calendar.set(Calendar.MINUTE, 0);
	}

	public void print() {
		for (Integer customNo : queryList) {
			System.out
					.println(getHourAndMinute(requestCopy.get(customNo - 1).endTime));
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

		while (!calendar.after(endTime)) {
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
			Calendar calendar2 = Calendar.getInstance();
			if (before == null) {
				calendar2.setTime(calendar.getTime());
			} else {
				calendar2.setTime(before.endTime.getTime());

			}
			calendar2.add(Calendar.MINUTE, request.useTime);
			request.endTime = calendar2;
			toInsertQueue.add(request);
		}

	}

	// return can continue;
	private Queue<Request> dealARequest() {
		Queue<Request> toSubQueue = new LinkedList<Request>();
		Calendar minCost = Calendar.getInstance();
		minCost.set(Calendar.HOUR_OF_DAY, 19);
		for (int i = 0; i < windowList.size(); i++) {
			Queue<Request> thisQueue = windowList.get(i);
			Request request = thisQueue.peek();
			if (request.endTime.before(minCost)) { // 不能用小于等于
				minCost = request.endTime;
				toSubQueue = thisQueue;
			}
		}
		Request toSubRequest = toSubQueue.poll();
		calendar.setTime(toSubRequest.endTime.getTime());

		return toSubQueue;
	}

	private String getHourAndMinute(Calendar calendar) {
		if (calendar.after(endTime)) {
			return "Sorry";
		}
		String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
		String minute = String.valueOf(calendar.get(Calendar.MINUTE));
		if (hour.length() == 1) {
			hour = "0" + hour;
		}
		if (minute.length() == 1)
			minute = "0" + minute;
		return hour + ":" + minute; // TODO 格式不对
	}
}

class Request {
	int customNo;
	int useTime;
	Calendar endTime;

	public Request(int customNo, int useTime) {
		super();
		this.customNo = customNo;
		this.useTime = useTime;
	}
}
