package banana.slayers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	public static final String DATABASE_NAME = "corn.db";
	public static final int DATABASE_VERSION = 1;
	
	public static final String GROUPS_TABLE = "Groups";
	public static final String PLAYERS_TABLE = "Players";
	public static final String ITEMS_TABLE = "Items";
	public static final String QUESTS_TABLE = "Quests";
	public static final String ACTS_TABLE = "Acts";
	public static final String UNITS_TABLE = "Units";
	public static final String SKILLS_TABLE = "Skills";
	
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_NAME = "name";
	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + GROUPS_TABLE + "(" +
				COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				COLUMN_NAME + " TEXT NOT NULL);");
		
		db.execSQL("CREATE TABLE " + PLAYERS_TABLE + "(" +
				COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				COLUMN_NAME + " TEXT NOT NULL);");
		
		db.execSQL("CREATE TABLE Routing_GroupsPlayers(" +
				COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"group_id INTEGER NOT NULL," +
				"FOREIGN KEY (group_id) REFERENCES " + GROUPS_TABLE + "(id)," +
				"player_id INTEGER NOT NULL," +
				"FOREIGN KEY (player_id) REFERENCES " + PLAYERS_TABLE + "(id));");
		
		db.execSQL("CREATE TABLE " + ITEMS_TABLE + "(" +
				COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				COLUMN_NAME + " TEXT NOT NULL," +
				"atk INTEGER," +
				"mys INTEGER," +
				"def INTEGER," +
				"weight REAL," +
				"effect TEXT);");
		
		db.execSQL("CREATE TABLE Routing_PlayersItems(" +
				COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"player_id INTEGER NOT NULL," +
				"FOREIGN KEY (player_id) REFERENCES " + PLAYERS_TABLE + "(id)," +
				"item_id INTEGER NOT NULL," +
				"FOREIGN KEY (item_id) REFERENCES " + ITEMS_TABLE + "(id));");
		
		db.execSQL("CREATE TABLE " + QUESTS_TABLE + "(" +
				COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				COLUMN_NAME + " TEXT NOT NULL," +
				"story TEXT);");
		
		db.execSQL("CREATE TABLE " + ACTS_TABLE + "(" +
				COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"act_number INTEGER NOT NULL," +
				"story TEXT);");
		
		db.execSQL("CREATE TABLE Routing_QuestsActs(" +
				COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"quest_id INTEGER NOT NULL," +
				"FOREIGN KEY (quest_id) REFERENCES " + QUESTS_TABLE + "(id)," +
				"act_id INTEGER NOT NULL," +
				"FOREIGN KEY (act_id) REFERENCES " + ACTS_TABLE + "(id));");
		
		db.execSQL("CREATE TABLE " + UNITS_TABLE + "(" +
				COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				COLUMN_NAME + " TEXT NOT NULL," +
				"hp INTEGER," +
				"atk INTEGER," +
				"mys INTEGER," +
				"def INTEGER," +
				"mob INTEGER," +
				"given_exp INTEGER);");
		
		db.execSQL("CREATE TABLE Routing_ActsUnits(" +
				COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"act_id INTEGER NOT NULL," +
				"FOREIGN KEY (act_id) REFERENCES " + ACTS_TABLE + "(id)," +
				"unit_id INTEGER NOT NULL," +
				"FOREIGN KEY (unit_id) REFERENCES " + UNITS_TABLE + "(id));");
		
		db.execSQL("CREATE TABLE Routing_UnitsItems(" +
				COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"unit_id INTEGER NOT NULL," +
				"FOREIGN KEY (unit_id) REFERENCES Units(id)," +
				"item_id INTEGER NOT NULL," +
				"FOREIGN KEY (item_id) REFERENCES Items(id));");
		
		db.execSQL("CREATE TABLE " + SKILLS_TABLE + "(" +
				COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				COLUMN_NAME + " TEXT NOT NULL," +
				"cooldown REAL," +
				"effect TEXT);");
		
		db.execSQL("CREATE TABLE Routing_UnitsSkills(" +
				COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"unit_id INTEGER NOT NULL," +
				"FOREIGN KEY (unit_id) REFERENCES " + UNITS_TABLE + "(id)," +
				"skill_id INTEGER NOT NULL," +
				"FOREIGN KEY (skill_id) REFERENCES " + SKILLS_TABLE + "(id));");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DatabaseHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + GROUPS_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + PLAYERS_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + ITEMS_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + QUESTS_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + ACTS_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + UNITS_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + SKILLS_TABLE);
		onCreate(db);
	}
	
	@Override
	public void onOpen(SQLiteDatabase db) {
	    super.onOpen(db);
	    if (!db.isReadOnly()) {
	        // Enable foreign key constraints
	        db.execSQL("PRAGMA foreign_keys=ON;");
	    }
	}

}
