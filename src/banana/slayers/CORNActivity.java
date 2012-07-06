package banana.slayers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CORNActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void newGame(View view) {
    	Intent i = new Intent(CORNActivity.this, NewGameActivity.class);
    	startActivity(i);
    }
    
    public void loadGame(View view) {
    	Intent i = new Intent(CORNActivity.this, LoadGameActivity.class);
    	startActivity(i);
    }
}