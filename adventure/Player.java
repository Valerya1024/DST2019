package adventure;

import java.util.HashMap;

public class Player implements Cloneable {
	public String Name;
	public Room Location;
	public int hp;
	public int Atk;
	public double Dfc;
	public HashMap<String,Item> bag = new HashMap<>(); 
	public int coin;

	public Player(String string) {
		Name = string;
		hp = 100;
		Atk = 20;
		Dfc = 0;
		coin = 50;
	}
	
	public void Attack(NPC npc) {
		if (npc.State==2) {
			npc.Hp -= Atk;
			if (npc.Hp<=0) {
				npc.State = 0;
				if (npc.evil) {
					Location.hasNPC.remove(0);
					Location.hasNPC.add(npc.hasNPC);
					System.out.println("You stab the demon in the heart. He growls, and soon turns to dust. \nThen you saw a maiden with very long gray hair resting on a bed, embracing a cracked shell which resembles an egg. She wears long white robes and a gold crown around her forehead. The fight awakes her from her slumber.\nVoice of owl: Well done, "+Name+". Please [take] her away from the castle...");
				} else {
					System.out.println(npc.Name+" is killed!\n"+npc.Name+"'s belongings are taken by you.");
					for (Item item: npc.sellItem) {
						bag.put(item.Name, item);
					}
					for (Item item: npc.hasItem) {
						bag.put(item.Name, item);
					}
				}

			}
		} else if (npc.State==0) {
			System.out.println(npc.Name+" is dead...");
		}
		if (npc.State==2&&!npc.evil) {
			hp -= npc.Atk*Dfc;
				System.out.println("..."+npc.Name+" attacks back!");
		}
	}
	
	public void checkbag() {
		for (HashMap.Entry<String, Item> entry : bag.entrySet()) {
			System.out.println(entry.getKey()+": "+entry.getValue().Intro);
		}
	}
	
	protected Player clone() throws CloneNotSupportedException {
		Player player = (Player) super.clone();
		player.Location = Location.clone();
		return player;
	}
	
	public String toString() {
		return "HP: "+hp+" COIN: "+coin+" LOC: "+Location.Name;
	}
}
