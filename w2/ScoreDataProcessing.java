package w2;

import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;

public class ScoreDataProcessing {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashMap<String,String> a = new HashMap<>(); //<sid,name>
		HashMap<String,HashMap<String,Integer>> c = new HashMap<>(); //<sid,Scores>
		HashSet<String> courses = new HashSet<>();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			if (str.equals("")) {
				break;
			}
			String[] s = str.split(",");
			String sid = s[1].split(" ")[2];
			if (s.length==3) {
				a.put(sid, s[2]);
			}
			HashMap<String,Integer> b = new HashMap<>(); //inside c, <course name,score>
			if (s.length==4) {
				if (c.containsKey(sid)) {
					b = c.get(sid);
				}
				courses.add(s[2]);
				b.put(s[2],Integer.parseInt(s[3]));
				c.put(sid,b);
			}
		}
		System.out.println("sid, name, <"+String.join(">, <", courses)+">, average");
		for (HashMap.Entry<String, String> entry : a.entrySet()) {
			Double sum = 0.0;
			System.out.print(entry.getKey()+", "+entry.getValue()+", ");
			HashMap<String,Integer> Scores = c.get(entry.getKey());
			for (String course: courses) {
				if (Scores.containsKey(course)) {
					int score = Scores.get(course);
					sum += score;
					System.out.print(score+", ");
				} else {
					System.out.print(", ");
				}
			}
			System.out.println(sum/Scores.size());
		}
		in.close();
	}
}
