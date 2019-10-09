package w1;

import java.util.Scanner;

public class Plus {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i = in.nextInt()+in.nextInt();
		System.out.println(i);
		in.close();
	}
}
