package adventure;

public class Item {
	public String Name;
	public int Kind;//1:edible, 2:get another item, 3:others, 4:weapons
	public String Intro;
	public int BOND;
	public int Hp;
	public int Price;
	public int Atk;
	public double Dfc;
	public Room effect;
	public Item hasItem;
	
	public Item(String name, int kind, String intro, int bond, int hp, int price) {
		Name = name;
		Kind = kind;
		Intro = intro;
		BOND = bond;
		Hp = hp;
		Price = price;
		Atk = 0;
		Dfc = 0;
	}
	
	public void present(NPC npc, Player player) {
		if (npc.Gifts.containsKey(Name)) {
			player.bag.remove(Name);
			npc.Bond += BOND;
			System.out.println(npc.Gifts.get(Name));
		} else {
			System.out.println(npc.Reject);
		}
	}
	
	public void equip(Player player) {
		if (Kind==4) {
			player.Atk = Atk;
			player.Dfc = Dfc;
			System.out.println("You have equipped the "+Name);
		} else {
			System.out.println("You can't equip this!");
		}
	}
	
	public void eat(Player player) {
		if (Kind==1) {
			player.hp += Hp;
			if (player.hp>100) {
				player.hp = 100;
			}
			player.bag.remove(Name);
			System.out.println("You had the "+Name +". Hp +"+Hp);
		} else {
			System.out.println("You really wanna eat this?");
		}
	}
	
	public void use(Player player) {
		if (Kind==2) {
			if (player.Location.equals(effect)) {
				player.bag.put(hasItem.Name, hasItem);
				System.out.println("You get a "+hasItem.Name+"! "+hasItem.Intro);
			} else {
				System.out.println("You get nothing...");
			}
		} else {
			System.out.println("You need to come up with a specific way to use this \n"+Intro);
		}
	}
	
}