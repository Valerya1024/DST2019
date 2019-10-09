package w1;

import java.util.Scanner;

public class SumPrimeNum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		if (m == 1) {
			m = 2;
		}
		int sum = 0;
		for (int i=m; i<=n; i++) {
			boolean isPrime = true;
			for (int k=2; k<=Math.sqrt(i); k++) {
				if (i%k==0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				sum += i;
			}
		}
		System.out.println(sum);
		in.close();
	}
}
