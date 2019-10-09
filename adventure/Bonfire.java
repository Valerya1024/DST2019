package adventure;

import java.util.ArrayList;

public class Bonfire {
	public boolean saved;
	private Player soul = new Player("");
	private ArrayList<Room> rooms = new ArrayList<>();
	private ArrayList<NPC> npcs = new ArrayList<>();
	
	public Bonfire() {
		saved = false;
	}
	
	public void build(Player player, Item firewood, Item flint) {
		if (player.bag.containsKey(firewood.Name)) {
			if (player.bag.containsKey(flint.Name)) {
				if (player.Location.Damp) {
					System.out.println("The ground is too damp for a bonfire.");
				} else {
					System.out.println("Bonfire lit\nYou can now [rest] by bonfire");
					player.Location.hasBonfire = true;
					player.bag.remove(firewood.Name);
				}
				
			} else {
				System.out.println("Cannot light bonfire without flint");
			}
		} else {
			System.out.println("Cannot build bonfire without firewood");
		}
	}
	
	public void rest(Player player, ArrayList<Room> rs, ArrayList<NPC> ns) {
		player.hp = 100;
		rooms.clear();
		npcs.clear();
		try {
			soul = player.clone();
			for (Room r: rs) {
				rooms.add(r.clone());
			for (NPC npc: ns) {
				npcs.add(npc.clone());
			}
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		saved = true;
	}
	
	public void awake(Player player, ArrayList<Room> rs, ArrayList<NPC> ns) {
		player.Location = soul.Location;
		player.coin = soul.coin;
		player.bag = soul.bag;
		player.Atk = soul.Atk;
		player.Dfc = soul.Dfc;
		player.hp = 100;
		for (int i=0; i<rs.size(); i++) {
			rs.get(i).Dark = rooms.get(i).Dark;
			rs.get(i).Direction = rooms.get(i).Direction;
			rs.get(i).hasBonfire = rooms.get(i).hasBonfire;
			rs.get(i).hasItem = rooms.get(i).hasItem;
			rs.get(i).hasNPC = rooms.get(i).hasNPC;
			rs.get(i).lockedDoor = rooms.get(i).lockedDoor;
			rs.get(i).visited = rooms.get(i).visited;
		for (int l=0; l<ns.size(); l++) {
			ns.get(l).Bond = npcs.get(l).Bond;
			ns.get(l).chated = npcs.get(l).chated;
			ns.get(l).hasItem = npcs.get(l).hasItem;
			ns.get(l).State = npcs.get(l).State;
			ns.get(l).Hp = npcs.get(l).Hp;
		}
		}
	}
}
