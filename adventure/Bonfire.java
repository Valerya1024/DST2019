package adventure;

import java.util.ArrayList;

public class Bonfire {
	public boolean saved;
	public boolean lit;
	public Room inRoom;
	private Player soul = new Player("");
	private ArrayList<Room> rooms = new ArrayList<>();
	private ArrayList<NPC> npcs = new ArrayList<>();
	
	public Bonfire() {
		saved = false;
		lit = false;
	}
	
	public void build(Player player, Item firewood, Item flint) {
		if (player.bag.containsKey(flint.Name)) {
			if (player.Location.Damp) {
				System.out.println("The ground is too damp for a bonfire.");
			} else {
				System.out.println("Bonfire lit\nYou can now [rest] by bonfire");
				player.Location.hasBonfire = true;
				lit = true;
				inRoom = player.Location;
				player.bag.remove(firewood.Name);
			}	
		} else {
			System.out.println("Cannot light bonfire without flint");
		}
	}
	
	public void rest(Player player, ArrayList<Room> rs/*, ArrayList<NPC> ns*/) {
		player.hp = 100;
		rooms.clear();
		npcs.clear();
		try {
			soul = player.clone();
			for (Room r: rs) {
				rooms.add(r.clone());
			}
			System.out.println("Process saved");
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		saved = true;
	}
	
	public void awake(Player player, ArrayList<Room> rs) {
		player.Location = inRoom;
		player.coin = soul.coin;
		player.bag.clear();
		player.bag.putAll(soul.bag);
		player.Atk = soul.Atk;
		player.Dfc = soul.Dfc;
		player.hp = 100;
		for (int i=0; i<rs.size(); i++) {
			rs.get(i).Dark = rooms.get(i).Dark;
			rs.get(i).Direction.clear();
			rs.get(i).Direction.putAll(rooms.get(i).Direction);
			rs.get(i).hasBonfire = rooms.get(i).hasBonfire;
			rs.get(i).hasItem.clear();
			rs.get(i).hasItem.addAll(rooms.get(i).hasItem);
			if (rs.get(i).hasNPC!=null) {
				rs.get(i).hasNPC.Hp = rooms.get(i).hasNPC.Hp;
				rs.get(i).hasNPC.State = rooms.get(i).hasNPC.State;
				rs.get(i).hasNPC.Bond = rooms.get(i).hasNPC.Bond;
				rs.get(i).hasNPC.chated = rooms.get(i).hasNPC.chated;
				rs.get(i).hasNPC.free = rooms.get(i).hasNPC.free;
				rs.get(i).hasNPC.hasItem.clear();
				rs.get(i).hasNPC.hasItem.addAll(rooms.get(i).hasNPC.hasItem);
				rs.get(i).hasNPC.sellItem.clear();
				rs.get(i).hasNPC.sellItem.addAll(rooms.get(i).hasNPC.sellItem);
			}
			rs.get(i).lockedDoor = rooms.get(i).lockedDoor;
			rs.get(i).visited = rooms.get(i).visited;
		}
	}
}
