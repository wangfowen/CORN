package banana.slayers;
import java.util.ArrayList;

public class Group {
	private String name;
	private ArrayList<Player> playerList;
	
	public Group(String n) {
		this.name = n;
		this.playerList = new ArrayList<Player>();
	}
}
