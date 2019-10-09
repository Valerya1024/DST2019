package w3;

import java.util.ArrayList;

public class Animal {
	private String Name;
	private int ID;
	
	public Animal(String name, int id, ArrayList<Animal> a) {
		Name = name;
		ID = id;
		a.add(this);
	}
	
	public String toString() {
		return "I'm "+Name+". My number is "+ID;
	}
}
