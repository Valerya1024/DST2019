package w2;

import java.util.Scanner;

public class NumOfPass {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		String b = a.replace("pass", "");
		System.out.println((a.length()-b.length())/4);
		in.close();
	}
}
