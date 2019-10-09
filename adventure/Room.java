package adventure;

import java.util.HashMap;
import java.util.ArrayList;

public class Room implements Cloneable {
	public String Name;
	public HashMap<String,Room> Direction = new HashMap<>();
	public ArrayList<Item> hasItem;
	public NPC hasNPC;
	public boolean hasBonfire;
	public boolean hasTreasure;
	public boolean lockedDoor;
	public boolean Dark;
	public boolean Damp;
	public boolean visited;
	public String Intro1;
	private String Intro2;
	
	public Room(String name, String intro1, String intro2,ArrayList<Room> r) {
		Name = name;
		hasBonfire = false;
		visited = false;
		Intro1 = intro1;
		Intro2 = intro2;
		lockedDoor = false;
		hasTreasure = false;
		Dark = false;
		Damp = false;
		hasItem = new ArrayList<Item>();
		hasNPC = null;
		r.add(this);
	}
	
	public void callIntro() {
		if (visited) {
			System.out.println(Intro2);
			if (lockedDoor) {
				System.out.println("There's a trapdoor behind the throne. Where can I find the key?");
			}
			if (hasNPC!=null) {
				System.out.println("There's a "+hasNPC.Name+" in the "+Name);
			}
			if (hasTreasure) {
				System.out.println("There is a treasure box.");
			}
			if (Dark) {
				System.out.println("Have to light it up.");
			}
			if (hasBonfire) {
				System.out.println("There's a bonfire. Wanna have a rest?");
			}
		} else {
			System.out.println(Intro1);
		}
	}
	
	public void visit() {
		visited = true;
	}
	
	public void openDoor(Room r, Item key, Player player) {
		if (lockedDoor) {
			if (player.bag.containsKey(key.Name)) {
				player.bag.remove(key.Name);
				lockedDoor = false;
				Direction.put("north", r);
				System.out.println("The trapdoor opens. A narow passage heading north appears");
			} else {
				System.out.println("Cannot open without the key");
			}
		} else {
			System.out.println("You can't find any locked door in the "+Name);
		}
	}
	
	public void follow(Player player) {
		if (hasNPC.State==2) {
			if (hasNPC.Bond<100) {
				System.out.println(hasNPC.Bond);
				System.out.println(hasNPC.Name+" hesitated");
			} else {
				hasNPC.State = 1;
				if (hasNPC.hasNPC!=null) {
					hasNPC.hasNPC.Bond += 50;
				}
				System.out.println(hasNPC.Name+" follows you.");
				hasNPC = null;
			}
		}
	}
	
	public void search(Player player) {
		if (hasItem.size()>0) {
			player.bag.put(hasItem.get(0).Name,hasItem.get(0));
			System.out.println("You find a "+hasItem.get(0).Name+" and put it into your bag. "+hasItem.get(0).Intro);
			hasItem.remove(0);
		} else {
			System.out.println("Nothing is found");
		}
	}
	
	public void light(Player player, Item candle, Item flint, Room r2, Room r3, Room r4, Room r5) {
		if (Dark) {
			if (player.bag.containsKey(candle.Name)) {
				if (player.bag.containsKey(flint.Name)) {
					System.out.println("You light up the Dungeon.");
					player.bag.remove(candle.Name);
					Dark = false;
					Direction.put("north", r2);Direction.put("west", r5);Direction.put("east", r3);Direction.put("south", r4);
				} else {
					System.out.println("You can't light candle without flint.");
				}
			} else {
				System.out.println("You don't have any candle.");
			}
		} else {
			System.out.println("There's enough light.");
		}
	}
	
	@SuppressWarnings("unchecked")
	protected Room clone() throws CloneNotSupportedException {
		Room room = (Room) super.clone();
		room.hasItem = (ArrayList<Item>) hasItem.clone();
		if (hasNPC!=null) {
			room.hasNPC = hasNPC.clone();
		}
		return room;
	}

}
