package adventure;

import java.util.Scanner;
import java.util.ArrayList;

public class Adventure {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Talking owl: Welcome to this castle. What is your name, young man?");
		Player me = new Player(in.nextLine());
		System.out.println("Talking owl: "+me.Name+"... Let me give you some advice: [search] every room in the castle carefully, and ask for [help] if you're confused. If you meet someone unfriendly, try [present] him something he likes first before [attack] him. Here your adventure begins.\nThe owl flies away.\n");
		
		//ROOMS		
		ArrayList<Room> r = new ArrayList<>();
		Room Gate = new Room("gate","You are at the gate of the castle.","Gate",r);
		Room Lobby = new Room("lobby","You enter the lobby. You find the way to north blocked by large stones.","Lobby",r);
		Room Armory = new Room("royal armory","You enter the royal armory. An armored knight stands there, guarding those lethal weapons. He seems to expect a [chat].","Royal armory",r);
		Room Library = new Room("library","You are in a library.","Library",r);
		Room Study = new Room("study","You are in a small study.","Study",r);
		Room Corridor = new Room("open corridor","You walk on an open corridor.","Corridor",r);
		Room ThroneRoom = new Room("throne room","You are in the throne room. You find a locked trapdoor behind the throne.","Throne room",r); ThroneRoom.lockedDoor = true;
		Room Balcony1 = new Room("balcony","You come to a balcony. You can overlook the gate and the moat.","Balcony",r);
		Room BanquetHall = new Room("banquet hall","You are in the banquet hall. There's a pleasant smell in the air. It stirs your appetide.","Banquet hall",r);
		Room Kitchen = new Room("kitchen","You are in the kitchen. An old woman is busy cooking something. Does she mind if you [chat] with her?","Kitchen",r);
		Room ServantR = new Room("servants' rooms","You come to the servants' rooms.","Servants' rooms",r);
		Room GuardR = new Room("guards' rooms","You come to the guards' rooms.","Guards' rooms",r);
		Room Garden1 = new Room("garden","You are in a garden southwest to the castle.","Garden",r);
		Room Garden2 = new Room("garden","You are in a garden west to the castle.","Garden",r);
		Room Garden3 = new Room("garden","You are in a garden northwest to the castle. There're some apple trees.","Garden",r);
		Room Garden4 = new Room("garden","You are in a garden north to the castle. A white dragon rests there with iron chains aroun its neck. Will you [free] it?","Garden",r);
		Room Stable = new Room("stable","You come to the royal stable. A white horse was eating some oats from a manger.","Stable",r);
		Room Garden5 = new Room("garden","You are in a garden east to the castle. It's full of roses.","Garden",r);
		Room Garden6 = new Room("garden","You are in a garden southeast to the castle.","Garden",r);
		Room Tower = new Room("tower","You enter a tower. The way downstairs is blocked by large stones.","Tower",r);
		Room PrincessC = new Room("princess's bedchamber","","Princess's chamber",r);
		Room Balcony2 = new Room("balcony","You come to the princess's balcony.","Balcony",r);
		Room KingC = new Room("king's bedchamber","You are in a large and luxury room. It must be the chamber where the king lived.","King's bedchamber",r);
		Room Dungeon1 = new Room("dungeon","You are in a dark, damp dungeon. Have to light it up.","Dungeon",r);Dungeon1.Dark = true;Dungeon1.Damp=true;
		Room Dungeon2 = new Room("dungeon","You are in a dungeon.It's cold and damp.","Dungeon",r);Dungeon2.Damp=true;
		Room Dungeon3 = new Room("dungeon","Wow! There is a treasure box in the dungeon. It is locked.","Dungeon",r);Dungeon3.hasTreasure = true;Dungeon3.Damp=true;
		Room Dungeon4 = new Room("dungeon","A thief jumped out from the dark!","Dungeon",r);Dungeon4.Damp=true;
		Room Dungeon5 = new Room("dungeon","You are in a dungeon.It's cold and damp.","Dungeon",r);Dungeon5.Damp=true;

		
		//ITEMS
		Item sword = new Item("sword",4,"Good to have a weapon. Better [equip] it now.",0,0,0);sword.Atk=50;
		Item shield = new Item("shield",4,"It's a shield with fancy carvings on it. Better [equip] it now.",0,0,0);shield.Dfc = 0.5;
		Item doorKey = new Item("door key",3,"Maybe you can [use] it to open some door.",0,0,0);
		Item boxKey = new Item("small key",3,"If it can [open] some [treasure box], you'll be rich!",0,0,0);
		Item candle = new Item("candle",3,"Maybe you can [use] it when it's getting dark.",0,0,0); Library.hasItem.add(candle);
		Item firewood = new Item("firewood",3,"You can [use] it to build a bonfire.",0,0,0); Kitchen.hasItem.add(firewood);
		Item flint = new Item("flint",3,"Good for your adventure.",0,0,0); ServantR.hasItem.add(flint);
		Item shovel = new Item("shovel",2,"Maybe you can [use] it to dig out something.",0,0,0); Garden2.hasItem.add(shovel);shovel.effect = Dungeon5; shovel.hasItem = boxKey;
		Item rose = new Item("rose",3,"It's the most beautiful rose you picked from garden",50,0,0);Garden5.hasItem.add(rose);
		Item wine = new Item("wine",1,"Wanna have a drink?",20,20,0);
		Item lemoncake = new Item("lemoncake",1,"It's a freshly baked lemoncake decorated with white cream.",70,50,10);//price
		Item applepie = new Item("apple pie",1,"It's a freshly baked apple pie decorated with jam.",20,50,10);
		Item strawberry = new Item("strawberry cake",1,"It's a freshly baked strawberry cake decorated with red fondant.",30,50,10);
		Item diary = new Item("king's diary",3,"The last page reads: \"Lady Annabel sent a load of lemons from Londor. Ashara can't wait to have some lemoncake. It has been her favorite since she travelled to south with her mother three years ago.\"",30,0,0);Study.hasItem.add(diary);
		Item apple = new Item("apple",1,"It's an juicy apple.",50,10,0);Garden3.hasItem.add(apple);
		Item roast = new Item("roast lamb",1,"A whole roast lamb!",150,80,0);BanquetHall.hasItem.add(roast);
		
		//NPCS
		ArrayList<NPC> n = new ArrayList<>();
		NPC princess = new NPC("Princess",true,"What's going on? I am not leaving. Who are you? ..."+me.Name+"? Where is my father? Where are the others?","I will not go with you. Where can I go?","You are right...We should go now. We can ride my horse. It's in the stable.","","","Well, it's nice, but you will need it more than I do.",0,0,10,n);
		NPC demon = new NPC("Demon",false,"growling","","","","","growling",0,-100,25,n);
		if (Math.random()<0.5) {
			PrincessC.hasNPC.add(princess);
			PrincessC.Intro1 = "You finally reach the princess's chamber. A maiden with very long gray hair rests on a bed while embracing a cracked shell which resembles an egg. She wears long white robes and a gold crown around her forehead. Your apperance awakes her from her slumber.\nVoice of owl: "+me.Name+"... [take] the princess, and run away...";
		} else {
			PrincessC.hasNPC.add(demon);
			PrincessC.Intro1 = "You finally reach the princess's chamber. A red-eyed demon awaits you...";
		}
		NPC granny = new NPC("Old woman",true,"Haven't seen a soul for a century. I used to be the cook here. Traveller, would you like some wine?\nOption: [1]Yes [2]No","You gave an old woman a little moment of joy...Do you like those desserts on the table? You may have one...But please leave some money to poor old granny. \n[buy]","I see... You can come to me when you change your mind. What about those desserts on the table? You may have one...But please leave some money to poor old granny.\n[buy]","Would you like some dessert?\n[buy]","","Ha! Men sent me gifts when I was young. Keep this to yourself, traveller.",2,10,5,n);Kitchen.hasNPC.add(granny);
		NPC dragon = new NPC("White dragon",false,"deep roar","","","","","deep roar",0,-50,50,n);Garden4.hasNPC.add(dragon);
		NPC thief = new NPC("Thief",false,"","","","","","",0,-100,20,n);Dungeon4.hasNPC.add(thief);
		NPC knight = new NPC("Old knight",true,"Are you here for the princess? She can't be alive. If you still want to find her, at least keep one of these.\nOption: [1]Sword [2]Shield [3]Thanks, but I can't accept that","Attack is better defense.","Defense is as important as attack.","Well, that's my gift. You may come and fetch it when you need it.","I used to be a member of King's closest Body Guard. My weapons...were the king's gifts. Use it well.","Keep it to yourself, young man.",3,10,200,n);Armory.hasNPC.add(knight);
		NPC horse = new NPC("White horse",false,"neighing","","","","","whinnying",0,0,20,n);Stable.hasNPC.add(horse);
		demon.hasNPC = princess; princess.hasNPC = horse;
		demon.evil = true; granny.sell = true; dragon.free = false; thief.steal = true; thief.evil = true;
		princess.Gifts.put("rose", "She blushes and smiles.");
		princess.Gifts.put("wine", "She accepts the wine, but takes only a sip.");
		princess.Gifts.put("lemoncake", "Her face lit up.");
		princess.Gifts.put("apple pie", "She accepts the apple pie, but did not eat it. Isn't she hungry?");
		princess.Gifts.put("strawberry cake", "She seems happy and eats it immediately after expressing her gratitude.");
		princess.Gifts.put("king's diary", "She holds the diary silently, with tears in her eyes.");
		dragon.Gifts.put("roast", "It eats the whole lamb leg in one swallow.");
		horse.Gifts.put("apple", "It eats the apple in your hand.");
		granny.sellItem.add(strawberry);granny.sellItem.add(applepie);granny.sellItem.add(lemoncake);granny.hasItem.add(wine);
		knight.hasItem.add(sword);knight.hasItem.add(shield);
		
		Bonfire bonfire = new Bonfire();
		TreasureBox treasure = new TreasureBox(1000,boxKey,doorKey);
		Gate.Direction.put("north",Lobby);Gate.Direction.put("west",Garden1);Gate.Direction.put("east",Garden6);
		Lobby.Direction.put("west", BanquetHall);Lobby.Direction.put("east", Armory);Lobby.Direction.put("up", ThroneRoom);Lobby.Direction.put("south", Gate);
		Armory.Direction.put("west", Lobby);Armory.Direction.put("east", Garden5);Armory.Direction.put("north", Study);Armory.Direction.put("up", Library);
		BanquetHall.Direction.put("east", Lobby);BanquetHall.Direction.put("north", Kitchen);BanquetHall.Direction.put("west", Garden2);
		Kitchen.Direction.put("south", BanquetHall);Kitchen.Direction.put("up", ServantR);Kitchen.Direction.put("east", Corridor);
		Corridor.Direction.put("north", Garden4);Corridor.Direction.put("west", Kitchen);Corridor.Direction.put("east", Study);
		Study.Direction.put("west", Corridor);Study.Direction.put("south", Armory);Library.Direction.put("down", Armory);
		ServantR.Direction.put("down", Kitchen);ServantR.Direction.put("south", GuardR);GuardR.Direction.put("north", ServantR);
		ThroneRoom.Direction.put("down", Lobby);ThroneRoom.Direction.put("south", Balcony1);Balcony1.Direction.put("north", ThroneRoom);
		Tower.Direction.put("up", PrincessC);Tower.Direction.put("south", ThroneRoom);Tower.Direction.put("east", KingC);KingC.Direction.put("west", Tower);
		PrincessC.Direction.put("down", Tower);PrincessC.Direction.put("south", Balcony2);Balcony2.Direction.put("north", PrincessC);
		Garden1.Direction.put("east", Gate);Garden1.Direction.put("north", Garden2);
		Garden2.Direction.put("east", BanquetHall);Garden2.Direction.put("north", Garden3);Garden2.Direction.put("south", Garden1);
		Garden3.Direction.put("east", Garden4);Garden3.Direction.put("south", Garden2);
		Garden4.Direction.put("east", Stable);Garden4.Direction.put("south", Corridor);Garden4.Direction.put("west", Garden3);
		Stable.Direction.put("west", Garden4);Stable.Direction.put("south", Garden5);
		Garden5.Direction.put("west",Armory);Garden5.Direction.put("south", Garden6);Garden5.Direction.put("north", Stable);
		Garden6.Direction.put("west",Gate);Garden6.Direction.put("north",Garden5);
		Stable.Direction.put("down",Dungeon1);
		Dungeon1.Direction.put("up",Stable);Dungeon2.Direction.put("south",Dungeon1);Dungeon4.Direction.put("north",Dungeon1);Dungeon5.Direction.put("east",Dungeon1);Dungeon3.Direction.put("west",Dungeon1);
		me.Location = Gate;
		me.Location.callIntro();
		System.out.println("HP: 100 Directions: [go] [east west north]");
		me.Location.visit();
		while (true) {
			if (princess.State==1) {
				if (me.Location.equals(Balcony2)&&dragon.Bond>=100) {
					System.out.println("The white dragon flies down to the balcony...\nThe princess and you mount the dragon and fly to the south.\n...\nTHE END");
					break;
				} else if (me.Location.equals(Gate)) {
					if (horse.State==1) {
						System.out.println("The princess and you ride through the gate and escaped the castle...\n...\nTHE END");
						break;
					} else {
						if (demon.State!=0) {
							System.out.println("The princess and you walk through the gate and escaped the castle...\n...\nTHE END");
						} else {
							System.out.println("The princess and you walk through the gate to the bridge over the moat. All of a sudden, the bridge collapsed...\nVoice of owl: It's the demon...He would not let the princess leave...");
							me.hp = 0;
						}
					}
				}
			}
			if (me.hp <= 0) {
				System.out.println("YOU DIED");
				if (bonfire.saved) {
					bonfire.awake(me,r,n);
					System.out.println("\n...\n\nYou wake up by the bonfire. What just happened? ...");
					System.out.println("HP: "+me.hp+"  Directions: ["+String.join(" ", me.Location.Direction.keySet())+"]");
				} else {
					System.out.println("\nAhhh...like many others, you failed...");
					break;
				}
			}
			String act = in.nextLine();
			String[] action = act.split(" ",2);
			if (me.Location.hasNPC.size()==1&&(me.Location.hasNPC.get(0).inChat||me.Location.hasNPC.get(0).inBuy)) {
				try {
					int choice = Integer.parseInt(action[0]);
					me.Location.hasNPC.get(0).Choice(choice, me);
				} catch (NumberFormatException err) {
					System.out.println(me.Location.hasNPC.get(0).Name+": What are you talking about?");
				}
				System.out.println("HP: "+me.hp+"  Directions: ["+String.join(" ", me.Location.Direction.keySet())+"]");
			} else {
				if (action[0].equals("leave")){
					System.out.println("Voice of owl: Farewell...");
					break;
				} else if (action[0].equals("equip")) {
					try {
						if (me.bag.containsKey(action[1])) {
							me.bag.get(action[1]).equip(me);
						} else {
							System.out.println("Cannot find that in your bag!");
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("What do you want to equip?");
					}
				} else if (action[0].equals("help")) {
					System.out.println("Command:\n1.go +direction\n2.use +item\n3.equip +item\n4.eat(or drink) +item\n5.present +item (present item to local npc)\n6.search (search current room)\n7.rest (rest by bonfire)\n8.chat (chat with local npc)\n9.buy (buy from local npc)\n10.take (take the local npc)\n11.free (free the local npc)\n12.attack (attack the local npc)\n13.check (check iems in bag)\n14.leave (leave castle and quit game)");
				} else if (action[0].equals("go")) {
					try {
						String dir = action[1];
						if (me.Location.hasNPC.size()==1&&me.Location.hasNPC.get(0).evil) {
							System.out.println(me.Location.hasNPC.get(0).Name+"stopped you from escape!");
						} else {
							if (me.Location.Direction.containsKey(dir)) {
								me.Location = me.Location.Direction.get(dir);
								me.Location.callIntro();
								me.Location.visit();
							} else {
								me.hp -= 1;
								System.out.println("You feel lost in this castle...[hp -1]");
							}
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Which direction do you want to go?");
					}
				} else if (action[0].equals("search")) {
					me.Location.search(me);
				} else if (action[0].equals("eat")||action[0].equals("drink")) {
					try {
						if (me.bag.containsKey(action[1])) {
							me.bag.get(action[1]).eat(me);
						} else {
							System.out.println("You can't find this in your bag!");
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("What do you want to have?");
					}
				} else if (action[0].equals("use")) {
					try {
						if (action[1].equals("candle")) {
							me.Location.light(me, candle, flint, Dungeon2, Dungeon3, Dungeon4, Dungeon5);
						} else if (action[1].equals("firewood")) {
							bonfire.build(me, firewood, flint);
						} else if (action[1].equals("small key")) {
							if (me.Location.hasTreasure) {
								treasure.open(me);
							} else {
								System.out.println("You can't find any treasure box here.");
							}
						} else if (action[1].equals("door key")) {
							me.Location.openDoor(Tower, doorKey, me);
						} else {
							if (me.bag.containsKey(action[1])) {
								me.bag.get(action[1]).use(me);
							} else {
								System.out.println("You can't find this in your bag!");
							}
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("What to use?");
					}
				} else if (action[0].equals("present")) {
					try {
						if (me.bag.containsKey(action[1])) {
							if (me.Location.hasNPC.size()==1) {
								me.bag.get(action[1]).present(me.Location.hasNPC.get(0), me);								
							} else {
								System.out.println("No others here to send a present to.");
							}
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("What to present?");
					}
				} else if (action[0].equals("rest")) {
					if (me.Location.hasBonfire) {
						bonfire.rest(me,r,n);
					} else {
						System.out.println("You have to rest by a bonfire.");
					}
				} else if (action[0].equals("chat")) {
					if (me.Location.hasNPC.size()==1) {
						me.Location.hasNPC.get(0).chat(me);
					} else {
						System.out.println("Voice of owl: Are you talking to me?");
					}
				} else if (action[0].equals("take")) {
					if (me.Location.hasNPC.size()==1) {
						me.Location.hasNPC.get(0).follow(me);
					} else {
						System.out.println("There are not any others.");
					}
				} else if (action[0].equals("buy")) {
					if (me.Location.hasNPC.size()==1) {
						me.Location.hasNPC.get(0).buy(me);					
					}
				} else if (action[0].equals("free")) {
					if (me.Location.hasNPC.size()==1) {
						me.Location.hasNPC.get(0).free(me);
					} else {
						System.out.println("There are not any others.");
					}
				} else if (action[0].equals("attack")) {
					if (me.Location.hasNPC.size()==1) {
						me.Attack(me.Location.hasNPC.get(0));
					} else {
						if (me.bag.containsKey("sword")) {
							System.out.println("Voice of owl: Why are you waving your blade in the air?");
						} else {
							System.out.println("Voice of owl: Why are you waving your fists in the air?");
						}
					}
				} else if (action[0].equals("check")) {
					me.checkbag();
				} else {
					me.hp -= 1;
					System.out.println("You feel confused about what to do...[hp - 1]");
				}
				if (me.Location.hasNPC.size()==1) {
					me.Location.hasNPC.get(0).attack(me);
					me.Location.hasNPC.get(0).steal(me);
				}
				if (!(me.Location.hasNPC.size()==1&&(me.Location.hasNPC.get(0).inChat||me.Location.hasNPC.get(0).inBuy))) {
					System.out.println("HP: "+me.hp+"  Directions: ["+String.join(" ", me.Location.Direction.keySet())+"]");
				}
			}
		}
		in.close();
	}
}
