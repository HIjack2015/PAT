package a;

import java.util.Scanner;

public interface Solution {
	Scanner scanner = new Scanner(System.in);

	public void input() throws Exception;

	public void deal() throws Exception;

	public void output();

	public void initial();

}
