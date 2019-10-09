package w3;

public class Test {
	public static void main(String[] args){
		String S = "16";
		String s = "a";
		try {
			int a = Integer.parseInt(s);
			System.out.print(a);
		} catch (NumberFormatException e) {
			System.out.print("What?");
		}
		int b = Integer.parseInt(S);
		System.out.print(b);
	}
}
