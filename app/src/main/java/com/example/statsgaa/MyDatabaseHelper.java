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
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "players";
    private static final String COLUMN_ID = "_id";
    private static final String PLAYER_NAME = "player_name";
    private static final String PLAYER_NUMBER = "player_number";
    private static final String PLAYER_SCORES = "player_scores";

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
        // create table query
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PLAYER_NAME + " TEXT,"
                + PLAYER_NUMBER + " TEXT, "
                + PLAYER_SCORES + " INTEGER);";

        db.execSQL(query);

    }

    /**
     * drops the table
     * @param db
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /**
     * adds a new player to the player table
     */
    public void addBook(String name, String number, String scores) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(PLAYER_NAME, name);
        cv.put(PLAYER_NUMBER, number);
        cv.put(PLAYER_SCORES, scores);

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed to add player", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Player Added", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * returns all data in database
     * @return
     */
    public Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
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
    public void updateData(String player_id, String name, String number , String scores) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(PLAYER_NAME, name);
        cv.put(PLAYER_NUMBER, number);
        cv.put(PLAYER_SCORES, scores);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{player_id});
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
    public void deleteOneRow(String player_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{player_id});

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
        db.execSQL("DELETE FROM "+TABLE_NAME);
    }
}
