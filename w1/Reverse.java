package w1;

import java.util.Scanner;;

public class Reverse {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i = in.nextInt();
		i = 100*(i%10)+10*((i%100)/10)+i/100;
		System.out.println(i);
		in.close();
	}
}
