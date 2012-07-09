package banana.slayers;

import java.util.ArrayList;

public class Player {
	//saved into db
	private int id;
	private String name;
	//not persisted
	private ArrayList<Item> itemList;
	private Character character;
	
	public Player(String n, Skill s) {
		this.name = n;
		this.character = new Character(s);
	}
	
	public int getId() {
		return this.id;
	}
}
