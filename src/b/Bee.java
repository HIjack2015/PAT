package b;

import java.math.BigInteger;
import java.util.Scanner;

public class Bee {
	
	
	
	public static void main(String args[] ) {
	
		BigInteger [] fibb=new BigInteger[1000];
		fibb[0]=BigInteger.valueOf(1L);
		fibb[1]=BigInteger.valueOf(1L);
		for (int i = 2; i < 1000; i++  ) {
			fibb[i]=fibb[i-1].add(fibb[i-2]);
		}
		Scanner scanner=new Scanner(System.in);
		int dataNo=scanner.nextInt();
		Long [] dataArray=new Long[dataNo];
		int count=0;
		while(count<dataNo) {
			long first=scanner.nextLong();
			long second=scanner.nextLong();
			dataArray[count++]=second-first;
		}
		
		for (int i = 0; i < dataArray.length; i++) {
			System.out.println(fibb[dataArray[i].intValue()]);
		}
		scanner.close();
		
	}
}
