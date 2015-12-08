package b;

import java.util.Arrays;

public class Callatz {
	public static void main(String[] args) {
		int [] result= new int [1001];
		for (int i = 1; i < result.length; i++) {
			int j=i;
			int step=0;
			while(j!=1) {
				if (j%2==0) {
					j=j/2;
				} else {
					j=(3*j+1)/2;
				}
				step++;
			}
			result[i]=step;
		}
		System.out.println(Arrays.toString(result));
	}
}
