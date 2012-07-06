package banana.slayers;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class LoadGameActivity extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_game);
    }
	
	public void selectQuest(View view) {
		//instantiate game with group with players / create characters for players
		//pass game in intent
	}
	
	public void loadGroups() {
		//select all ids from group, load them
	}
}
