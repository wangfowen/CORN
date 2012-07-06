package banana.slayers;

import java.util.ArrayList;

public class Group {
	//saved into db
	private int id;
	private String name;
	private ArrayList<Integer> playerIds;
	//not persisted
	private ArrayList<Player> playerList;
	
	public Group(String n, ArrayList<Player> pl) {
		this.name = n;
		this.playerList = new ArrayList<Player>();
		
		for (Player p : pl) {
			this.playerList.add(p);
			this.playerIds.add(p.getId());
		}
	}
	
	public void save() {

	}
}
