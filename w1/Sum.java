package w1;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i = in.nextInt();
		int sum = 0;
		while (true) {
			if (i==0)
				break;
			sum += i%10;
			i = i/10;
		}
		System.out.println(sum);
		in.close();
	}
}
