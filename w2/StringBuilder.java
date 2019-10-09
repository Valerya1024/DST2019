package w2;

import java.util.Scanner;

public class StringBuilder {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		StringBuffer s = new StringBuffer();
		for (int i=0; i<=n; i++) {
			s.append(i);
		}
		String s1 = s.toString();
		String s2 = s1.substring(a,b+1);
		String s3 = s2.replaceAll(c+"", "");
		System.out.println(s1.length()+" "+(s2.length()-s3.length()));
		in.close();
	}
}
