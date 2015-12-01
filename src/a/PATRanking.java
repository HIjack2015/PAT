package a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PATRanking {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		int teamNo = 0;
		List<List<Grade>> allTeams = new ArrayList<List<Grade>>(count);
		int peopleCount = 0;
		while (count > 0) {
			teamNo++;
			int thisTeamCount = scan.nextInt();
			peopleCount += thisTeamCount;
			List<Grade> teamInfo = new ArrayList<Grade>(thisTeamCount);
			while (thisTeamCount > 0) {
				String input = scan.nextLine();
				if (input.length() < 2) {
					continue;
				}
				Grade g = new Grade(input, teamNo);
				teamInfo.add(g);
				thisTeamCount--;
			}
			allTeams.add(teamInfo);
			count--;
		}
		scan.close();
		for (List<Grade> list : allTeams) {
			Collections.sort(list);
		}
		for (List<Grade> list : allTeams) {
			setRankInTeam(list);
		}

		// set　rankAll
		List<Grade> allInOne = new ArrayList<Grade>(peopleCount);
		for (List<Grade> list : allTeams) {
			allInOne.addAll(list);
		}
		Collections.sort(allInOne);

		int rank = 1;
		int rankNeedAdd = 1;
		for (int i = 0; i < allInOne.size() - 1; i++) {
			Grade g = allInOne.get(i);
			Grade g2 = allInOne.get(i + 1);
			g.rankAll = rank;
			if (g.grade != g2.grade) {
				rank += rankNeedAdd;
				rankNeedAdd = 1;
			} else {
				rankNeedAdd++;
			}
		}
		Grade g = allInOne.get(allInOne.size() - 1);
		g.rankAll = rank;

		System.out.println(peopleCount);
		for (Grade grade : allInOne) {
			grade.print();
		}

	}

	public static void setRankInTeam(List<Grade> list) {
		int rank = 1;
		int rankNeedAdd = 1;
		for (int i = 0; i < list.size() - 1; i++) {
			Grade g = list.get(i);
			Grade g2 = list.get(i + 1);
			g.rankThis = rank;
			if (g.grade != g2.grade) {
				rank += rankNeedAdd;
				rankNeedAdd = 1;
			} else {
				rankNeedAdd++;
			}
		}
		Grade g = list.get(list.size() - 1);
		g.rankThis = rank;
	}

}

class Grade implements Comparable<Grade> {
	long id;
	int grade;
	int locationNumber;
	int rankThis;
	int rankAll;

	public Grade(String input, int locationNo) {
		this.locationNumber = locationNo;
		String inputs[] = input.split(" ");
		id = Long.valueOf(inputs[0]);
		grade = Integer.valueOf(inputs[1]);
	}

	@Override
	public int compareTo(Grade o) {

		if (o.grade - grade != 0) {
			return -grade + o.grade; // 从大到小排序

		} else {
			return id - o.id > 0 ? 1 : -1;
		}
	}

	public void print() {
		System.out.println(id + " " + rankAll + " " + locationNumber + " "
				+ rankThis);
	}
	// registration_number final_rank location_number local_rank
}