package w1;

import java.util.Scanner;

public class NPrimeNum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int i = 0;
		int sum = 0;
		int x = 2;
		while (true) {
			if (i == n)
				break;
			boolean isPrime = true;
			for (int k=2; k<=Math.sqrt(x); k++) {
				if (x%k==0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				sum += x;
				i += 1;
			}
			if (x == 2) {
				x = 3;
			} else {
				x += 2;
			}
		}
		System.out.println(sum);
		in.close();
	}
}
