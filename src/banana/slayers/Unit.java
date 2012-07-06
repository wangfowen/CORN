package banana.slayers;

import java.util.ArrayList;

public class Unit {
	private ArrayList<Skill> skillList;
	
	public Unit() {
		this.skillList = new ArrayList<Skill>();
	}
	
	public Unit(Skill s) {
		this.skillList = new ArrayList<Skill>();
		this.skillList.add(s);
	}
}
