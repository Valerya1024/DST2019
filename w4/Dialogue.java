package w4;

import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class Dialogue {
	static HashMap<String,ArrayList<String>> ans = new HashMap<>();
	static String filepath = "C:\\Users\\surface\\eclipse-workspace\\DST\\src\\w4\\dialogue.txt";
	static ArrayList<String> ANS = new ArrayList<>();
	static String key;
	public static void read(){
		try {
			FileInputStream inputStream = new FileInputStream(filepath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] l = line.split("  ");
				ArrayList<String> a = new ArrayList<>();
				for (int i=1; i<l.length; i++) {
					a.add(l[i]);
				}
				ans.put(l[0],a);
			}
		    reader.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	public static void add(String q, String a) {
		if (Contains(ans,q,false)) {
			ans.get(key).add(a);
		} else {
			ArrayList<String> A = new ArrayList<>();
			A.add(a);
			ans.put(q, A);
		}
	}
	public static void write() {
		try {
			File newAns = new File(filepath); 
            newAns.createNewFile();  
            BufferedWriter writer = new BufferedWriter(new FileWriter(newAns));  
			for (HashMap.Entry<String,ArrayList<String>> entry: ans.entrySet()) {
				writer.write(entry.getKey()+"  "+String.join("  ", entry.getValue())+"\n");
			}
			writer.flush();
            writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static boolean Contains(HashMap<String, ArrayList<String>> hmp, String str, Boolean genANS){
        for (HashMap.Entry<String, ArrayList<String>> entry: hmp.entrySet()) {
            if(entry.getKey().equalsIgnoreCase(str)) {
            	if (genANS) {
            		ANS.addAll(entry.getValue());
            	} else {
            		key = entry.getKey();
            	}
            	return true;
            }
        }
        return false;
	}
	public static void main(String[] args) {
		read();
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		while(true) {
			String line = in.nextLine();
			if (line.equalsIgnoreCase("Bye")) {
				System.out.println("Bye!");
				break;
			} else if (line.equalsIgnoreCase("learn")) {
				System.out.println("Keyword:");
				String Q = in.nextLine();
				System.out.println("Answer:");
				String A = in.nextLine();
				add(Q, A);
				System.out.println("New dialogue learned!");
			} else {
				ANS.clear();
				String[] s = line.split("\\W+");
				boolean b = false;
				for (String str: s) {
					b = Contains(ans,str,true)||b;
				}
				if (b) {
					System.out.println(ANS.get(r.nextInt(ANS.size())));
				} else {
					System.out.println("I can't catch what you said. Would you mind teach me that? (Try input 'learn')");
				}
			}
		}
		write();
		/*for (HashMap.Entry<String, ArrayList<String>> entry: ans.entrySet()) {
			System.out.println(entry.getKey()+": "+String.join(" / ",entry.getValue()));
		}*/
		in.close();
	}
}
