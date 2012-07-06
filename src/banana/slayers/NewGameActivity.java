package banana.slayers;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class NewGameActivity extends Activity {
	Group group;
	ArrayList<Player> playerList;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game);
    }
	
	public void selectQuest(View view) {
		//instantiate game with group with players / create characters for players
		//save players with name, skill
		//save group with name, player ids
		//pass game in intent
	}
}
