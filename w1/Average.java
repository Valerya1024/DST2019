package w1;

import java.util.Scanner;

public class Average {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i;
		double sum = 0;
		int count = 0;
		while (true) {
			i = in.nextInt();
			if (i < 0)
				break;
			sum += i;
			count += 1;
	    }
		if (count==0) {
			System.out.println("0.00");
		} else {
			System.out.printf("%.2f\n", (double)sum/count);
		}
	    in.close();
	}
}
