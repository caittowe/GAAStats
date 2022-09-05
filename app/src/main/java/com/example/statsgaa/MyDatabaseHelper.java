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
    public Context context;
    private static final String DATABASE_NAME = "Stats.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_RECORD_STAT = "record_stat";
    private static final String RECORD_STAT_ID = "record_stat_id";
    private static final String STAT_ID = "stat_id";
    private static final String TIMESTAMP = "timestamp";
    private static final String TABLE_SQUAD = "squad";
    private static final String SQUAD_TABLE_ID = "squad_table_id";
    private static final String SQUAD_ID = "squad_id";
    private static final String SQUAD_NAME = "squad_name";
    private static final String PLAYER_NAME = "player_name";
    private static final String PLAYER_NO = "player_no";
    private static final String TABLE_MATCH = "game";
    private static final String MATCH_ID = "game_id";
    private static final String MATCH_NAME = "game_name";
    private static final String TEAM1 = "team1";
    private static final String TEAM2 = "team2";
    private static final String DATE = "date";
    private static final String TIME = "time";
    private static final String LOCATION = "location";
    private static final String TABLE_SCORERS = "scorers";
    private static final String TOP_SCORERS_ID = "scorers_id";
    private static final String GOALS = "goals";
    private static final String POINTS = "points";
    private static final String SCORE_COUNT = "score_count";
    private static final String TABLE_POSSESSION = "possession";
    private static final String POSSESSION_ID = "possession_id";
    private static final String POSSESSION_COUNT = "possession_count";

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

        String createMatch = "CREATE TABLE IF NOT EXISTS " + TABLE_MATCH + " (" + MATCH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MATCH_NAME + " TEXT, "
                + TEAM1 + " TEXT, "
                + TEAM2 + " TEXT, "
                + DATE + " TEXT, "
                + TIME + " TEXT, "
                + LOCATION + " TEXT);";

        String createPlayerGameStat = "CREATE TABLE IF NOT EXISTS " + TABLE_RECORD_STAT + " (" + RECORD_STAT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + STAT_ID + " INTEGER, "
                + MATCH_ID + " INTEGER, "
                + SQUAD_ID + " INTEGER, "
                + PLAYER_NO + " INTEGER, "
                + TIMESTAMP + " TEXT);";

        String createSquad = "CREATE TABLE IF NOT EXISTS " + TABLE_SQUAD + " (" + SQUAD_TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SQUAD_ID + " INTEGER, "
                + SQUAD_NAME + " TEXT, "
                + PLAYER_NAME + " TEXT, "
                + PLAYER_NO + " INTEGER);";

        String createTopScorers = "CREATE TABLE IF NOT EXISTS " + TABLE_SCORERS + " (" + TOP_SCORERS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MATCH_ID + " INTEGER, "
                + PLAYER_NO + " INTEGER, "
                + PLAYER_NAME + " TEXT, "
                + GOALS + " INTEGER, "
                + POINTS + " INTEGER, "
                + SCORE_COUNT + " INTEGER);";

        String createPossession = "CREATE TABLE IF NOT EXISTS " + TABLE_POSSESSION + " (" + POSSESSION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MATCH_ID + " INTEGER, "
                + PLAYER_NO + " INTEGER, "
                + PLAYER_NAME + " TEXT, "
                + POSSESSION_COUNT + " INTEGER);";

        db.execSQL(createSquad);
        db.execSQL(createPlayerGameStat);
        db.execSQL(createMatch);
        db.execSQL(createTopScorers);
        db.execSQL(createPossession);

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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECORD_STAT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SQUAD);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATCH);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POSSESSION);

        onCreate(db);
    }

    /**
     * adds a new stat to the player_match_stat
     */
    public void createNewMatch(String matchName, String team1, String team2, String date, String time, String location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(MATCH_NAME, matchName);
        cv.put(TEAM1, team1);
        cv.put(TEAM2, team2);
        cv.put(DATE, date);
        cv.put(TIME, time);
        cv.put(LOCATION, location);

        long result = db.insert(TABLE_MATCH, null, cv);
        if (result == -1) {
//            Toast.makeText(context, "Failed to add match", Toast.LENGTH_SHORT).show();
        } else {
//            Toast.makeText(context, "Match Added", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * adds a new player to the player table
     */
    public void addPlayersToSquad(String squadID, String squadName, String playerName, String playerNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(SQUAD_ID, squadID);
        cv.put(SQUAD_NAME, squadName);
        cv.put(PLAYER_NAME, playerName);
        cv.put(PLAYER_NO, playerNo);


        long result = db.insert(TABLE_SQUAD, null, cv);
        if (result == -1) {
//            Toast.makeText(context, "Failed to add player", Toast.LENGTH_SHORT).show();
        } else {
//            Toast.makeText(context, "Player Added", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * adds a new stat to the player_match_stat
     */
    public void addMatchEvent(int statID, int matchID, int squadID, int playerNo, String timestamp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(STAT_ID, statID);
        cv.put(MATCH_ID, matchID);
        cv.put(SQUAD_ID, squadID);
        cv.put(PLAYER_NO, playerNo);
        cv.put(TIMESTAMP, timestamp);

        long result = db.insert(TABLE_RECORD_STAT, null, cv);
        if (result == -1) {
//            Toast.makeText(context, "Failed to add event", Toast.LENGTH_SHORT).show();
        } else {
//            Toast.makeText(context, "Event Added", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * Returns the max squad id in the database
     *
     * @return
     */
    public int getMaxSquadID() {
        int maxID = 0;

        String selectQuery = "SELECT " + SQUAD_ID + " FROM " + TABLE_SQUAD;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                maxID = cursor.getInt(0);

            } while (cursor.moveToNext());
        }
        return maxID;
    }

    /**
     * Returns the max squad id in the database
     *
     * @return
     */
    public int getMaxGameID() {
        int maxID = 0;

        String selectQuery = "SELECT " + MATCH_ID + " FROM " + TABLE_MATCH;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                maxID = cursor.getInt(0);

            } while (cursor.moveToNext());
        }
        return maxID;
    }


    /**
     * returns all data in database
     *
     * @return
     */
    public Cursor readAllClickedSquadData(String squadID) {
        String query = "SELECT * FROM " + TABLE_SQUAD + " WHERE squad_id = " + squadID + ";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    /**
     * returns distinct squad ids and names
     *
     * @return
     */
    public Cursor readSquadIDSquadName() {
        String query = "SELECT DISTINCT "+ SQUAD_ID +" , "+ SQUAD_NAME +" FROM " + TABLE_SQUAD;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    /**
     * returns players with a certain squad id
     *
     * @return
     */
    public Cursor readPlayerNamePlayerNo(String squadID) {
        String query = "SELECT "+PLAYER_NO+" , "+PLAYER_NAME +" FROM "+ TABLE_SQUAD +" WHERE "+SQUAD_ID+" = "+squadID + ";";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }


    /**
     * makes updates in the database accordign to user input
     *
     * @param playerName
     */
    public void updatePlayerName(String playerName, String playerNo, String squadID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
//        cv.put(SQUAD_ID, squadID);
        cv.put(PLAYER_NAME, playerName);
//        cv.put(PLAYER_NO, playerNo);
        long result = db.update(TABLE_SQUAD, cv, SQUAD_ID +" = ? AND "+PLAYER_NO +" = ?", new String[]{squadID, playerNo});
        if (result == -1) {
//            Toast.makeText(context, "Update Failed", Toast.LENGTH_SHORT).show();
        } else {
//            Toast.makeText(context, "Successfully Updated", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * deletes one record in the database (a player)
     *
     * @param playerNo
     */
    public void deleteOnePlayer(String playerNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_SQUAD, "player_no=?", new String[]{playerNo});

        if (result == -1) {
//            Toast.makeText(context, "Deleted Failed", Toast.LENGTH_SHORT).show();
        } else {
//            Toast.makeText(context, "Successfully Deleted", Toast.LENGTH_SHORT).show();
        }

    }


    /**
     * deletes a squad from the squad table
     */
    public void deleteSquad() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_SQUAD);
    }


    /**
     * returns stats for a specific player
     *
     * @return
     */
    public int showPlayerStatsCount(String playerNo, String statID, String gameID) {
        int count = 0;
        String query = "SELECT COUNT(squad_id)  FROM "+ TABLE_RECORD_STAT +" WHERE "+ PLAYER_NO + " = " + playerNo + " AND "+ STAT_ID + " = " + statID + " AND "+ MATCH_ID +" = " + gameID + ";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
              count = cursor.getInt(0);

            } while (cursor.moveToNext());
        }
        return count;
    }

    /**
     * adds a new stat to the player_match_stat
     */
    public void addTopScorers(String matchID, String playerNo, String playerName, String goals, String points, String scoreCount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(MATCH_ID, matchID);
        cv.put(PLAYER_NO, playerNo);
        cv.put(PLAYER_NAME, playerName);
        cv.put(GOALS, goals);
        cv.put(POINTS, points);
        cv.put(SCORE_COUNT, scoreCount);

        long result = db.insert(TABLE_SCORERS, null, cv);
        if (result == -1) {
//            Toast.makeText(context, "Failed to add match", Toast.LENGTH_SHORT).show();
        } else {
//            Toast.makeText(context, "Match Added", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * adds a new stat to the player_match_stat
     */
    public void addTopPossessions(String matchID, String playerNo, String playerName, String possessionCount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(MATCH_ID, matchID);
        cv.put(PLAYER_NO, playerNo);
        cv.put(PLAYER_NAME, playerName);
        cv.put(POSSESSION_COUNT, possessionCount);

        long result = db.insert(TABLE_POSSESSION, null, cv);
        if (result == -1) {
//            Toast.makeText(context, "Failed to add possession", Toast.LENGTH_SHORT).show();
        } else {
//            Toast.makeText(context, "Possession Added", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * @param gameID
     */
    public Cursor returnScorersDesc(String gameID) {
        String query = "SELECT DISTINCT "+ PLAYER_NAME + " , "+ PLAYER_NO +" , "+ GOALS +" , "+ POINTS+","+SCORE_COUNT+" FROM "+ TABLE_SCORERS +" WHERE "+ MATCH_ID +" = " + gameID + " ORDER BY "+SCORE_COUNT+" DESC;";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    /**
     * @param gameID
     */
    public Cursor returnPossessionsDesc(String gameID) {
        String query = "SELECT DISTINCT "+PLAYER_NAME+","+PLAYER_NO+","+POSSESSION_COUNT+" FROM "+ TABLE_POSSESSION +" WHERE "+MATCH_ID+" = " + gameID + " ORDER BY "+POSSESSION_COUNT+" DESC;";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

}
