package com.example.statsgaa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
/**
 * contains methods that send queries to the database and return results
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    // sets values for tables, db and columns
    private Context context;
    private static final String DATABASE_NAME = "Stats.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_PLAYERS = "players";
    private static final String COLUMN_ID = "_id";
    private static final String PLAYER_NAME = "player_name";
    private static final String PLAYER_NUMBER = "player_number";
    private static final String PLAYER_SCORES = "player_scores";

    private static final String TABLE_PLAYER_GAME_STAT = "player_game_stat";
    private static final String PLAYER_GAME_STAT_ID = "player_game_stat_id";
    private static final String STAT_ID = "stat_id";
    private static final String MATCH_ID = "game_id";
    private static final String PLAYER_ID = "player_id";
    private static final String TIMESTAMP = "timestamp";

    private static final String TABLE_PLAYER_SQUAD = "player_squad";
    private static final String SQUAD_ID = "squad_id";
//    private static final String SQUAD_NAME = "squad_name";
    private static final String PLAYER1_ID= "player1_id";
    private static final String PLAYER2_ID= "player2_id";
    private static final String PLAYER3_ID = "player3_id";
    private static final String PLAYER4_ID= "player4_id";
    private static final String PLAYER5_ID= "player5_id";
    private static final String PLAYER6_ID = "player6_id";
    private static final String PLAYER7_ID= "player7_id";
    private static final String PLAYER8_ID= "player8_id";
    private static final String PLAYER9_ID = "player9_id";
    private static final String PLAYER10_ID= "player10_id";
    private static final String PLAYER11_ID = "player11_id";
    private static final String PLAYER12_ID= "player12_id";
    private static final String PLAYER13_ID= "player13_id";
    private static final String PLAYER14_ID = "player14_id";
    private static final String PLAYER15_ID = "player15_id";





    /**
     * constructor
     * @param context
     */
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    /**
     * oncreate method -creates tables in the database
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // create table queries
        String createPlayers = "CREATE TABLE IF NOT EXISTS " + TABLE_PLAYERS + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PLAYER_NAME + " TEXT, "
                + PLAYER_NUMBER + " TEXT, "
                + PLAYER_SCORES + " INTEGER);";

        String createMatch = "CREATE TABLE IF NOT EXISTS "+ TABLE_PLAYER_GAME_STAT + " (" + PLAYER_GAME_STAT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + STAT_ID + " INTEGER, "
                + MATCH_ID + " INTEGER, "
                + PLAYER_ID + " INTEGER, "
                + TIMESTAMP + " INTEGER);";

        String createSquad = "CREATE TABLE IF NOT EXISTS "+ TABLE_PLAYER_SQUAD + " (" + SQUAD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                + SQUAD_NAME + " TEXT, "
                + PLAYER1_ID + " INTEGER, "
                + PLAYER2_ID + " INTEGER, "
                + PLAYER3_ID + " INTEGER, "
                + PLAYER4_ID + " INTEGER, "
                + PLAYER5_ID + " INTEGER, "
                + PLAYER6_ID + " INTEGER, "
                + PLAYER7_ID + " INTEGER, "
                + PLAYER8_ID + " INTEGER, "
                + PLAYER9_ID + " INTEGER, "
                + PLAYER10_ID + " INTEGER, "
                + PLAYER11_ID + " INTEGER, "
                + PLAYER12_ID + " INTEGER, "
                + PLAYER13_ID + " INTEGER, "
                + PLAYER14_ID + " INTEGER, "
                + PLAYER15_ID + " INTEGER);";

        db.execSQL(createPlayers);
        db.execSQL(createMatch);
        db.execSQL(createSquad);
    }

    /**
     * drops the table
     * @param db
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYER_GAME_STAT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYER_SQUAD);

        onCreate(db);
    }

    /**
     * adds a new player to the player table
     */
    public void addPlayer(String name, String number, String scores) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(PLAYER_NAME, name);
        cv.put(PLAYER_NUMBER, number);
        cv.put(PLAYER_SCORES, scores);

        long result = db.insert(TABLE_PLAYERS, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed to add player", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Player Added", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * adds a new player to the player table
     */
    public void addMatchEvent(int match_id, int player_id, int stat_id, int timestamp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(MATCH_ID, match_id);
        cv.put(PLAYER_ID, player_id);
        cv.put(STAT_ID, stat_id);
        cv.put(TIMESTAMP, timestamp);

        long result = db.insert(TABLE_PLAYER_GAME_STAT,null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed to add event", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Event Added", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * adds a new squad to the player table
     */
    public void addSquad(int squad_id, String squad_name, int player1_id, int player2_id,int player3_id,
                         int player4_id,int player5_id,int player6_id,int player7_id,int player8_id,
                         int player9_id,int player10_id,int player11_id,int player12_id,int player13_id,
                         int player14_id,int player15_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(SQUAD_ID, squad_id);
//        cv.put(SQUAD_NAME, squad_name);
        cv.put(PLAYER1_ID, player1_id);
        cv.put(PLAYER2_ID, player3_id);
        cv.put(PLAYER4_ID, player4_id);
        cv.put(PLAYER5_ID, player5_id);
        cv.put(PLAYER6_ID, player6_id);
        cv.put(PLAYER7_ID, player7_id);
        cv.put(PLAYER8_ID, player8_id);
        cv.put(PLAYER9_ID, player9_id);
        cv.put(PLAYER10_ID, player10_id);
        cv.put(PLAYER11_ID, player11_id);
        cv.put(PLAYER12_ID, player12_id);
        cv.put(PLAYER13_ID, player13_id);
        cv.put(PLAYER14_ID, player14_id);
        cv.put(PLAYER15_ID, player15_id);

        long result = db.insert(TABLE_PLAYER_GAME_STAT,null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed to add event", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Event Added", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * returns all data in database
     * @return
     */
    public Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_PLAYERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    /**
     * makes updates in the database accordign to user input
     * @param player_id
     * @param name
     * @param number
     * @param scores
     */
    public void updatePlayerName(String player_id, String name, String number , String scores) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(PLAYER_NAME, name);
        cv.put(PLAYER_NUMBER, number);
        cv.put(PLAYER_SCORES, scores);

        long result = db.update(TABLE_PLAYERS, cv, "_id=?", new String[]{player_id});
        if (result == -1) {
            Toast.makeText(context, "Update Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully Updated", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * deletes one record in the database (a player)
     * @param player_id
     */
    public void deleteOnePlayer(String player_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_PLAYERS, "_id=?", new String[]{player_id});

        if (result == -1) {
            Toast.makeText(context, "Deleted Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully Deleted", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * deletes all the players in the database
     */
    public void deleteAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+ TABLE_PLAYERS);
    }
}
