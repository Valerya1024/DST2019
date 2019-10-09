package w2;

import java.util.Scanner;

public class CountLowercaseLetters {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		int n = in.nextInt();
		for (int i=0; i<n; i++) {
			String a = str.substring(in.nextInt(),in.nextInt()+1);
			String b = a.replace(in.next(), "");
			System.out.println(a.length()-b.length());
		}
		in.close();
	}
}
