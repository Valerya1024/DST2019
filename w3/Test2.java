package w3;

import java.util.ArrayList;

public class Test2 {
	public static void main(String[] args) {
		ArrayList<Animal> a = new ArrayList<>();
		Animal Dog = new Animal("dog",1,a);
		Animal Cat = new Animal("cat",2,a);
		
		for (Animal ani: a) {
			System.out.println(ani);
		}
	}
}
