package w6;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class ScoreDataProcessing {
	static String filepath = "C:\\Users\\surface\\eclipse-workspace\\DST\\src\\w6\\score.txt";
	static HashMap<String,String> a = new HashMap<>(); //<sid,name>
	static HashMap<String,HashMap<String,Integer>> c = new HashMap<>(); //<sid,Scores>
	static ArrayList<String> courses = new ArrayList<>();
	public static void load(){
		try {
			FileInputStream inputStream = new FileInputStream(filepath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String line;
			line = reader.readLine();
			String[] course = line.split("\\W+");
			for (int i=2; i<course.length-1; i++) {
				courses.add(course[i]);
			}
			while ((line = reader.readLine()) != null) {
				String[] l = line.split(", ");
				a.put(l[0],l[1]);
				HashMap<String,Integer> cs = new HashMap<>();
				for (int i=2; i<l.length-1; i++) {
					if (!l[i].equals("")) {
						cs.put(courses.get(i-2),Integer.parseInt(l[i]));
					}
				}
				c.put(l[0], cs);
			}
		    reader.close();
		} catch (FileNotFoundException e){
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void write() {
		try {
			File newAns = new File(filepath); 
            newAns.createNewFile();  
            BufferedWriter writer = new BufferedWriter(new FileWriter(newAns));
            String w = "sid, name, <"+String.join(">, <", courses)+">, average\n";
    		for (HashMap.Entry<String, String> entry : a.entrySet()) {
    			Double sum = 0.0;
    			w += entry.getKey()+", "+entry.getValue()+", ";
    			HashMap<String,Integer> Scores = c.get(entry.getKey());
    			for (String course: courses) {
    				if (Scores.containsKey(course)) {
    					int score = Scores.get(course);
    					sum += score;
    					w += score+", ";
    				} else {
    					w += ", ";
    				}
    			}
    			w += sum/Scores.size()+"\n";
    		}
			writer.write(w);
			System.out.print(w);
			writer.flush();
            writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		load();
		Scanner in = new Scanner(System.in);
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
				if (!courses.contains(s[2])) {
					courses.add(s[2]);
				}
				b.put(s[2],Integer.parseInt(s[3]));
				c.put(sid,b);
			}
		}
		in.close();
		write();
	}
}
