package adventure;

public class TreasureBox {
	private int x;
	private Item key;
	private Item a;
	private boolean open;
	
	public TreasureBox(int y, Item k, Item b) {
		x=y;
		key=k;
		a=b;
		open=false;
	}
	
	public void open(Player player) {
		if (open) {
			System.out.println("Treasure box has been opened");
		} else {
			if (player.bag.containsKey(key.Name)) {
				player.bag.remove(key.Name);
				open = true;
				player.bag.put(a.Name,a);
				player.coin += x;
				System.out.println("You get "+x+" coins and a "+a.Name+". "+a.Intro);
			} else {
				System.out.println("Cannot open without the key");
			}
		}
	}
	
}
