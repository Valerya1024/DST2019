package w1;

import java.util.Scanner;

public class convert {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double i = in.nextDouble();
		int k = (int)(i*12/30.48);
		int m = k/12;
		int n = k%12;
		System.out.println(m+" "+n);
		in.close();
	}
}
