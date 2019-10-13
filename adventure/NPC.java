package adventure;

import java.util.HashMap;
import java.util.ArrayList;

public class NPC implements Cloneable {
	public String Name;
	public boolean evil;
	public boolean talk;
	public boolean sell;
	public boolean steal;
	public boolean free;
	public boolean chated;
	public boolean inChat;
	public boolean inBuy;
	public int chatOption;
	public String[] Dialogue = new String[5];
	public String Reject;
	public ArrayList<Item> hasItem = new ArrayList<>();
	public NPC hasNPC;
	public ArrayList<Item> sellItem = new ArrayList<>();
	public int Bond;
	public int State; //2:in Room, 1:follow, 0:dead
	public int Hp;
	public double Atk;
	public HashMap<String,String> Gifts = new HashMap<String,String>();
	
	public NPC(String name, boolean t, String d1, String d2, String d3, String d4, String d5, String r, int c, int b, double atk) {
		Name = name;
		evil = false;
		talk = t;
		steal = false;
		sell = false;
		free = true;
		chated = false;
		inChat = false;
		inBuy = false;
		chatOption = c;
		Dialogue[0] = d1;
		Dialogue[1] = d2;
		Dialogue[2] = d3;
		Dialogue[3] = d4;
		Dialogue[4] = d5;
		Reject = r;
		Bond = b;
		Hp = 100;
		Atk = atk;
		State = 2;
		hasNPC = null;
	}
	
	public void attack(Player player) {
		if (evil) {
			double a = Atk*player.Dfc;
			player.hp -= a;
			System.out.println(Name+" attacks you! [hp -"+a+"]");
		}
	}
	
	public void steal(Player player) {
		if (steal) {
			double a = player.coin*Math.random();
			player.coin -= Math.floor(a);
			System.out.println(Name+" steals "+Math.floor(a)+" coins from you!");
			player.Location.hasNPC = null;
			System.out.println(Name+" runs away!");
		}
	}
	
	public void buy(Player player) {
		System.out.println(Name+": I see. Which of them do you want?");
		int i = 1;
		for (Item item: sellItem) {
			System.out.print("["+i+"] "+item.Name+": "+item.Price+"; ");
			i += 1;
		}
		System.out.println("["+i+"] quit");
		System.out.println("Your coins: "+player.coin);
		inBuy = true;
	}
	
	public void free(Player player) {
		if (free) {
			System.out.println(Name+" is free!");
		} else {
			player.Location.hasNPC = null;
			if (Bond>=100) {
				free = true;
				System.out.println("The dragon flies up to the sky immediately, hovering above the castle.");
			} else {
				player.hp -= Atk*player.Dfc;
				free = true;
				System.out.println("The dragon attacks you as you frees it. Then it flies up to the dusk sky, hovering above the castle.");
			}
		}
	}
	
	public void chat(Player player) {
		if (talk) {
			if (chated) {
				if (Bond>=100) {
					System.out.println(Name+": "+Dialogue[chatOption+2]);
				} else {
					System.out.println(Name+": "+Dialogue[chatOption+1]);
				}
			} else {
				if (chatOption<2) {
					System.out.println(Name+": "+Dialogue[0]);
					chated = true;
				} else {
					System.out.println(Name+": "+Dialogue[0]);
					inChat = true;
				}
			}
		} else {
			System.out.println(Name+": "+Dialogue[0]);
		}
	}
	
	public void Choice(int choice, Player player) {
		if (inBuy) {
			if (choice>0&&choice<=sellItem.size()) {
				if (player.coin>=sellItem.get(choice-1).Price) {
					player.coin -= sellItem.get(choice-1).Price;
					player.bag.put(sellItem.get(choice-1).Name, sellItem.get(choice-1));
					System.out.println("You bought the "+sellItem.get(choice-1).Name+". "+sellItem.get(choice-1).Intro);
					sellItem.remove(choice-1);
					inBuy = false;
				} else {
					System.out.println("Not enough money...");
				}
			} else {
				System.out.println("You decided not to buy anything.");
				inBuy = false;
			}
		} else {
			if (choice<chatOption&&choice>0) {
				System.out.println(Name+": "+Dialogue[choice]);
				player.bag.put(hasItem.get(choice-1).Name,hasItem.get(choice-1));
				System.out.println("You get the "+hasItem.get(choice-1).Name+" from "+Name+". "+hasItem.get(choice-1).Intro);
				chated = true;
				inChat = false;
			} else {
				System.out.println(Name+": "+Dialogue[chatOption]);
				inChat = false;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	protected NPC clone() throws CloneNotSupportedException {
		NPC npc = (NPC) super.clone();
		npc.hasItem = (ArrayList<Item>) hasItem.clone();
		npc.sellItem = (ArrayList<Item>) sellItem.clone();
		return npc;
	}
}
