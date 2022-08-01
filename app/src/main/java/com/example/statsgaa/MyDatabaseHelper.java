package com.example.statsgaa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Point;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 *
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Stats.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_PLAYER = "player";
//    private static final String TABLE_STAT = "stat";
//    private static final String TABLE_PLAYER_STAT = "player_stat";
    private static final String PLAYER_PK = "player_id";
//    private static final String STAT_PK = "stat_id";
//    private static final String PLAYER_STAT_PK = "player_stat_id";
    private static final String PLAYER_COLUMN_NAME = "player_name";
    private static final String PLAYER_COLUMN_POINTS = "player_points";
//    private static final String STAT_COLUMN = "stat_name";
//    private static final String PLAYER_STAT_COLUMN = "stat_count";

    private static final String CREATE_TABLE_PLAYER = "CREATE TABLE "
            + TABLE_PLAYER + "(" + PLAYER_PK
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + PLAYER_COLUMN_NAME + " TEXT," + PLAYER_COLUMN_POINTS
            + " INTEGER);";

//    private static final String CREATE_TABLE_STAT = "CREATE TABLE "
//            + TABLE_STAT + "(" + STAT_PK
//            + " INTEGER PRIMARY KEY AUTOINCREMENT," + STAT_COLUMN + " TEXT );";
//
//    private static final String CREATE_TABLE__PLAYER_STAT = "CREATE TABLE "
//            + TABLE_PLAYER_STAT + "(" + PLAYER_STAT_PK
//            + " INTEGER PRIMARY KEY AUTOINCREMENT," + PLAYER_STAT_COLUMN + " TEXT );";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    /**
     * Creates new tables in the database
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PLAYER);
//        db.execSQL(CREATE_TABLE_STAT);
//        db.execSQL(CREATE_TABLE__PLAYER_STAT);

    }

    /**
     * Drops tables in database
     *
     * @param db
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYER);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STAT);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYER_STAT);
        onCreate(db);
    }

    public Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_PLAYER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    /**
     * adds a new player to the database
     */
    public void addPlayer(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(PLAYER_COLUMN_NAME, name);
       // cv.put(PLAYER_COLUMN_POINTS, 0);

        long result = db.insert(TABLE_PLAYER, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed to add Player", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Player Added", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * Updates player nam
     * @param
     * @return
     */
    public void updatePlayer(int player_id, String player_name, String player_points) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(PLAYER_COLUMN_NAME, player_name);
        cv.put(PLAYER_COLUMN_POINTS, player_points);

        long result = db.update(TABLE_PLAYER, cv, "_id=?", new String[] { String.valueOf(PLAYER_PK) });
        if (result == -1) {
            Toast.makeText(context, "Update Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully Updated", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * gets player score
     * @param player_id
     * @return
     */
    public int getScore (int player_id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM LIST WHERE player_id ='"+player_id+"'", null);

        if (cursor !=null) { cursor.moveToFirst(); }

        int output = cursor.getInt(2);

        return output;
    }

    /**
     * adds 1 point to database
     */
    public void addPoint(int player_id, String name, int player_points) {
        SQLiteDatabase db = this.getWritableDatabase();
        int pointValue = 1;
        int playerScore = getScore(player_id);
        int newScore = playerScore+pointValue;

        ContentValues cv = new ContentValues();
        cv.put(PLAYER_COLUMN_POINTS, newScore); //These Fields should be your String values of actual column names

        db.update(PLAYER_COLUMN_POINTS, cv, "player_id = ?", new String[]{String.valueOf(player_id)});

        long result = db.insert(TABLE_PLAYER, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed to add point", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Point Added", Toast.LENGTH_SHORT).show();
        }

        db.close();

    }

    /**
     * deletes one row in the table
     * @param player_id
     */
    public void deleteOneRow(int player_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_PLAYER, "player_id=?", new String[] { String.valueOf(player_id) });

        if (result == -1) {
            Toast.makeText(context, "Deleted Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully Deleted", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * deletes all data from table
     */
    public void deleteAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_PLAYER);
    }
}
