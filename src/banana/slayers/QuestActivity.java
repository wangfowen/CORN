package banana.slayers;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class QuestActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quest);
	}
	
	public void startGame(View view) {
		//instantiate quest in game with monsters / act
		//pass game in intent
	}
	
	public void loadQuests() {
		//select all ids from quest, load them
	}

}
