package w2;

import java.util.Scanner;

public class SumOfColumns {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] a = new int[4][3];
		for (int k=0; k<=3; k++) {
			for (int l=0; l<=2; l++) {
				a[k][l] = in.nextInt();
			}
		}
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		for (int i=0; i<=3; i++) {
			sum1 += a[i][0];
			sum2 += a[i][1];
			sum3 += a[i][2];
		}
		System.out.println(sum1+" "+sum2+" "+sum3+" ");
		System.out.println(a);
		in.close();
	}
}
