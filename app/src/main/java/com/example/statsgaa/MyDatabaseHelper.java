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

    private static final String TABLE_PLAYER_GAME_STAT = "player_game_stat";
    private static final String PLAYER_GAME_STAT_ID = "player_game_stat_id";
    private static final String STAT_ID = "stat_id";
    private static final String MATCH_ID = "game_id";
    //    private static final String PLAYER_NO = "player_no";
    private static final String TIMESTAMP = "timestamp";

    private static final String TABLE_SQUAD = "squad";
    private static final String SQUAD_TABLE_ID = "squad_table_id";
    private static final String SQUAD_ID = "squad_id";
    private static final String SQUAD_NAME = "squad_name";
    private static final String PLAYER_NAME = "player_name";
    private static final String PLAYER_NO = "player_no";

    /**
     * constructor
     *
     * @param context
     */
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    /**
     * oncreate method -creates tables in the database
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        String createPlayerGameStat = "CREATE TABLE IF NOT EXISTS " + TABLE_PLAYER_GAME_STAT + " (" + PLAYER_GAME_STAT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + STAT_ID + " INTEGER, "
                + MATCH_ID + " INTEGER, "
                + PLAYER_NO + " INTEGER, "
                + TIMESTAMP + " INTEGER);";

        String createSquad = "CREATE TABLE IF NOT EXISTS " + TABLE_SQUAD + " (" + SQUAD_TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SQUAD_ID + " INTEGER, "
                + SQUAD_NAME + " TEXT, "
                + PLAYER_NAME + " TEXT, "
                + PLAYER_NO + " INTEGER);";

        db.execSQL(createSquad);
        db.execSQL(createPlayerGameStat);
    }

    /**
     * drops the table
     *
     * @param db
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYER_GAME_STAT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SQUAD);

        onCreate(db);
    }

    /**
     * adds a new player to the player table
     */
    public void addPlayersToSquad(String squad_id, String squad_name, String player_name, String player_no) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(SQUAD_ID, squad_id);
        cv.put(SQUAD_NAME, squad_name);
        cv.put(PLAYER_NAME, player_name);
        cv.put(PLAYER_NO, player_no);


        long result = db.insert(TABLE_SQUAD, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed to add player", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Player Added", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * adds a new stat to the player_match_stat
     */
    public void addMatchEvent(int match_id, int player_no, int stat_id, int timestamp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(MATCH_ID, match_id);
        cv.put(PLAYER_NO, player_no);
        cv.put(STAT_ID, stat_id);
        cv.put(TIMESTAMP, timestamp);

        long result = db.insert(TABLE_PLAYER_GAME_STAT, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed to add event", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Event Added", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * Returns the max squad id in the database
     * @return
     */
    public int getMaxID(){
        int maxID = 0;

        String selectQuery = "SELECT "+SQUAD_ID +" FROM " + TABLE_SQUAD;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do{
                maxID = cursor.getInt(0);

            }while(cursor.moveToNext());
        }
        return maxID;
    }


        /**
         * returns all data in database
         * @return
         */
        public Cursor readAllSquadData () {
            String query = "SELECT * FROM " + TABLE_SQUAD;
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            if (db != null) {
                cursor = db.rawQuery(query, null);
            }
            return cursor;
        }

    /**
     * returns all data in database
     * @return
     */
    public Cursor readAllClickedSquadData (String squad_id) {
        String query = "SELECT * FROM " + TABLE_SQUAD + " WHERE squad_id = "+ squad_id +";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

        /**
         * returns distinct squad ids and names
         * @return
         */
        public Cursor readSquadIDSquadName() {
            String query = "SELECT DISTINCT squad_id, squad_name  FROM " + TABLE_SQUAD;
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            if (db != null) {
                cursor = db.rawQuery(query, null);
            }
            return cursor;
        }

    /**
     * returns players with a certain squad id
     * @return
     */
    public Cursor readPlayerNamePlayerID(String squad_id) {
        String query = "SELECT player_no, player_name  FROM squad WHERE squad_id ="+squad_id+";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }



    /**
         * makes updates in the database accordign to user input
         * @param player_name
         */
        public void updatePlayerName (String player_name, String player_no){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(PLAYER_NAME, player_name);

            long result = db.update(TABLE_SQUAD, cv, "player_no=?", new String[]{player_no});
            if (result == -1) {
                Toast.makeText(context, "Update Failed", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Successfully Updated", Toast.LENGTH_SHORT).show();
            }
        }

        /**
         * deletes one record in the database (a player)
         * @param player_no
         */
        public void deleteOnePlayer (String player_no){
            SQLiteDatabase db = this.getWritableDatabase();
            long result = db.delete(TABLE_SQUAD, "player_no=?", new String[]{player_no});

            if (result == -1) {
                Toast.makeText(context, "Deleted Failed", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Successfully Deleted", Toast.LENGTH_SHORT).show();
            }

        }


        /**
         * deletes a squad from the squad table
         */
        public void deleteSquad () {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM " + TABLE_SQUAD);
        }
    }
