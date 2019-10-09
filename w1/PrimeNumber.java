package w1;

import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		boolean isPrime;
		if (x == 1) {
			isPrime = false;
		} else {
			isPrime = true;
		}
		for ( int i = 2; i<=Math.sqrt(x); i++ ) {             
			if ( x%i == 0 ) {
				isPrime = false;
				break;
			}
		}
		if (isPrime) {
			System.out.println(x+" is a prime number.");
		} else {
			System.out.println(x+" is not a prime number.");
		}
		in.close();
	}
}
