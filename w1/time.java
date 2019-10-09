package w1;

import java.util.Scanner;

public class time {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int h1 = in.nextInt();
		int m1 = in.nextInt();
		int h2 = in.nextInt();
		int m2 = in.nextInt();
		int d = 60*h2+m2-60*h1-m1;
		System.out.println(d/60+" "+d%60);
		in.close();
	}
}
